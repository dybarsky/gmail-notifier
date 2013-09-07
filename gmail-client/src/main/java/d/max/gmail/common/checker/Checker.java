package d.max.gmail.common.checker;

import d.max.gmail.common.account.Account;
import d.max.gmail.common.client.GmailClient;
import java.util.Iterator;

/**
 * @user: Maxim Dybarskiy | maxim.dybarskyy@gmail.com
 * @date: 9/7/13
 * @time: 10:49 PM
 */
public class Checker<R> {
    
    private final MessageInterpreter<R> interpreter;
    
    public Checker(MessageInterpreter<R> interpreter) {
        this.interpreter = interpreter;
    }
    
    public void checkAccounts(CheckerListener<R> listener, Iterator<Account> iterator) {
        while(iterator.hasNext()) {
//            strategy.executeCheckOperation(createCheckRunnable(listener, iterator.next()));
        }
    }
    
    Runnable createCheckRunnable(final CheckerListener<R> listener, final Account account) {
        return new Runnable() {
            public void run() {
                try {
                    GmailClient client = null;
//            client = new GmailClient(account);
                    R result = interpreter.process(null);
                    listener.onSuccess(account, result);
                } catch (Throwable e) {
                    listener.onFailed(account, e.getMessage());
                }
            }
        };
    }
}
