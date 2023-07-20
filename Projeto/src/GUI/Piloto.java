package GUI;
import GUI.FrameImagem;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import code.Listas;
import code.Sistema;
public class Piloto {


    public static void main(String[] args) {
        Sistema sist = new Sistema();
        Listas sistema = new Listas();
        try {
          ObjectInputStream ooin = 
                new ObjectInputStream(new FileInputStream("emp1.obj"));
           sistema = (Listas) ooin.readObject();
          ooin.close();
      }
      catch(IOException e) {}
      catch(ClassNotFoundException ec) {};
        
        Pagprinc inicio = new Pagprinc(sistema);
        inicio.setVisible(true);
    }
    
}
