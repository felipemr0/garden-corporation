/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension;
public class PanelImagem extends JPanel {
    private JButton entrar ;
    private JButton sair;
    @Override
    public void paintComponent(Graphics g) {
        Dimension  tam = getSize();
        ImageIcon imagem = new ImageIcon(new ImageIcon(getClass().getResource("/imagem/1970499.jpg")).getImage());
        g.drawImage(imagem.getImage(),0 ,0 ,tam.width, tam.height, null);
        
       }
}
