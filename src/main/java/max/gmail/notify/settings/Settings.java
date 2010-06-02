/**
 * @author Maxim Dybarskiy
 * @date 22.05.2010
 * @time 22:12:51
 */
package max.gmail.notify.settings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public final class Settings implements Serializable {

    private String user = "maxim.dybarskyy@gmail.com";
    private String pass = "maximillian";
    private String folderName = "madrid";
    private int delay = 1000 * 60 * 5; // 5 minutes

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

    public static Settings load() {
        String fileName = System.getProperty("user.home") + "/.netbeans/gmail.cfg";
        Settings res = null;
        FileInputStream fin = null;
        byte[] arr = new byte[1024];
        try {
            fin = new FileInputStream(fileName);
            fin.read(arr);
            res = (Settings) Serializer.deSerializeFromByteArray(arr);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch(IOException ex) {
                
            }
        }
        return res;
    }

    public static boolean save(Settings set) {
        String fileName = System.getProperty("user.home") + "/.netbeans/gmail.cfg";
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(fileName);
            fout.write(Serializer.serializeToByteArray(set));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }  finally {
            try {
                if (fout != null) {
                    fout.close();
                }
            } catch(IOException ex) {

            }
        }
        return true;
    }
}
