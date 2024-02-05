import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class MovingBox extends JFrame{
    // Declare Attribute for Canvas
    public static final int CANVAS_WIDTH = 1024;
    public static final int CANVAS_HEIGHT = 768;
    
    // private Box box; // moving object
    // Box Attribute
    private int x;
    private int y;
    private int sqaure = 50;
    private Color color = Color.BLUE;

    // Custom Drawing canvas
    private DrawCanvas canvas;

    public MovingBox(){
        // ContentPane
        Container cp = getContentPane();

        // Constructor Box
        // box = new Box(100, 100,50);

        // Constructor Canvas
        canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        cp.add(canvas);

        // Hiddien Cursor
        // BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        // Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
        // setCursor(blankCursor);

        // addMouseMotionListener(new MouseAdapter() {
        MouseListener listener = new MouseListener();
        addMouseMotionListener(listener);
        // });

        // Frame and Layout Manager
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MapBeta");
        pack();
        setVisible(true);
    }

    // inner class for Canvas
    private class DrawCanvas extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            g.fillRect(x, y, sqaure, sqaure);
        }
    }

    // inner class for MousemotionListener
    private class MouseListener extends MouseMotionAdapter{
        @Override
        public void mouseMoved(MouseEvent e) {
            x = e.getX() - 30;
            y = e.getY() - 50;
            repaint();
        }

    }

    public static void main(String[] args) {
        new MovingBox();
    }
}
