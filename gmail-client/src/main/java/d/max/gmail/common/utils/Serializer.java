/**
 * author: Maxim Dybarskiy
 * date:   02.06.2010
 * time:   11:17:15
 */
package d.max.gmail.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

class Serializer {

    private static Logger log = Logger.getLogger(Serializer.class.getSimpleName());

    public static java.lang.Object deSerializeFromByteArray(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bytestream = null;
        ObjectInputStream objectInputStream = null;
        java.lang.Object objectFromNet;
        try {
            bytestream = new ByteArrayInputStream(bytes);    //  this is the bottleneck
            objectInputStream = new ObjectInputStream(bytestream); // this is the bottleneck
            objectFromNet = objectInputStream.readObject();
            return objectFromNet;
        } finally {
            try {
                if (bytestream != null) {
                    bytestream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                log.log(Level.WARNING, e.getMessage());
            }

        }
    }

    public static byte[] serializeToByteArray(Object obj) throws IOException {
        byte[] bytes;
        ByteArrayOutputStream bytestream = null;
        ObjectOutputStream objstream = null;
        try {
            bytestream = new ByteArrayOutputStream();
            objstream = new ObjectOutputStream(bytestream);
            objstream.writeObject(obj);
            objstream.flush();
            objstream.reset();
            bytes = bytestream.toByteArray();
            return bytes;
        } finally {
            try {
                if (bytestream != null) {
                    bytestream.close();
                }
                if (objstream != null) {
                    objstream.close();
                }
            } catch (IOException e) {
                log.log(Level.WARNING, e.getMessage());
            }
        }
    }
}