/**
 * @author Maxim Dybarskiy
 * @date 22.05.2010
 * @time 22:12:51
 */
package max.gmail.notify;

public final class Settings {

    private static Settings instance = null;

    private String user = "maxim.dybarskyy@gmail.com";
    private String pass = "maximillian";
    private String folderName = "madrid";
//    private int delay = 1000 * 60 * 5; // 5 minutes
    private int delay = 1000 * 20;

    private Settings() {
    }

    public static Settings getSettigs() {
        if (instance == null)
            instance = new Settings();
        return instance;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public String toString() {
        return user
                + " | "
                + pass
                + " | "
                + folderName
                + " | "
                + delay;
    }
}
