package d.max.gmail.common.client;

import java.util.Properties;

/**
 * @user: Maxim Dybarskiy | maxim.dybarskyy@gmail.com
 * @date: 9/7/13
 * @time: 9:51 PM
 */
public class ConnectionSettings {
    
    private static final int TIMEOUT = 10000;
    private static final int PORT = 993;
    private static final String HOST = "imap.gmail.com";
    private static final String PROTOCOL = "imaps";
    public static final String STORE = "imaps";
    
    public static class Builder {
        public static Properties build() {
            return System.getProperties();
        }
    }
    
    public static class GmailBuilder extends Builder {
        public static Properties build() {
            Properties props = System.getProperties();
            props.setProperty("mail.store.protocol", PROTOCOL);
            props.setProperty("mail.imaps.host", HOST);
            props.setProperty("mail.imaps.port", String.valueOf(PORT));
            props.setProperty("mail.imap.connectiontimeout", String.valueOf(TIMEOUT));
            props.setProperty("mail.imap.timeout", String.valueOf(TIMEOUT));
            props.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.setProperty("mail.imap.socketFactory.fallback", "false");
            return props;
        }
    }
}
