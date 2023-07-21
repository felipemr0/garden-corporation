package code;

import java.io.*;

public class System implements Serializable {

    private Lists l1;

    public System() {
        l1 = new Lists();
    }

    public void saveData(String fich) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fich));
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    public System loadData(System system) throws IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data.obj"));
            system = (System) ois.readObject();
            ois.close();
        } catch (IOException e) {

        } catch (ClassNotFoundException ec) {

        }

        return system;
    }
}
