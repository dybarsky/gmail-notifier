package d.max.gmail.common.checker;

import d.max.gmail.common.account.Account;

/**
 * @user: Maxim Dybarskiy | maxim.dybarskyy@gmail.com
 * @date: Sep 7, 2013
 * @time: 10:57:43 PM
 */
public interface CheckerListener<R> {

    void onSuccess(Account account, R result);
    
    void onFailed(Account account, String errorMessage);
}
