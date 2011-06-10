/**
 * author: Maxim Dybarskiy
 * date:   Jun 10, 2011
 * time:   2:31:16 PM
 */
package max.gmail.notify.settings;

import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

public class SettingsTest {

    @Test
    public void encryptorTest() {
        byte[] original = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] encrypted = Encryptor.encrypt(original);
        Assert.assertNotNull(encrypted);
        byte[] decrypted = Encryptor.decrypt(encrypted);
        Assert.assertNotNull(decrypted);
        Assert.assertArrayEquals(decrypted, original);
    }
    
    @Test
    public void serializerTest() {
        try {
            Date original = new Date(System.currentTimeMillis());
            byte[] serialized = Serializer.serializeToByteArray(original);
            Assert.assertNotNull(serialized);
            Date deserialized = (Date) Serializer.deSerializeFromByteArray(serialized);
            Assert.assertNotNull(deserialized);
            Assert.assertEquals(deserialized, original);
        } catch(Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void settingsTest() {
        Settings original = new Settings();
        original.setUser("username");
        original.setPass("password");
        original.setFolderName("inbox");
        original.setDelay(20);
        Settings.save(original);
        Settings loaded = Settings.load();
        Assert.assertNotNull(loaded);
        Assert.assertEquals(loaded, original);
    }
}

