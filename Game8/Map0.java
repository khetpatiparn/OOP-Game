import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Map0 extends JPanel{
    private GameFrame gameFrame;
    // Window Game Size
    private final int FRAME_WIDTH = 1366;
    private final int FRAME_HEIGHT = 768;
    private final Dimension FRAME_SIZE = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);

    // Construct Wall
    private final int WALL_HEIGHT = 100;
    private final int WALL_WIDTH = 115;
    protected Rectangle wallTop = new Rectangle(0, 0, FRAME_WIDTH, WALL_HEIGHT);
    protected Rectangle wallBottom = new Rectangle(0, FRAME_HEIGHT - WALL_HEIGHT, FRAME_WIDTH, WALL_HEIGHT);
    protected Rectangle wallLeft = new Rectangle(0, 0, WALL_WIDTH, FRAME_HEIGHT);
    protected Rectangle wallRight = new Rectangle(FRAME_WIDTH - WALL_WIDTH, 0, WALL_WIDTH, FRAME_HEIGHT);

    // Fonts
    private Font mapNumberFont, TextFont;

    // Color
    private Color offWhite = new Color(250, 249, 246);
    
    // Home Button to Select Map Screen
    private JLabel mapNumber;
    protected JLabel homeBtn;

    // Start positions Setup
    protected final int START_X = 160;
    protected final int START_Y = 170;

    // Goal positions Setup
    protected final int GOAL_X = 100;
    protected final int GOAL_Y = 464;

    // Construct Box
    private Color colorBox = new Color(255, 87, 87);
    protected Box player = new Box(START_X, START_Y, 60 , colorBox);

    // Construct Goal
    protected Goal goal = new Goal(GOAL_X, GOAL_Y,50,300, colorBox.darker().darker().darker().darker());

    // Construct Obstacles Here!! ma friends
    protected Rectangle o1 = new Rectangle(103, 289, 800, 190);
    
    // Construct obstacles Moving
    
    // Construct obstables Rotation

    public Map0(GameFrame gameFrame){
        this.gameFrame = gameFrame;
        setLayout(null);
        setPreferredSize(FRAME_SIZE);

        // Label Components
        mapNumber = new JLabel();
        mapNumber.setText("MAP 0");
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
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); // for smoothly 
        paintText1(g2d);
        paintText2(g2d);
        paintText3(g2d);
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
    
    private void paintObstacles(Graphics g){
        g.setColor(colorBox);
        g.fillRect(o1.x, o1.y, o1.width, o1.height);
    }
    private void paintText1(Graphics2D g2d){
        // This is tutorial text1
        AffineTransform originalTransform = g2d.getTransform(); 
        AffineTransform tfText = new AffineTransform();
        g2d.setTransform(tfText);
        TextFont = usingFonts(TextFont, 40f, "font/Oswald/Oswald-Medium.ttf");
        g2d.setFont(TextFont);
        g2d.setColor(offWhite.darker());
        g2d.drawString("move your mouse over SQUARE!!", 250, 210); 
        g2d.setTransform(originalTransform);
    }

    private void paintText2(Graphics2D g2d){
        // This is tutorial text1
        AffineTransform originalTransform = g2d.getTransform(); 
        AffineTransform tfText = new AffineTransform();
        g2d.setTransform(tfText);
        TextFont = usingFonts(TextFont, 40f, "font/Oswald/Oswald-Medium.ttf");
        g2d.setFont(TextFont);
        g2d.setColor(offWhite.darker());
        g2d.drawString("Don't hit ANYTHING", 930, 370); 
        g2d.setTransform(originalTransform);
    }

    private void paintText3(Graphics2D g2d){
        // This is tutorial text1
        AffineTransform originalTransform = g2d.getTransform(); 
        AffineTransform tfText = new AffineTransform();
        g2d.setTransform(tfText);
        TextFont = usingFonts(TextFont, 40f, "font/Oswald/Oswald-Medium.ttf");
        g2d.setFont(TextFont);
        g2d.setColor(offWhite.darker());
        g2d.drawString("Get Goal", 190, 580); 
        g2d.setTransform(originalTransform);
    }
    
    // Using Fonts Method Section
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
                System.out.println("Is in Home Button in Map 0");
                homeBtn.setForeground(offWhite.darker().darker());
            }else{
                homeBtn.setForeground(offWhite);
            }
        }
    }

    private class MouseAction extends MouseAdapter{ // Action.java
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
            // System.out.println("mouseX:" + e.getX() + ", mouseY:" + e.getY());
        }
        private void winGoal(){
            // Box Get Goal
            if (player.boxChar.intersects(goal.goalChar)){
                System.out.println("Congratulations!!!");
                ResetPlayer();
                
                // repaint();
                changeMap(gameFrame.map1);
            }
        }
        private void changeMap(JPanel newMap){
            gameFrame.cp.remove(gameFrame.map0);
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
        }
        // Add Hit the Obstacles Here!! ma friends
        if (player.boxChar.intersects(o1)){
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