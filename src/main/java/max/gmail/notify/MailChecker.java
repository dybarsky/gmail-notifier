/**
 * author: Maxim Dybarskiy
 * date:   21.05.2010
 * time:   17:51:29
 */
package max.gmail.notify;

import java.text.DateFormat;
import java.util.Date;
import max.gmail.notify.settings.Settings;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class MailChecker {

    private Store store;
    private Folder folder;

    private static Logger log = Logger.getLogger("Gmail.MailChecker");

    public void connect() throws NoSuchProviderException, MessagingException {
        log("load settings");
        Settings settings = Settings.load();
        log("load properties");
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        log("get session");
        Session session = Session.getDefaultInstance(props, null);
        log("get store");
        store = session.getStore("imaps");
        log("connect");
        store.connect("imap.gmail.com", settings.getUser(), settings.getPass());
        log("get folder");
        folder = store.getFolder(settings.getFolderName());
        log("open folder");
        folder.open(Folder.READ_ONLY);
    }
    public void disconnect() throws NoSuchProviderException, MessagingException {
        log("close folder");
        folder.close(false);
        log("close connection");
        store.close();
    }

    public int getUnreadMessageCount() throws MessagingException {
        if (folder == null)
            return -1;
        else
            return folder.getUnreadMessageCount();
    }

    public String[] getSubject() throws MessagingException {
        if (folder == null)
            return null;
        else {
            String subj = folder.getMessage(folder.getMessageCount()).getSubject();
            return subj.substring(subj.indexOf(":/ ") + 3).split(" ");
        }
    }

    private static void log(String msg) {
        log.log(Level.INFO, "<" + DateFormat.getDateTimeInstance().format(new Date()) + ">  " + msg);
    }
}
