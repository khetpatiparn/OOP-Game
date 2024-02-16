import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class SelectMap extends JPanel {
    // Window Game Size
    private final int FRAME_WIDTH = 1366;
    private final int FRAME_HEIGHT = 768;
    private final Dimension FRAME_SIZE = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);

    // Constructor for Setup Component
    public SelectMap() {
        setPreferredSize(FRAME_SIZE);
        ImageIcon icon = new ImageIcon("image/Gemini_Generated_Image3.jpg");
        JLabel bgImg = new JLabel();
        bgImg.setIcon(icon);
        // setBackground(Color.RED);
        // Add Panel
        TopPanel topPanel = new TopPanel();
        BottomPanel bottomPanel = new BottomPanel();
        add(topPanel);
        add(bottomPanel);
        add(bgImg);
    }

    // Inner class for Panel Graphics (Label of Select Map)
    private class TopPanel extends JPanel {
        public TopPanel() {
            setPreferredSize(new Dimension(1366, 150));
            setBackground(Color.RED);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setFont(new Font("Arial", Font.BOLD, 24));
            g.drawString("Select Map", getWidth() / 2 - 60, 80); 
        }
    }

    // Inner class for Panel Map (Select Map action)
    private class BottomPanel extends JPanel {
        // Declare Components
        JButton chMap1, chMap2, chMap3, chMap4, chMap5, chMap6, chMap7, chMap8, chMap9, chMap10;

        public BottomPanel() {
            setLayout(new GridLayout(2, 5, 20, 20)); // 2 rows, 5 cols, with gaps
            setBackground(Color.RED);
            // Create, label, and add buttons
            // Button 1
            // ImageIcon imageIcon = new ImageIcon("image/Gemini_Generated_Image4.jpg"); // Replace with your image path
            // Image image = imageIcon.getImage(); // Get the underlying image
            // Image scaledImage = image.getScaledInstance(chMap1.getWidth(), chMap1.getHeight(), Image.SCALE_SMOOTH); // Scale the image
            // ImageIcon resizedImageIcon = new ImageIcon(scaledImage); // Create a new ImageIcon
            // chMap1 = new JButton(resizedImageIcon);
            chMap1 = new JButton();
            add(chMap1);
            chMap2 = new JButton("Map 2");
            add(chMap2);
            chMap3 = new JButton("Map 3");
            add(chMap3);
            chMap4 = new JButton("Map 4");
            add(chMap4);
            chMap5 = new JButton("Map 5");
            add(chMap5);
            chMap6 = new JButton("Map 6");
            add(chMap6);
            chMap7 = new JButton("Map 7");
            add(chMap7);
            chMap8 = new JButton("Map 8");
            add(chMap8);
            chMap9 = new JButton("Map 9");
            add(chMap9);
            chMap10 = new JButton("Map 10");
            add(chMap10);
            
            setPreferredSize(new Dimension(1200, 500));
        }
    }
}
