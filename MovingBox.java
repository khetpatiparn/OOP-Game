import java.awt.*;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import java.awt.event.*;
import java.awt.image.BufferedImage;

public class MovingBox extends JFrame {
    // Declare Attribute for Canvas
    public static final int CANVAS_WIDTH = 1366;
    public static final int CANVAS_HEIGHT = 768;

    // Declare Attribut for Wall
    // Box
    TheBox box;
    // Wall

    // Custom Drawing canvas
    private DrawCanvas canvas;

    public MovingBox(){
        // Constructor Canvas
        canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        
        // ContentPane
        setContentPane(canvas);
        
        // Construct the Box
        box = new TheBox();

        // Register MousMotionListener 
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                box.x = e.getX() - 33;
                box.y = e.getY() - 55;
                repaint();
        }
        });

        // Frame and Layout Manager
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MapBeta");
        pack();
        setVisible(true);
    }

    // inner class for Draw Canvas
    private class DrawCanvas extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.BLACK);
            g.setColor(box.color);
            g.fillRect(box.x, box.y, box.size, box.size);
        }
    }

    public static void main(String[] args) {
        new MovingBox();
    }

}
