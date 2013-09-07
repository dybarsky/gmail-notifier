package d.max.gmail.common.checker;

import d.max.gmail.common.account.Account;
import d.max.gmail.common.client.ConnectionSettings;
import d.max.gmail.common.client.GmailClient;
import d.max.gmail.common.client.GmailException;
import java.lang.reflect.Array;

/**
 * @user: Maxim Dybarskiy | maxim.dybarskyy@gmail.com
 * @date: Sep 8, 2013
 * @time: 1:49:12 AM
 */
public class CheckerFactory<R> {

    public GmailClient createGmailClient(ConnectionSettings settings) {
        
        
        return null;
    }
    
    public Runnable createCheckRunnable(final CheckerListener<R> listener, final Account account) {
        return new Runnable() {
            public void run() {
                try {
                    GmailClient client = createGmailClient(createSettings());
                    MessageInterpreter<R> interpreter = createInterpreter();
                    
                    client.connect();
                    
                    client.disconnect();
                    
                    R result = interpreter.process(null);
                    listener.onSuccess(account, result);
                } catch (GmailException e) {
                    listener.onFailed(account, e.getMessage());
                }
            }
        };
    }
    
    public MessageInterpreter<R> createInterpreter() {
        return new MessageInterpreter.SimpleInterpreter<Array>();
    }
    
    public ConnectionSettings createSettings() {
        return null;
    }
}
