/**
 * author: Maxim Dybarskiy
 * date:   21.05.2010
 * time:   17:50:44
 */
package max.gmail.notify;

import max.gmail.notify.settings.Settings;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.Icon;
import org.openide.awt.NotificationDisplayer;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;

public class Notifier extends TimerTask {

    private Icon icon = ImageUtilities.loadImageIcon("max/gmail/notify/burn.png", false);
    private int previousCount = 0;
    private MailChecker mc = null;
    private static Timer timer = null;

    private static Logger log = Logger.getLogger("Gmail.Notifier");

    private void connect() throws MessagingException {
        mc = new MailChecker();
    }

    @Override
    public void run() {
        try {
            if (mc == null) {
                connect();
            }
            int count = mc.getUnreadMessageCount();
            if (count > 0 && count != previousCount) {
                notify(loc("mail.update_main"), getDetalied(), null);
            }
            previousCount = count;
        } catch (MessagingException ex) {
            log.log(Level.WARNING, ex.getMessage());
        }
    }

    private String getDetalied() throws MessagingException {
        return mc.getSubject()[0] + " "
                + mc.getSubject()[1] + " "
                + mc.getSubject()[2];
    }

    private void notify(String message, String detalied, ActionListener listener) {
        if (message == null) {
            message = "";
        }
        if (detalied == null) {
            detalied = "";
        }
        NotificationDisplayer.getDefault().notify(message, icon, detalied, listener);
    }

    public static void start() {
        Settings s = Settings.load();
        if (s == null)
            return;
        timer = new Timer(true);
        timer.schedule(new Notifier(), 10000, s.getDelay());
    }

    public static void stop() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
        timer = null;
    }

    private static String loc(String key) {
        return NbBundle.getMessage(Notifier.class, key);
    }
}
