import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameFrame extends JFrame {
    // Panels Map/ Screen
    TitleGameScreen titleGameScreen;

    // Event mouose Action
    MouseAction mouseAction;

    Container cp;

    public GameFrame(){
        // Construct Contentpane
        cp = getContentPane();
        // Add the Screen or Maps
        titleGameScreen = new TitleGameScreen();
        cp.add(titleGameScreen);
        cp.addMouseListener(new StartGame());
        
        // setup frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("The Box Game OOP");
        setLocation(50,50);
        pack();
        setResizable(false);
        setVisible(true);
    }
    public static void main(String[] args) {
        new GameFrame();
    }
    private class StartGame extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if (titleGameScreen.GameStart.getBounds().contains(e.getPoint())){
                System.out.println("Clicked Game Start");
            }
        }
    }
}