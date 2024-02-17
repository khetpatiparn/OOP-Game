import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameFrame extends JFrame {
    // Panels Map/ Screen
    TitleGameScreen titleGameScreen;
    SelectMapScreen selectMapScreen;
    Map0 map0;

    Container cp;

    public GameFrame(){
        // Construct Contentpane
        cp = getContentPane();
        // Add the Screen or Maps
        titleGameScreen = new TitleGameScreen();
        selectMapScreen = new SelectMapScreen();
        map0 = new Map0();

        cp.add(titleGameScreen);
        // cp.add(selectMapScreen);
        // cp.add(map0);

        // Event-Handler Control Map / Screen
        titleGameScreen.addMouseListener(new NavigationTitleScreen()); // Event TitleScreen
        selectMapScreen.addMouseListener(new NavigationSelectMapScreen()); // EVent SelectMapScreen
        map0.addMouseListener(new NavBackMap()); // Event Map0
        
        // setup frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("The Box Game OOP");
        setLocation(50,50);
        pack();
        setResizable(false);
        setVisible(true);
    }
    // Inner Class Event for Title Screen 
    private class NavigationTitleScreen extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if(titleGameScreen.GameStart.getBounds().contains(e.getPoint()) && titleGameScreen.GameStart.isShowing()){
                System.out.println("==> GameStart Button's clicked");
                cp.remove(titleGameScreen);
                cp.add(selectMapScreen);
                cp.revalidate();
                cp.repaint();
                System.out.println("-----------------------------");
                System.out.println("Select Map Screen's showing");
            }else if(titleGameScreen.Credits.getBounds().contains(e.getPoint()) && titleGameScreen.Credits.isShowing()){
                System.out.println("==>  Button's clicked");
            }else if(titleGameScreen.Exit.getBounds().contains(e.getPoint()) && titleGameScreen.Exit.isShowing()){
                System.out.println("==> Exit Button's clicked");
                System.exit(0);
            }
        }
    }

    // Inner Class Event for Select Map Screen 
    private class NavigationSelectMapScreen extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if (selectMapScreen.map[0].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 0 Button's clicked");
                System.out.println("Map 0 's showing");
                cp.remove(selectMapScreen);
                cp.add(map0);
                cp.revalidate();
                cp.repaint();

            }else if (selectMapScreen.map[1].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 1 Button's clicked");
                System.out.println("Map 1 's showing");
                // cp.remove(selectMapScreen);
                // cp.add(map1);
                // cp.revalidate();
                // cp.repaint();

            }else if (selectMapScreen.map[2].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 2 Button's clicked");
                System.out.println("Map 2 's showing");
                // cp.remove(selectMapScreen);
                // cp.add(map2);
                // cp.revalidate();
                // cp.repaint();

            }
            else if (selectMapScreen.map[3].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 3 Button's clicked");
                System.out.println("Map 3 's showing");
                // cp.remove(selectMapScreen);
                // cp.add(map3);
                // cp.revalidate();
                // cp.repaint();

            }
            else if (selectMapScreen.map[4].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 4 Button's clicked");
                System.out.println("Map 4 's showing");
                // cp.remove(selectMapScreen);
                // cp.add(map4);
                // cp.revalidate();
                // cp.repaint();

            }
            else if (selectMapScreen.map[5].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 5 Button's clicked");
                System.out.println("Map 5 's showing");
                // cp.remove(selectMapScreen);
                // cp.add(map5);
                // cp.revalidate();
                // cp.repaint();

            }else if (selectMapScreen.map[6].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 6 Button's clicked");
                System.out.println("Map 6 's showing");
                // cp.remove(selectMapScreen);
                // cp.add(map6);
                // cp.revalidate();
                // cp.repaint();
                
            }else if (selectMapScreen.map[7].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 7 Button's clicked");
                System.out.println("Map 7 's showing");
                // cp.remove(selectMapScreen);
                // cp.add(map7);
                // cp.revalidate();
                // cp.repaint();
                
            }else if (selectMapScreen.map[8].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 8 Button's clicked");
                System.out.println("Map 8 's showing");
                // cp.remove(selectMapScreen);
                // cp.add(map8);
                // cp.revalidate();
                // cp.repaint();
                
            }else if (selectMapScreen.map[9].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 9 Button's clicked");
                System.out.println("Map 9 's showing");
                // cp.remove(selectMapScreen);
                // cp.add(map9);
                // cp.revalidate();
                // cp.repaint();
                
            }else if (selectMapScreen.map[10].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 10 Button's clicked");
                System.out.println("Map 10 's showing");
                // cp.remove(selectMapScreen);
                // cp.add(map10);
                // cp.revalidate();
                // cp.repaint();
                
            }else if (selectMapScreen.map[11].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 11 Button's clicked");
                System.out.println("Map 11 's showing");
                // cp.remove(selectMapScreen);
                // cp.add(map11);
                // cp.revalidate();
                // cp.repaint();
                
            // Back Button
            }else if (selectMapScreen.BackBtn.getBounds().contains(e.getPoint())){
                System.out.println("==> Back Button's clicked");
                cp.remove(selectMapScreen);
                cp.add(titleGameScreen);
                cp.revalidate();
                cp.repaint();
                System.out.println("-----------------------------");
                System.out.println("Game Title Screen's showing");
            }
        }
    }

    // Inner Class Event for Back to Select Map Screen
    private class NavBackMap extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            if (map0.homeBtn.getBounds().contains(e.getPoint())){
                System.out.println("==> Home Button's clicked");
                cp.remove(map0);
                cp.add(selectMapScreen);
                cp.revalidate();
                cp.repaint();
                System.out.println("Back to Select Map Screen...");
                System.out.println("-----------------------------");
            }
        }
    }

    public static void main(String[] args) {
        new GameFrame();
    }
}