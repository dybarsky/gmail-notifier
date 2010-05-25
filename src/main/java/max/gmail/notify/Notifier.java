/**
 * author: Maxim Dybarskiy
 * date:   21.05.2010
 * time:   17:50:44
 */
package max.gmail.notify;

import java.awt.event.ActionListener;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.swing.Icon;
import org.openide.awt.NotificationDisplayer;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;

public class Notifier implements Runnable {

    private Icon icon = ImageUtilities.loadImageIcon("max/gmail/notify/burn.png", false);
    private Settings settings = Settings.getSettigs();
    private int previousCount = 0;
    MailChecker mc = null;

    public Notifier() {
        connect();
    }

    private void connect() {
        try {
            mc = new MailChecker();
        } catch (NoSuchProviderException ex) {
            Exceptions.attachMessage(ex, loc("mail.no_provider"));
        } catch (MessagingException ex) {
            Exceptions.attachMessage(ex, loc("mail.error"));
        }
    }

    public void run() {
        while (true) {
            try {
                if (mc == null) {
                    throw new IllegalStateException("mailchecker == null");
                }
                int count = mc.getUnreadMessageCount();
                if (count > 0 && count != previousCount) {
                    notify(loc("mail.update"), null, null);
                    previousCount = count;
                }
                Thread.sleep(settings.getDelay());
            } catch (MessagingException ex) {
                Exceptions.attachMessage(ex, loc("mail.error"));
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                this.start();
            } catch (IllegalStateException ex) {
                Exceptions.attachMessage(ex, loc("mail.error"));
            }
            finally {
                if (mc == null) {
                    connect();
                }
            }
        }
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
        new Thread(new Notifier()).start();
    }

    private static String loc(String key) {
        return NbBundle.getMessage(Notifier.class, key);
    }
}
