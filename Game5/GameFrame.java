import javax.swing.*;

public class GameFrame extends JFrame {
    MouseAction mouseAction;
    SelectMap selectMap;
    Map1 map1;
    OutlineforTest test;


    
    public GameFrame(){
        // Construct Panels
        selectMap = new SelectMap();
        // Put the map
        map1 = new Map1();
        test = new OutlineforTest();
        // ContentPane
        setContentPane(selectMap);
        // setContentPane(test);
        
        // Resgister Action and Listener
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