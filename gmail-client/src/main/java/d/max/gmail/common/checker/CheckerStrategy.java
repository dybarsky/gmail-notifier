package d.max.gmail.common.checker;

/**
 * @user: Maxim Dybarskiy | maxim.dybarskyy@gmail.com
 * @date: 9/7/13
 * @time: 10:52 PM
 */
public abstract class CheckerStrategy {
    
    public static CheckerStrategy createInstance(boolean isAsync) {
        return isAsync ? new AsyncCheckStrategy() : new SyncCheckStrategy();
    }

    public abstract void executeCheckOperation(Runnable operation);
}

class AsyncCheckStrategy extends CheckerStrategy {

    public AsyncCheckStrategy() {
    }

    @Override
    public void executeCheckOperation(Runnable operation) {
    }
}

class SyncCheckStrategy extends CheckerStrategy {

    public SyncCheckStrategy() {
    }

    @Override
    public void executeCheckOperation(Runnable operation) {
    }
}