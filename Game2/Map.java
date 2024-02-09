import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Map extends JFrame{
    // Top bar coordinates
    protected static int barX = 8;
    protected static int barY = 31;
    // Map Size
    private static final int WIDTH = 1366;
    private static final int HEIGHT = 768;
    private Dimension dim = new Dimension(WIDTH, HEIGHT);
    // Declare Map
    DrawMap map;
    // Declare Box
    TheBox box;
    private boolean isMouseInsideBox = false;


    public Map(){
        // Construct Map
        map = new DrawMap();
        setPreferredSize(dim);
        setContentPane(map);
        // Construct Box
        box = new TheBox(100 - barX, 100 - barY, 30);
        // Construct Mouse Action
        MouseMoveAction mouseAction = new MouseMoveAction();
        addMouseMotionListener(mouseAction);

        // Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Map");
        pack();
        setVisible(true);
    }
    // Drawing on Graphics
    private class DrawMap extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            box.paintBox2(g);
        }
    }

    // Main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Map();
            }
        });
    }
    // Mouse Move Action
    private class MouseMoveAction extends MouseAdapter{
        @Override
            public void mouseMoved(MouseEvent e) {
                int cursorX = e.getX();
                int cursorY = e.getY();
                if (isMouseInsideBox) {
                    box.startX = cursorX - barX - box.sizeBox / 2;
                    box.startY = cursorY - barY - box.sizeBox / 2;
                    // System.out.println(e.getPoint());
                } else {
                    if ((cursorX > box.startX + barX && cursorX < box.startX + barX + box.sizeBox) && (cursorY > box.startY + barY && cursorY < box.startY + barY + box.sizeBox)) {
                        isMouseInsideBox = true;
                    }
                }
                repaint();
            }
    }

}
