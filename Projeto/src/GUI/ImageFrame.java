package GUI;

import javax.swing.JFrame;

public class ImageFrame extends JFrame {

    JFrame frame = new JFrame();

    public ImageFrame() {
        super("GardenCorporation App");
        add(new ImagePanel());
        setSize(300, 300);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

}
