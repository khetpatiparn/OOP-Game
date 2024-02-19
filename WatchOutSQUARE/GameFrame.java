import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class GameFrame extends JFrame {
    // Panels Map/ Screen
    TitleGameScreen titleGameScreen;
    SelectMapScreen selectMapScreen;
    CreditsScreen creditsScreen;
    Map0 map0;
    Map1 map1;
    Map2 map2;
    Map3 map3;
    Map4 map4;
    Map5 map5;
    Map6 map6;
    Map7 map7;
    Map8 map8;
    Map9 map9;
    Map10 map10;
    Map11 map11;

    Container cp;

    public GameFrame(){
        // Construct Contentpane
        cp = getContentPane();
        // Add the Screen or Maps
        titleGameScreen = new TitleGameScreen();
        selectMapScreen = new SelectMapScreen();
        creditsScreen = new CreditsScreen();
        map0 = new Map0(this);
        map1 = new Map1(this);
        map2 = new Map2(this);
        map3 = new Map3(this);
        map4 = new Map4(this);
        map5 = new Map5(this);
        map6 = new Map6(this);
        map7 = new Map7(this);
        map8 = new Map8(this);
        map9 = new Map9(this);
        map10 = new Map10(this);
        map11 = new Map11(this);

        // cp.add(titleGameScreen);
        // cp.add(selectMapScreen);
        // cp.add(map0);
        // cp.add(map1);
        // cp.add(map2);
        // cp.add(map3);
        // cp.add(map4);
        // cp.add(map5);
        // cp.add(map6);
        // cp.add(map7);
        // cp.add(map8);
        // cp.add(map9);
        // cp.add(map10);
        cp.add(map11);
        // cp.add(emptyMap);

        // Event-Handler Control Map / Screen
        titleGameScreen.addMouseListener(new NavigationTitleScreen()); // Event TitleScreen
        selectMapScreen.addMouseListener(new NavigationSelectMapScreen()); // EVent SelectMapScreen
        creditsScreen.addMouseListener(new NavBackCredits());
        map0.addMouseListener(new NavBackMap()); // Event Map0
        map1.addMouseListener(new NavBackMap()); // Event Map1
        map2.addMouseListener(new NavBackMap()); // Event Map2
        map3.addMouseListener(new NavBackMap()); // Event Map3
        map4.addMouseListener(new NavBackMap()); // Event Map4
        map5.addMouseListener(new NavBackMap()); // Event Map5
        map6.addMouseListener(new NavBackMap()); // Event Map6
        map7.addMouseListener(new NavBackMap()); // Event Map7
        map8.addMouseListener(new NavBackMap()); // Event Map8
        map9.addMouseListener(new NavBackMap()); // Event Map9
        map10.addMouseListener(new NavBackMap()); // Event Map10
        map11.addMouseListener(new NavBackMap()); // Event Map11
        
        // setup frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Watch Out,SQUARE!!");
        setLocation(0,0);
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
                System.out.println("==> Credits Button's clicked");
                titleGameScreen.add(creditsScreen);
                titleGameScreen.setComponentZOrder(creditsScreen, 0);
                cp.revalidate();
                cp.repaint();
                System.out.println("-----------------------------");
                System.out.println("Select Map Screen's showing");
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
                cp.remove(selectMapScreen);
                cp.add(map1);
                cp.revalidate();
                cp.repaint();

            }else if (selectMapScreen.map[2].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 2 Button's clicked");
                System.out.println("Map 2 's showing");
                cp.remove(selectMapScreen);
                cp.add(map2);
                cp.revalidate();
                cp.repaint();

            }
            else if (selectMapScreen.map[3].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 3 Button's clicked");
                System.out.println("Map 3 's showing");
                cp.remove(selectMapScreen);
                cp.add(map3);
                cp.revalidate();
                cp.repaint();

            }
            else if (selectMapScreen.map[4].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 4 Button's clicked");
                System.out.println("Map 4 's showing");
                cp.remove(selectMapScreen);
                cp.add(map4);
                cp.revalidate();
                cp.repaint();

            }
            else if (selectMapScreen.map[5].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 5 Button's clicked");
                System.out.println("Map 5 's showing");
                cp.remove(selectMapScreen);
                cp.add(map5);
                cp.revalidate();
                cp.repaint();

            }else if (selectMapScreen.map[6].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 6 Button's clicked");
                System.out.println("Map 6 's showing");
                cp.remove(selectMapScreen);
                cp.add(map6);
                cp.revalidate();
                cp.repaint();
                
            }else if (selectMapScreen.map[7].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 7 Button's clicked");
                System.out.println("Map 7 's showing");
                cp.remove(selectMapScreen);
                cp.add(map7);
                cp.revalidate();
                cp.repaint();
                
            }else if (selectMapScreen.map[8].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 8 Button's clicked");
                System.out.println("Map 8 's showing");
                cp.remove(selectMapScreen);
                cp.add(map8);
                cp.revalidate();
                cp.repaint();
                
            }else if (selectMapScreen.map[9].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 9 Button's clicked");
                System.out.println("Map 9 's showing");
                cp.remove(selectMapScreen);
                cp.add(map9);
                cp.revalidate();
                cp.repaint();
                
            }else if (selectMapScreen.map[10].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 10 Button's clicked");
                System.out.println("Map 10 's showing");
                cp.remove(selectMapScreen);
                cp.add(map10);
                cp.revalidate();
                cp.repaint();
                
            }else if (selectMapScreen.map[11].getBounds().contains(e.getPoint())){
                System.out.println("==> Map 11 Button's clicked");
                System.out.println("Map 11 's showing");
                cp.remove(selectMapScreen);
                cp.add(map11);
                cp.revalidate();
                cp.repaint();
                
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
            if (map0.homeBtn.getBounds().contains(e.getPoint()) && map0.isShowing()){
                System.out.println("==> Home Button's clicked");
                cp.remove(map0);
                cp.add(selectMapScreen);
                cp.revalidate();
                cp.repaint();
                System.out.println("Back to Select Map Screen...");
                System.out.println("-----------------------------");
            }else if (map1.homeBtn.getBounds().contains(e.getPoint()) && map1.isShowing()){
                System.out.println("==> Home Button's clicked");
                cp.remove(map1);
                cp.add(selectMapScreen);
                cp.revalidate();
                cp.repaint();
                System.out.println("Back to Select Map Screen...");
                System.out.println("-----------------------------");
            }else if (map2.homeBtn.getBounds().contains(e.getPoint()) && map2.isShowing()){
                System.out.println("==> Home Button's clicked");
                cp.remove(map2);
                cp.add(selectMapScreen);
                cp.revalidate();
                cp.repaint();
                System.out.println("Back to Select Map Screen...");
                System.out.println("-----------------------------");
            }else if (map3.homeBtn.getBounds().contains(e.getPoint()) && map3.isShowing()){
                System.out.println("==> Home Button's clicked");
                cp.remove(map3);
                cp.add(selectMapScreen);
                cp.revalidate();
                cp.repaint();
                System.out.println("Back to Select Map Screen...");
                System.out.println("-----------------------------");
            }else if (map4.homeBtn.getBounds().contains(e.getPoint()) && map4.isShowing()){
                System.out.println("==> Home Button's clicked");
                cp.remove(map4);
                cp.add(selectMapScreen);
                cp.revalidate();
                cp.repaint();
                System.out.println("Back to Select Map Screen...");
                System.out.println("-----------------------------");
            }else if (map5.homeBtn.getBounds().contains(e.getPoint()) && map5.isShowing()){
                System.out.println("==> Home Button's clicked");
                cp.remove(map5);
                cp.add(selectMapScreen);
                cp.revalidate();
                cp.repaint();
                System.out.println("Back to Select Map Screen...");
                System.out.println("-----------------------------");
            }else if (map6.homeBtn.getBounds().contains(e.getPoint()) && map6.isShowing()){
                System.out.println("==> Home Button's clicked");
                cp.remove(map6);
                cp.add(selectMapScreen);
                cp.revalidate();
                cp.repaint();
                System.out.println("Back to Select Map Screen...");
                System.out.println("-----------------------------");
            }else if (map7.homeBtn.getBounds().contains(e.getPoint()) && map7.isShowing()){
                System.out.println("==> Home Button's clicked");
                cp.remove(map7);
                cp.add(selectMapScreen);
                cp.revalidate();
                cp.repaint();
                System.out.println("Back to Select Map Screen...");
                System.out.println("-----------------------------");
            }else if (map8.homeBtn.getBounds().contains(e.getPoint()) && map8.isShowing()){
                System.out.println("==> Home Button's clicked");
                cp.remove(map8);
                cp.add(selectMapScreen);
                cp.revalidate();
                cp.repaint();
                System.out.println("Back to Select Map Screen...");
                System.out.println("-----------------------------");
            }else if (map9.homeBtn.getBounds().contains(e.getPoint()) && map9.isShowing()){
                System.out.println("==> Home Button's clicked");
                cp.remove(map9);
                cp.add(selectMapScreen);
                cp.revalidate();
                cp.repaint();
                System.out.println("Back to Select Map Screen...");
                System.out.println("-----------------------------");
            }else if (map10.homeBtn.getBounds().contains(e.getPoint()) && map10.isShowing()){
                System.out.println("==> Home Button's clicked");
                cp.remove(map10);
                cp.add(selectMapScreen);
                cp.revalidate();
                cp.repaint();
                System.out.println("Back to Select Map Screen...");
                System.out.println("-----------------------------");
            }else if (map11.homeBtn.getBounds().contains(e.getPoint()) && map11.isShowing()){
                System.out.println("==> Home Button's clicked");
                cp.remove(map11);
                cp.add(selectMapScreen);
                cp.revalidate();
                cp.repaint();
                System.out.println("Back to Select Map Screen...");
                System.out.println("-----------------------------");
            }
        }
    }

    private class NavBackCredits extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if (creditsScreen.CbackBtn.getBounds().contains(e.getPoint())){
                System.out.println("Back Button Credits's clicked");
                titleGameScreen.remove(creditsScreen);
                revalidate();
                repaint();
                System.out.println("Back to Title Map Screen...");
                System.out.println("-----------------------------");
            }
        }
    }
}