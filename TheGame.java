import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TheGame extends JFrame {
    private static int barX = 8;
    private static int barY = 31;
    DrawWorld canvas;
    private int startX = 100 - barX;
    private int startY = 100 - barY; 
    private int sizeBox = 30;
    private Color colorBox = Color.GREEN;

    private boolean isMouseInsideBox = false;

    public TheGame() {
        canvas = new DrawWorld();
        setPreferredSize(new Dimension(1366, 768));
        setLayout(new FlowLayout());
        setContentPane(canvas);
        
        
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int cursorX = e.getX();
                int cursorY = e.getY();
                if (isMouseInsideBox) {
                    startX = cursorX - barX - sizeBox / 2;
                    startY = cursorY - barY - sizeBox / 2;
                    // System.out.println(e.getPoint());
                    repaint();
                } else {
                    if ((cursorX > startX && cursorX < startX + sizeBox) || (cursorY > startY && cursorY < startY + sizeBox)) {
                        isMouseInsideBox = true;
                    }
                }
            }
        });
        // Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game");
        pack();
        setVisible(true);
        repaint();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TheGame();
            }
        });
    }
    
    public void paintBox(Graphics g) {
        g.setColor(colorBox);
        g.fillRect(startX, startY, sizeBox, sizeBox);
    }
    
    private class DrawWorld extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // paintBox(g);
            Graphics2D g2d = (Graphics2D) g;
            Shape sqaure = new Rectangle(startX, startY, sizeBox, sizeBox);
            g2d.fill(sqaure);
        }
    }
}