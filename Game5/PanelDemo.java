import java.awt.*;
import javax.swing.*;

public class PanelDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(100,100,500,400);
        f.setTitle("JPanel Example");

        Container c = f.getContentPane();
        c.setBackground(Color.BLACK);
        c.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 300, 300);
        panel.setBackground(Color.yellow);
        c.add(panel);

        JPanel panel2 = new JPanel();
        panel2.setBounds(300, 0, 200, 200);
        panel2.setBackground(Color.RED);
        c.add(panel2);
    }
}
