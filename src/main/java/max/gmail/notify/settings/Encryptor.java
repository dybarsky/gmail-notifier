/**
 * author: Maxim Dybarskiy
 * date:   Jun 10, 2011
 * time:   2:18:18 PM
 */
package max.gmail.notify.settings;

class Encryptor {
    
    public static byte[] encrypt(byte[] data) {
        byte[] res = new byte[data.length];
        for (int i=0; i<data.length; i++) {
            res[i] = (byte) (data[i] + 1);
        }
        return res;
    }
    
    public static byte[] decrypt(byte[] data) {
        byte[] res = new byte[data.length];
        for (int i=0; i<data.length; i++) {
            res[i] = (byte) (data[i] - 1);
        }
        return res;
    }
}
