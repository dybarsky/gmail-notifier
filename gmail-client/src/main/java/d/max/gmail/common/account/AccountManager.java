package d.max.gmail.common.account;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @user: Maxim Dybarskiy | maxim.dybarskyy@gmail.com
 * @date: 9/7/13
 * @time: 9:47 PM
 */
public class AccountManager {
    
    private List<Account> accounts = new CopyOnWriteArrayList<Account>();
    
    public void addAccount(Account account) {
        accounts.add(account);
    } 
    
    public void removeAccount(Account account) {
        accounts.remove(account);
    }
    
    
}
