package GUI;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import code.Lists;

public class Pilot {

    public static void main(String[] args) {
        Lists sistema = new Lists();
        try {
            ObjectInputStream ooin
                    = new ObjectInputStream(new FileInputStream("emp1.obj"));
            sistema = (Lists) ooin.readObject();
            ooin.close();
        } catch (IOException e) {

        } catch (ClassNotFoundException ec) {

        }

        MainPage mainPage = new MainPage(sistema);
        mainPage.setVisible(true);
    }

}
