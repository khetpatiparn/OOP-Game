import java.awt.*;
import javax.swing.*;

public class EmptyWorld extends JFrame{
    // Declare Canvas
    private DrawCanvas canvas;
    private Color canvasColor = new Color(100, 100, 100);  
    public static final int FRAME_WIDTH  = 1366;
    public static final int FRAME_HEIGHT = 768;
    // Wall of 4 Sides
    private Color wallColor = new Color(255, 255, 255);  
    private int topLeftx = 30;
    private int topLefty = 20;

    public EmptyWorld(){
        // Contentpane
        canvas = new DrawCanvas();
        canvas.setBackground(canvasColor);
        setContentPane(canvas);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // pack();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("Empty World");
        setVisible(true);

        System.out.println("Frame " + getBounds());
        System.out.println("Canvas "+ canvas.getBounds());
    }

    // Inner Class for Drawing Canvas
    private class DrawCanvas extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(wallColor);
            g.fillRect(topLeftx, topLefty, canvas.getBounds().width - (2 * topLeftx), canvas.getBounds().height - (2 * topLefty));
        }
    }
    public static void main(String[] args) {
        new EmptyWorld();
    }
}
