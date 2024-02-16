import javax.swing.*;
import java.awt.*;

public class OutlineforTest extends JPanel {
    // Window Game Size
    private final int FRAME_WIDTH = 1366;
    private final int FRAME_HEIGHT = 768;
    private final Dimension FRAME_SIZE = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);

    String img_1 = "image/Gemini_Generated_Image9.jpg";
    ImageIcon bgIcon, bgIcon2;
    JButton btn, btn2;
    // Constructor for Setup Component
    public OutlineforTest() {
        setBackground(Color.BLACK);
        setPreferredSize(FRAME_SIZE);
        setLayout(new BorderLayout()); 

        btn = new JButton();
        btn.setBounds(100, 100, 150, 150);
        // JLabel bgBtn1 = new JLabel();
        // bgIcon2 = new ImageIcon("image/Gemini_Generated_Image4.jpg");
        // bgBtn1.setPreferredSize(new Dimension(bgIcon2.getIconWidth(), bgIcon2.getIconHeight()));
        // bgBtn1.setIcon(bgIcon2);
        // btn.add(bgBtn1);
        add(btn);

        btn2 = new JButton();
        btn2.setBounds(300, 100, 150, 150);
        add(btn2);
        // Add image to JPanel 
        // bgIcon = new ImageIcon(img_1);
        // JLabel bgImg = new JLabel();
        // bgImg.setIcon(bgIcon);
        // bgImg.setPreferredSize(FRAME_SIZE);
        // add(bgImg);



    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setContentPane(new OutlineforTest());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.pack();
        f.setVisible(true);
    }
}
