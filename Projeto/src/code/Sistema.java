package code;
import code.Listas;
import java.io.*;
public class Sistema implements Serializable {
    
    private Listas l1 ;
    public Sistema () {
        l1 = new Listas();        
    }
    /**Método que permite gravas os dados para um determinado ficheiro
     * 
     * @param fich String
     * @throws IOException 
     */
     public void gravaObj(String fich) throws IOException {
      ObjectOutputStream oos = new ObjectOutputStream(
                                new FileOutputStream(fich));
      oos.writeObject(this);
      oos.flush(); oos.close();
  }
     /**Método que permite carregar os dados 
      * 
      * @param sistema Sistema
      * @return Sistema
      * @throws IOException 
      */
     public Sistema carregaDados (Sistema sistema) throws IOException {
         try {
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Dados.obj"));
             sistema = (Sistema) ois.readObject();
             ois.close();
         }
         catch(IOException e) {}
         catch(ClassNotFoundException ec) {};
         
         return sistema ;
     }
}