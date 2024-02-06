import java.awt.*;
import javax.swing.*;

public class test extends JFrame{
    int width = 1366;
    int height = 768;


    public test(){
        Container cp = getContentPane();
        cp.setPreferredSize(new Dimension(width, height));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width,height);
        setVisible(true);
        System.out.println(getSize());
        System.out.println(getLocation());
        System.out.println("##############");
        System.out.println(cp.getSize());
        System.out.println(cp.getLocation());


    }
    public static void main(String[] args) {
        new test();
    }
}
