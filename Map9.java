import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Map9 extends JPanel{
    private GameFrame gameFrame;
    // Window Game Size
    private final int FRAME_WIDTH = 1366;
    private final int FRAME_HEIGHT = 768;
    private final Dimension FRAME_SIZE = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);

    // Construct Wall
    private final int WALL_HEIGHT = 30;
    private final int WALL_WIDTH = 40;
    protected Rectangle wallTop = new Rectangle(0, 0, FRAME_WIDTH, 100);
    protected Rectangle wallBottom = new Rectangle(0, FRAME_HEIGHT - WALL_HEIGHT, FRAME_WIDTH, WALL_HEIGHT);
    protected Rectangle wallLeft = new Rectangle(0, 0, WALL_WIDTH, FRAME_HEIGHT);
    protected Rectangle wallRight = new Rectangle(FRAME_WIDTH - WALL_WIDTH, 0, WALL_WIDTH, FRAME_HEIGHT);

    // Fonts
    private Font mapNumberFont;

    // Color
    private Color offWhite = new Color(250, 249, 246);
    
    // Home Button to Select Map Screen
    private JLabel mapNumber;
    protected JLabel homeBtn;

    // Start positions Setup
    protected final int START_X = 640; // adjust position of start
    protected final int START_Y = 300;

    // Goal positions Setup
    protected final int GOAL_X = 713; // adjust position of goal
    protected final int GOAL_Y = 357;

    // Construct Box
    private Color colorBox = new Color(255,145,77,255);
    protected Box player = new Box(START_X, START_Y,22,colorBox);

    // Construct Goal
    protected Goal goal = new Goal(GOAL_X, GOAL_Y,100,50,colorBox.darker().darker().darker());

    // Construct Obstacles Here!! ma friends
    protected Rectangle o1 = new Rectangle(683, 20, 30, 30);
    //protected Rectangle o2 = new Rectangle(1, 384, 50, 10);

    private Rectangle o3 = new Rectangle(683,10,30,680);
    private Rectangle o4 = new Rectangle(100,384,1160,30);
    private Rectangle o5 = new Rectangle(100,150,30,260);
    private Rectangle o6 = new Rectangle(100,150,250,30);
    private Rectangle o7 = new Rectangle(180,310,250,30);
    private Rectangle o8 = new Rectangle(410,20,30,320);
    private Rectangle o9 = new Rectangle(610,150,10,260);
    private Rectangle o10 = new Rectangle(490,150,10,260);
    private Rectangle o11 = new Rectangle(550,20,10,270);
    private Rectangle o12 = new Rectangle(200,150,10,100);
    private Rectangle o13 = new Rectangle(270,230,10,40);
    private Rectangle o14 = new Rectangle(270,230,80,10);

    private Rectangle o15 = new Rectangle(100,480,500,30);
    private Rectangle o16 = new Rectangle(100,560,30,230);
    private Rectangle o17 = new Rectangle(580,480,30,120);
    private Rectangle o18 = new Rectangle(480,660,210,30);
    private Rectangle o19 = new Rectangle(200,660,200,30);
    private Rectangle o20 = new Rectangle(130,560,300,30);
    private Rectangle o21 = new Rectangle(480,560,40,100);

    private Rectangle o22 = new Rectangle(700,660,300,30);
    private Rectangle o23 = new Rectangle(1080,660,180,30);
    private Rectangle o24 = new Rectangle(780,560,470,30);
    private Rectangle o25 = new Rectangle(780,480,670,30);
    private Rectangle o26 = new Rectangle(1240,560,30,130);
    private Rectangle o27 = new Rectangle(780,480,30,110);

    private Rectangle o28 = new Rectangle(810,150,30,260);
    private Rectangle o29 = new Rectangle(890,100,30,50);
    private Rectangle o30 = new Rectangle(810,200,430,30);
    private Rectangle o31 = new Rectangle(900,300,430,30);

    private Rectangle o32 = new Rectangle(1150,660,430,230);


    public Map9(GameFrame gameFrame){
        this.gameFrame = gameFrame;
        setLayout(null);
        setPreferredSize(FRAME_SIZE);

         // Label Components
        mapNumber = new JLabel();
        mapNumber.setText("MAP 9");
        mapNumber.setBounds(600, 24, 200, 50);
        mapNumber.setOpaque(false);
        mapNumber.setBackground(Color.BLACK);
        mapNumber.setForeground(offWhite);
        mapNumber.setHorizontalAlignment(SwingConstants.CENTER);
        mapNumber.setVerticalAlignment(SwingConstants.CENTER);
        mapNumberFont = usingFontsBold(mapNumberFont, 55f, "font/Oswald/Oswald-Medium.ttf");
        mapNumber.setFont(mapNumberFont);
        add(mapNumber);

         // Button home (but use Label)
        homeBtn = new JLabel();
        homeBtn.setText("HOME");
        homeBtn.setBounds(1180, 675, 150, 80);
        homeBtn.setOpaque(false);
        homeBtn.setBackground(Color.BLACK);
        homeBtn.setForeground(offWhite);
        homeBtn.setHorizontalAlignment(SwingConstants.CENTER);
        homeBtn.setVerticalAlignment(SwingConstants.CENTER);
        mapNumberFont = usingFontsBold(mapNumberFont, 60f, "font/Oswald/Oswald-Medium.ttf");
        homeBtn.setFont(mapNumberFont);
        add(homeBtn);
        
         // Add Event Home Button
        MouseAction mouseAction = new MouseAction();
        addMouseMotionListener(mouseAction);
        addMouseMotionListener(new HomeBtnOpacity());

        //new Timer(1, updateTask).start();

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.paintBox(g);
        goal.paintGoalCustomSize(g);
        paintTheWall(g);
        paintObstacles(g);
        
    }

    private void paintTheWall(Graphics g){
        g.setColor(colorBox);
        g.fillRect(wallTop.x, wallTop.y, wallTop.width, wallTop.height);
        g.fillRect(wallBottom.x, wallBottom.y, wallBottom.width, wallBottom.height);
        g.fillRect(wallLeft.x, wallLeft.y, wallLeft.width, wallLeft.height);
        g.fillRect(wallRight.x, wallRight.y, wallRight.width, wallRight.height);
    }

    // Add Obstabcles Here ma friends
    private void paintObstacles(Graphics g){
        g.setColor(colorBox);
        g.fillRect(o1.x, o1.y, o1.width, o1.height);
        //g.fillRect(o2.x, o2.y, o2.width, o2.height);
        g.fillRect(o3.x, o3.y, o3.width, o3.height);
        g.fillRect(o4.x, o4.y, o4.width, o4.height);
        g.fillRect(o5.x, o5.y, o5.width, o5.height);
        g.fillRect(o6.x, o6.y, o6.width, o6.height);
        g.fillRect(o7.x, o7.y, o7.width, o7.height);
        g.fillRect(o8.x, o8.y, o8.width, o8.height);
        g.fillRect(o9.x, o9.y, o9.width, o9.height);
        g.fillRect(o10.x, o10.y, o10.width, o10.height);
        g.fillRect(o11.x, o11.y, o11.width, o11.height);
        g.fillRect(o12.x, o12.y, o12.width, o12.height);
        g.fillRect(o13.x, o13.y, o13.width, o13.height);
        g.fillRect(o14.x, o14.y, o14.width, o14.height);
        g.fillRect(o15.x, o15.y, o15.width, o15.height);
        g.fillRect(o16.x, o16.y, o16.width, o16.height);
        g.fillRect(o17.x, o17.y, o17.width, o17.height);
        g.fillRect(o18.x, o18.y, o18.width, o18.height);
        g.fillRect(o19.x, o19.y, o19.width, o19.height);
        g.fillRect(o20.x, o20.y, o20.width, o20.height);
        g.fillRect(o21.x, o21.y, o21.width, o21.height);
        g.fillRect(o22.x, o22.y, o22.width, o22.height);
        g.fillRect(o23.x, o23.y, o23.width, o23.height);
        g.fillRect(o24.x, o24.y, o24.width, o24.height);
        g.fillRect(o25.x, o25.y, o25.width, o25.height);
        g.fillRect(o26.x, o26.y, o26.width, o26.height);
        g.fillRect(o27.x, o27.y, o27.width, o27.height);
        g.fillRect(o28.x, o28.y, o28.width, o28.height);
        g.fillRect(o29.x, o29.y, o29.width, o29.height);
        g.fillRect(o30.x, o30.y, o30.width, o30.height);
        g.fillRect(o31.x, o31.y, o31.width, o31.height);
        g.fillRect(o32.x, o32.y, o32.width, o32.height);
        // g.fillRect(o33.x, o33.y, o33.width, o33.height);
        //g.fillRect(o34.x, o34.y, o34.width, o34.height);
    }
    public Font usingFonts(Font fontName,  float sizeFont, String fontFilePath_ttf){
        try {
            fontName = Font.createFont(Font.TRUETYPE_FONT, new File(fontFilePath_ttf)).deriveFont(sizeFont);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontFilePath_ttf)));
            return fontName;
        } catch (IOException|FontFormatException e){
            // Handle Exception
            System.out.println("Font Problems Please Check");
            return null;
        }
    }
    public Font usingFontsBold(Font fontName,  float sizeFont, String fontFilePath_ttf){
        try {
            fontName = Font.createFont(Font.TRUETYPE_FONT, new File(fontFilePath_ttf)).deriveFont(Font.BOLD,sizeFont);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontFilePath_ttf)));
            return fontName;
        } catch (IOException|FontFormatException e){
            // Handle Exception
            System.out.println("Font Problems Please Check");
            return null;
        }
    }

    private class HomeBtnOpacity extends MouseAdapter{
        @Override
        public void mouseMoved(MouseEvent e) {
            super.mouseMoved(e);
            if (homeBtn.getBounds().contains(e.getPoint())){
                // System.out.println("Is in Home Button in Map 1");
                homeBtn.setForeground(offWhite.darker().darker());
            }else{
                homeBtn.setForeground(offWhite);
            }
        }
    }

    private class MouseAction extends MouseAdapter{
        private boolean isMouseInsideBox = false;

        private int cursorX;
        private int cursorY;

        @Override
        public void mouseMoved(MouseEvent e) {
            cursorX = e.getX();
            cursorY = e.getY();
    
            if (isMouseInsideBox) {
                player.boxChar.x = cursorX - player.sizeBox / 2; 
                player.boxChar.y = cursorY - player.sizeBox / 2;
                winGoal();
                Collistion();
                repaint();
                
            } else if ((cursorX > player.boxChar.x &&
                cursorX < player.boxChar.x + player.sizeBox) && 
                (cursorY > player.boxChar.y && 
                cursorY < player.boxChar.y + player.sizeBox )){
                isMouseInsideBox = true;
            }
            //Check mouse's position
            System.out.println("mouseX:" + e.getX() + ", mouseY:" + e.getY());
        }
        private void winGoal(){
            // Box Get Goal
            if (player.boxChar.intersects(goal.goalChar)){
                System.out.println("Congratulations!!!");
                ResetPlayer();
                
                // JOptionPane.showInternalMessageDialog(null,"You Win!!", "Congratulation",JOptionPane.PLAIN_MESSAGE);
                // repaint();
                changeMap(gameFrame.map10);
            }
        }
        private void changeMap(JPanel newMap){
            gameFrame.cp.remove(gameFrame.map9);
            gameFrame.cp.add(newMap);
            gameFrame.cp.revalidate();
            gameFrame.cp.repaint();
        }

    private void Collistion(){
        // Hit the Wall
        if (player.boxChar.intersects(wallTop) || player.boxChar.intersects(wallLeft) 
            || player.boxChar.intersects(wallRight) || player.boxChar.intersects(wallBottom)){
            // Reset State
            ResetPlayer();
        }if (player.boxChar.intersects(o1) || player.boxChar.intersects(o3) 
        || player.boxChar.intersects(o4) ||player.boxChar.intersects(o5)
        || player.boxChar.intersects(o6) ||player.boxChar.intersects(o7)
        || player.boxChar.intersects(o8) ||player.boxChar.intersects(o9)
        || player.boxChar.intersects(o10) ||player.boxChar.intersects(o11)
        || player.boxChar.intersects(o12) ||player.boxChar.intersects(o13)
        || player.boxChar.intersects(o14) ||player.boxChar.intersects(o15)
        || player.boxChar.intersects(o16) ||player.boxChar.intersects(o17)
        || player.boxChar.intersects(o18) ||player.boxChar.intersects(o19)
        || player.boxChar.intersects(o20) ||player.boxChar.intersects(o21)
        || player.boxChar.intersects(o22) ||player.boxChar.intersects(o23)
        || player.boxChar.intersects(o24) ||player.boxChar.intersects(o25)
        || player.boxChar.intersects(o26) ||player.boxChar.intersects(o27)
        || player.boxChar.intersects(o28) ||player.boxChar.intersects(o29)
        || player.boxChar.intersects(o30) ||player.boxChar.intersects(o31)
        
        ){
            // Reset State
            ResetPlayer();
        }

        
    }
    
    private void ResetPlayer(){
        isMouseInsideBox = false;
        player.boxChar.x = START_X;
        player.boxChar.y = START_Y;
    }
    }




}
