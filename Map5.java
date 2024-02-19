import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Map5 extends JPanel{
    private GameFrame gameFrame;
    // Window Game Size
    private final int FRAME_WIDTH = 1366;
    private final int FRAME_HEIGHT = 768;
    private final Dimension FRAME_SIZE = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);

    // Construct Wall
    private final int WALL_HEIGHT = 200;
    private final int WALL_WIDTH = 150;
    protected Rectangle wallTop = new Rectangle(0, 0, FRAME_WIDTH, WALL_HEIGHT);
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
    protected final int START_X = 190;
    protected final int START_Y = 370;

    // Goal positions Setup
    protected final int GOAL_X = 1174;
    protected final int GOAL_Y = 200;

    // Construct Box
    private Color colorBox = new Color(255,189,89,255);
    protected Box player = new Box(START_X, START_Y, 50 , colorBox);

    // Construct Goal
    protected Goal goal = new Goal(GOAL_X, GOAL_Y,50,400, colorBox.darker().darker().darker().darker());

    // Construct Obstacles Here!! ma friends

    
    // Construct obstacles Moving
    private ObjectMoving o1Move = new ObjectMoving(450, 200, 65, 150);
    private ObjectMoving o2Move = new ObjectMoving(530, 200, 65, 150);
    private ObjectMoving o3Move = new ObjectMoving(610, 200, 65, 150);
    private ObjectMoving o4Move = new ObjectMoving(690, 200, 65, 150);
    private ObjectMoving o5Move = new ObjectMoving(770, 200, 65, 150);
    private ObjectMoving o6Move = new ObjectMoving(850, 200, 65, 150);
    private ObjectMoving o7Move = new ObjectMoving(930, 200, 65, 150);
    private ObjectMoving o8Move = new ObjectMoving(1010, 200, 65, 150);
    private ObjectMoving o9Move = new ObjectMoving(1090, 200, 65, 150);
    private ObjectMoving o10Move = new ObjectMoving(370, 200, 65, 150);
    private ObjectMoving o11Move = new ObjectMoving(290, 200, 65, 150);
    
    // Construct obstables Rotation

    public Map5(GameFrame gameFrame){
        this.gameFrame = gameFrame;
        setLayout(null);
        setPreferredSize(FRAME_SIZE);

        // Label Components
        mapNumber = new JLabel();
        mapNumber.setText("MAP 5");
        mapNumber.setBounds(550, 60, 300, 100);
        mapNumber.setOpaque(false);
        mapNumber.setBackground(Color.BLACK);
        mapNumber.setForeground(offWhite);
        mapNumber.setHorizontalAlignment(SwingConstants.CENTER);
        mapNumber.setVerticalAlignment(SwingConstants.CENTER);
        mapNumberFont = usingFontsBold(mapNumberFont, 100f, "font/Oswald/Oswald-Medium.ttf");
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

        ActionListener updateTask = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                o1Move.moveDown2Up(420, 200, 2);
                o2Move.moveDown2Up(420, 200, 3);
                o3Move.moveDown2Up(420, 200, 4);
                o4Move.moveDown2Up(420, 200, 5);
                o5Move.moveDown2Up(420, 200, 4);
                o6Move.moveDown2Up(420, 200, 3);
                o7Move.moveDown2Up(420, 200, 2);
                o8Move.moveDown2Up(420, 200, 3);
                o9Move.moveDown2Up(420, 200, 4);
                o10Move.moveDown2Up(420, 200, 5);
                o11Move.moveDown2Up(420, 200, 4);
                repaint();
            }
        };
        new Timer(10, updateTask).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); // for smoothly 
        player.paintBox(g);
        goal.paintGoalCustomSize(g);
        paintTheWall(g);
        paintObstacles(g);
        o1Move.paintMovingObject(g);
        o2Move.paintMovingObject(g);
        o3Move.paintMovingObject(g);
        o4Move.paintMovingObject(g);
        o5Move.paintMovingObject(g);
        o6Move.paintMovingObject(g);
        o7Move.paintMovingObject(g);
        o8Move.paintMovingObject(g);
        o9Move.paintMovingObject(g);
        o10Move.paintMovingObject(g);
        o11Move.paintMovingObject(g);
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
            // System.out.println("mouseX:" + e.getX() + ", mouseY:" + e.getY());
        }
        private void winGoal(){
            // Box Get Goal
            if (player.boxChar.intersects(goal.goalChar)){
                System.out.println("Congratulations!!!");
                ResetPlayer();
                
                // JOptionPane.showInternalMessageDialog(null,"You Win!!", "Congratulation",JOptionPane.PLAIN_MESSAGE);
                // repaint();
                changeMap(gameFrame.map6);
            }
        }
        private void changeMap(JPanel newMap){
            gameFrame.cp.remove(gameFrame.map5);
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
        // Add hit the moveing's obstacles
        if (player.boxChar.intersects(o1Move.object)||player.boxChar.intersects(o2Move.object)||player.boxChar.intersects(o3Move.object)||
            player.boxChar.intersects(o4Move.object)||player.boxChar.intersects(o5Move.object)||player.boxChar.intersects(o6Move.object)||
            player.boxChar.intersects(o7Move.object)||player.boxChar.intersects(o8Move.object) || player.boxChar.intersects(o9Move.object) ||
            player.boxChar.intersects(o10Move.object) || player.boxChar.intersects(o11Move.object)){
            // Reset State
            ResetPlayer();
        }
        // Add hit the rotation's obstacles
        
    }
    
    private void ResetPlayer(){
        isMouseInsideBox = false;
        player.boxChar.x = START_X;
        player.boxChar.y = START_Y;
    }
    }
}