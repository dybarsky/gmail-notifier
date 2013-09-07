package d.max.gmail.common.account;

import d.max.gmail.common.checker.Checker;
import d.max.gmail.common.checker.CheckerListener;
import d.max.gmail.common.checker.MessageInterpreter;
import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @user: Maxim Dybarskiy | maxim.dybarskyy@gmail.com
 * @date: 9/7/13
 * @time: 9:47 PM
 */
public class AccountManager {
    
    private List<Account> accounts = new CopyOnWriteArrayList<Account>();
    private CheckerListener<Array> listener;
    private Checker<Array> checker; 

    public AccountManager(CheckerListener<Array> listener) {
        this.listener = listener;
        this.checker = new Checker<Array>(createInterpreter());
    }
    
    public void addAccount(Account account) {
        accounts.add(account);
        checker.checkAccounts(listener, accounts.iterator());
    } 
    
    public void removeAccount(Account account) {
        accounts.remove(account);
        checker.checkAccounts(listener, accounts.iterator());
    }
    
    MessageInterpreter<Array> createInterpreter() {
        return new MessageInterpreter.SimpleInterpreter<Array>();
    }
}
