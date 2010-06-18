/**
 * author: Maxim Dybarskiy
 * date:   21.05.2010
 * time:   17:51:29
 */
package max.gmail.notify;

import max.gmail.notify.settings.Settings;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class MailChecker {

    private Store store;
    private Folder folder;

    public MailChecker() throws NoSuchProviderException, MessagingException {
        Settings settings = Settings.load();
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        Session session = Session.getDefaultInstance(props, null);
        store = session.getStore("imaps");
        store.connect("imap.gmail.com", settings.getUser(), settings.getPass());
        folder = store.getFolder(settings.getFolderName());
        folder.open(Folder.READ_ONLY);
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
}
