import javax.swing.*;

public class GameFrame extends JFrame {
    MouseAction mouseAction;
    ChooseMapPage chooseMap;
    Map1 map1;


    
    public GameFrame(){
        // Construct Panels
        chooseMap = new ChooseMapPage();
        // Put the map
        map1 = new Map1();

        // ContentPane
        setContentPane(map1);
        
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