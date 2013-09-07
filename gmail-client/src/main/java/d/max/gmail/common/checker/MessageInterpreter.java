package d.max.gmail.common.checker;

import javax.mail.Message;

/**
 * @user: Maxim Dybarskiy | maxim.dybarskyy@gmail.com
 * @date: Sep 7, 2013
 * @time: 11:25:51 PM
 */
public interface MessageInterpreter<R> {

    R process(Message message);
    
    
    
    public static class SimpleInterpreter<Array> implements MessageInterpreter {

        public String[] process(Message message) {
            return null;
        }
    }
    
    public static class BitbucketInterpreter<String> implements MessageInterpreter {

        public String process(Message message) {
            return null;
        }
    }
    
}
