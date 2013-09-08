package d.max.gmail.common.checker;

import java.util.Iterator;
import javax.mail.Message;

/**
 * @user: Maxim Dybarskiy | maxim.dybarskyy@gmail.com
 * @date: Sep 7, 2013
 * @time: 11:25:51 PM
 */
public interface MessageInterpreter<R> {

    R process(Iterator<Message> messages);
    
    
    
    public static class SimpleInterpreter<Array> implements MessageInterpreter<String[]> {

        public String[] process(Iterator<Message> messages) {
            return null;
        }
    }
    
    public static class BitbucketInterpreter<String> implements MessageInterpreter<String> {

        public String process(Iterator<Message> messages) {
            return null;
        }
    }
    
}
