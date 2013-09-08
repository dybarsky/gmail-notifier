package d.max.gmail.common.checker;

import d.max.gmail.common.account.Account;
import d.max.gmail.common.client.ConnectionSettings;
import d.max.gmail.common.client.GmailClient;
import d.max.gmail.common.client.GmailException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Properties;
import javax.mail.Message;

/**
 * @user: Maxim Dybarskiy | maxim.dybarskyy@gmail.com
 * @date: Sep 8, 2013
 * @time: 1:49:12 AM
 */
public class CheckerFactory<R> {

    public GmailClient createGmailClient(Properties properties, Account account) {
        return new GmailClient(account, properties);
    }
    
    public Runnable createCheckRunnable(final CheckerListener<R> listener, final Account account) {
        return new Runnable() {
            public void run() {
                try {
                    GmailClient client = createGmailClient(createSettings(), account);
                    MessageInterpreter<R> interpreter = createInterpreter();
                    
                    client.connect();
                    Iterator<Message> iterator = client.createMessagesIterator(isOnlyLastMessage());
                    R result = interpreter.process(iterator);
                    listener.onSuccess(account, result);
                    client.disconnect();
                    
                } catch (GmailException e) {
                    listener.onFailed(account, e.getMessage());
                }
            }
        };
    }
    
    public MessageInterpreter<R> createInterpreter() {
        return new MessageInterpreter.SimpleInterpreter();
    }
    
    public Properties createSettings() {
        return ConnectionSettings.GmailBuilder.build();
    }
    
    public boolean isOnlyLastMessage() {
        return true;
    }
}
