package code;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Helper {
    
    public static void saveObj(String path, Object object) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(object);
            oos.flush();
            oos.close();
        } catch (IOException exception) {

        }
    }
    
    public static <T> T readObj(String path, T object) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
            object = (T) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException e) {
            java.lang.System.out.println(e.getMessage());
        } catch (ClassNotFoundException ec) {
            java.lang.System.out.println(ec.getMessage());
        }
        
        return object;
    }
       
}
