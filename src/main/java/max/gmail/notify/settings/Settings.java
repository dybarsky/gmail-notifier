/**
 * @author Maxim Dybarskiy
 * @date 22.05.2010
 * @time 22:12:51
 */
package max.gmail.notify.settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Settings implements Serializable {

    private static Logger log = Logger.getLogger("Gmail.Settings");

    private String user;
    private String pass;
    private String folderName;
    private int delay;

    public Settings() {
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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Settings other = (Settings) obj;
        if ((this.user == null) ? (other.user != null) : !this.user.equals(other.user)) {
            return false;
        }
        if ((this.pass == null) ? (other.pass != null) : !this.pass.equals(other.pass)) {
            return false;
        }
        if ((this.folderName == null) ? (other.folderName != null) : !this.folderName.equals(other.folderName)) {
            return false;
        }
        if (this.delay != other.delay) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.user != null ? this.user.hashCode() : 0);
        hash = 13 * hash + (this.pass != null ? this.pass.hashCode() : 0);
        hash = 13 * hash + (this.folderName != null ? this.folderName.hashCode() : 0);
        hash = 13 * hash + this.delay;
        return hash;
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

    public static synchronized Settings load() {
        File file = new File(System.getProperty("user.home") + "/.gmail.cfg");
        Settings res = null;
        FileInputStream fin = null;
        byte[] arr = new byte[1024];
        try {
            fin = new FileInputStream(file);
            fin.read(arr);
            res = (Settings) Serializer.deSerializeFromByteArray(arr);
        } catch (FileNotFoundException ex) {
            log.log(Level.WARNING, ex.getMessage());
        } catch (IOException ex) {
            log.log(Level.WARNING, ex.getMessage());
        } catch (Exception ex) {
            log.log(Level.WARNING, ex.getMessage());
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch(IOException ex) {
                log.log(Level.WARNING, ex.getMessage());
            }
        }
        return res;
    }

    public static synchronized boolean save(Settings set) {
        File file = new File(System.getProperty("user.home") + "/.gmail.cfg");
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(file);
            fout.write(Serializer.serializeToByteArray(set));
        } catch (FileNotFoundException ex) {
            log.log(Level.WARNING, ex.getMessage());
            return false;
        } catch (IOException ex) {
            log.log(Level.WARNING, ex.getMessage());
            return false;
        } catch (Exception ex) {
            log.log(Level.WARNING, ex.getMessage());
            return false;
        }  finally {
            try {
                if (fout != null) {
                    fout.close();
                }
            } catch(IOException ex) {
                log.log(Level.WARNING, ex.getMessage());
            }
        }
        return true;
    }
}
