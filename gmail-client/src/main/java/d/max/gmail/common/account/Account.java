package d.max.gmail.common.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @user: Maxim Dybarskiy | maxim.dybarskyy@gmail.com
 * @date: 9/7/13
 * @time: 6:21 PM
 */
public class Account implements Serializable {
    
    private String email;
    private String password;
    private List<String> folderNames = new ArrayList<String>();
    private int delay;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getFolderNames() {
        return folderNames;
    }

    public void setFolderNames(List<String> folderNames) {
        this.folderNames = folderNames;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 17 * hash + (this.password != null ? this.password.hashCode() : 0);
        hash = 17 * hash + (this.folderNames != null ? this.folderNames.hashCode() : 0);
        hash = 17 * hash + this.delay;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        if (this.folderNames != other.folderNames && (this.folderNames == null || !this.folderNames.equals(other.folderNames))) {
            return false;
        }
        if (this.delay != other.delay) {
            return false;
        }
        return true;
    }

    
}
