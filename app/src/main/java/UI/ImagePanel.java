package UI;

import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class ImagePanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        Dimension tam = getSize();
        ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource("/imagem/1970499.jpg")).getImage());
        g.drawImage(image.getImage(), 0, 0, tam.width, tam.height, null);
    }
}
