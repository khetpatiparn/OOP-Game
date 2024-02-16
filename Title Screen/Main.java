import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rectangle Moving on an Inclined Plane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel panel = new Panel();
        frame.add(panel);

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}

class Rectangle1 {

    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle1(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void draw(Graphics g) {
        g.fillRect(x, y, width, height);
    }
}

class Panel extends JPanel implements ActionListener {

    private Timer timer;
    private Rectangle1 rectangle;

    public Panel() {
        timer = new Timer(10, this);
        timer.start();

        rectangle = new Rectangle1(100, 100, 50, 50);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // วาดพื้นที่เอียง

        // วาด Rectangle
        rectangle.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // เคลื่อนที่ Rectangle ตามพื้นที่เอียง
        int dx = (int) (Math.cos(Math.toRadians(30)) * 5);
        int dy = (int) (Math.sin(Math.toRadians(30)) * 5);
        rectangle.move(dx, dy);

        repaint();
    }
}
