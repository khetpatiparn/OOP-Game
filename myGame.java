import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class myGame extends JFrame{
    // Construct Frame
    private final int FRAME_WIDTH  = 1366;
    private final int FRAME_HEIGHT = 768;

    // Construct canvas/World 
    private DrawWorld canvas;
    private Color innerWorld = Color.BLACK; 
    private Color outerWorld = Color.GREEN; 
    private int topLeftx = 30;
    private int topLefty = 20;


    // Construct The Box
    private int startX = 100;
    private int startY = 100;
    private int sizeBox = 50;
    private Color colorBox = Color.WHITE;

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
        // Register Collistion the Wall
        

        // Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game");
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setVisible(true);

        // Check Values
        System.out.println(getLocation());
        System.out.println(canvas.getBounds());
        System.out.println("Location Block is : " + startX + " , "+ startY);
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
        g.fillRect(startX, startY, sizeBox, sizeBox); // drawing Sqaure
    }
    // Inner Class for MousMotion The Box
    private class MotionTheBox extends MouseAdapter{
        @Override
        public void mouseMoved(MouseEvent e) {
            startX = e.getX() - 33;
            startY = e.getY() - 55;
            repaint();
        }
    }
    // Inner Class ActionListener for Collistion the Wall
    // private class CrashTheWall implements ActionListener{
    //     // Declare coordinates
    //     private int bottomRightx = canvas.getBounds().width - (2 * topLeftx);
    //     private int bottomRighty = canvas.getBounds().height - (2 * topLefty);
        
    //     @Override
    //     public void actionPerformed(ActionEvent e) {
    //         if (startX < topLeftx){
    //             startX = topLeftx;
    //         }
    //     }

    // }

    // Main Method
    public static void main(String[] args) {
        new myGame();
    } 
}
