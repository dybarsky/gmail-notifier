package d.max.gmail.common.checker;

import d.max.gmail.common.account.Account;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import static d.max.gmail.common.utils.Object.*;
/**
 * @user: Maxim Dybarskiy | maxim.dybarskyy@gmail.com
 * @date: 9/7/13
 * @time: 10:49 PM
 */
public class Checker<R> {
    
    private final CheckerFactory<R> factory;
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public Checker(CheckerFactory<R> factory) {
        this.factory = notNull(factory);
    }
    
    public void checkAccounts(CheckerListener<R> listener, Iterator<Account> iterator) {
        while(iterator.hasNext()) {
            Account account = notNull(iterator.next());
            executor.schedule(factory.createCheckRunnable(listener, account),                                account.getDelay(), TimeUnit.MINUTES);
        }
    }
}
