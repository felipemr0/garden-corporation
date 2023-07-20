/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import javax.swing.JFrame ;

public class FrameImagem  extends JFrame{
    JFrame frame = new JFrame();
      public FrameImagem(){
        super("Aplicação GardenCorporation");
        add(new PanelImagem());
        setSize(300,300);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        }
    
    
}
