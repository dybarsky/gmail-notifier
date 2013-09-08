/**
 * author: Maxim Dybarskiy
 * date:   21.05.2010
 * time:   17:51:29
 */
package d.max.gmail.common.client;

import d.max.gmail.common.account.Account;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import static d.max.gmail.common.utils.Object.*;

public class GmailClient {

    private Properties properties;
    private Account account;
    private Store store;
    private List<Folder> folders = new ArrayList<Folder>();
    private List<Message> messages = new ArrayList<Message>();

    public GmailClient(Account account, Properties properties) {
        this.account = notNull(account);
        this.properties = properties;
    }
    
    public void connect() throws GmailException {
        Session session = Session.getDefaultInstance(properties);
        try {
            store = session.getStore(ConnectionSettings.STORE);
            store.connect(account.getEmail(), account.getPassword());
            for (String folderName : account.getFolderNames()) {
                Folder folder = store.getFolder(folderName);
                folder.open(Folder.READ_ONLY);
                folders.add(folder);
            }
        } catch (NoSuchProviderException e) {
            throw new GmailException(e);
        } catch (MessagingException e) {
            throw new GmailException(e);
        }
    }
    
    public void disconnect() throws GmailException {
        Exception ex = null;
        for (Folder folder : folders) {
            try {
                folder.close(false);
            } catch (MessagingException e) {
                if (ex != null) {
                    e.addSuppressed(ex);
                    ex = e;
                }
            }
        }
        try {
            store.close();
        } catch (MessagingException e) {
            if (ex != null) {
                e.addSuppressed(ex);
                ex = e;
            }
        }
        if (ex != null) {
            throw new GmailException(ex);
        }
    }

    public Iterator<Message> createMessagesIterator(boolean onlyLast) throws GmailException {
        Exception ex = null;
        for (Folder folder : folders) {
            try {    
                if (onlyLast) {
                    messages.add(folder.getMessage(folder.getMessageCount()));
                } else {
                    for (int i = 0; i< folder.getUnreadMessageCount(); i++) {
                        messages.add(folder.getMessage(folder.getMessageCount() - i));
                    }
                }
            } catch (MessagingException e) {
                if (ex != null) {
                    e.addSuppressed(ex);
                    ex = e;
                }
            }
        }
        if (ex != null && messages.isEmpty()) {
            throw new GmailException(ex);
        }
        return messages.iterator();
    }
}
