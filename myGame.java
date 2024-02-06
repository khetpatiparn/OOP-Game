import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class myGame extends JFrame{
    // Construct Frame
    private final int FRAME_WIDTH  = 1366;
    private final int FRAME_HEIGHT = 768;

    // Construct canvas/World 
    protected DrawWorld canvas;
    protected Color innerWorld = Color.BLACK; 
    protected Color outerWorld = Color.GREEN; 
    protected int topLeftx = 30;
    protected int topLefty = 20;

    // Construct The Box
    protected int org_box_x = 100;
    protected int org_box_y = 100;
    protected int sizeBox = 50;
    protected Color colorBox = Color.WHITE;

    // Constructor to setup Worlds/Maps, Obstacles and The Box
    public myGame() {
        // World
        canvas = new DrawWorld();
        setContentPane(canvas);
        canvas.setBackground(outerWorld);

        // The Box
        // Register the Box and listener
        MotionTheBox listener = new MotionTheBox();
        addMouseMotionListener(listener);

        // Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game");
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setVisible(true);
    }
    // Inner Class for paint World
    private class DrawWorld extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            paintWorld(g);
            paintBox(g);
        }
    }
    // Method for paintWorld on canvas
    public void paintWorld(Graphics g){
        g.setColor(innerWorld);
        g.fillRect(topLeftx, topLefty, canvas.getBounds().width - (2 * topLeftx), canvas.getBounds().height - (2 * topLefty));
    }
    // Method for paint Box on Canvas
    public void paintBox(Graphics g){
        g.setColor(colorBox); // color of box
        g.fillRect(org_box_x, org_box_y, sizeBox, sizeBox); // drawing Sqaure
    }
    // Inner Class for MousMotion The Box
    private class MotionTheBox extends MouseAdapter{

        @Override
        public void mouseMoved(MouseEvent e) {
            org_box_x = e.getX() - 33;
            org_box_y = e.getY() - 55;
            repaint();
        }
    }

    // Main Method
    public static void main(String[] args) {
        new myGame();
    } 
}
