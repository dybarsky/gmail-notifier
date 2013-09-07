package d.max.gmail.common.utils;

/**
 * @user: Maxim Dybarskiy | maxim.dybarskyy@gmail.com
 * @date: Sep 8, 2013
 * @time: 1:40:23 AM
 */
public class Object {

    public static <T> T notNull(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }
}
