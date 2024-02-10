import javax.swing.*;

public class GameFrame extends JFrame {
    Map1 map1;
    MouseAction mouseAction;

    
    public GameFrame(){
        // Put the map
        map1 = new Map1();
        setContentPane(map1);
        
        mouseAction = new MouseAction(map1);
        map1.addMouseMotionListener(mouseAction);
        
        // setup frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("The Box Game OOP");
        setLocation(250,100);
        pack();
        setResizable(false);
        setVisible(true);
    }
    public static void main(String[] args) {
        new GameFrame();
    }
}