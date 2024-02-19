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

public class Map10 extends JPanel{
    private GameFrame gameFrame;
    // Window Game Size
    private final int FRAME_WIDTH = 1366;
    private final int FRAME_HEIGHT = 768;
    private final Dimension FRAME_SIZE = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);

    // Construct Wall
    private final int WALL_HEIGHT = 100;
    private final int WALL_WIDTH = 115;
    protected Rectangle wallTop = new Rectangle(0, 0-10, FRAME_WIDTH, WALL_HEIGHT);
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
    protected final int START_X = 140;
    protected final int START_Y = 110;

    // Goal positions Setup
    protected final int GOAL_X = 895;
    protected final int GOAL_Y = 350;

    // Construct Box
    private Color colorBox = new Color(52,104,192,255);
    protected Box player = new Box(START_X, START_Y, 18 , colorBox);

    // Construct Goal
    protected Goal goal = new Goal(GOAL_X, GOAL_Y,45,70, colorBox.darker().darker().darker().darker());

    // Construct Obstacles Here!! ma friends
    private Rectangle o1h = new Rectangle(195, 144, 987, 71);
    private Rectangle o2h = new Rectangle(422, 281, 595, 71);
    private Rectangle o3h = new Rectangle(487, 417, 449, 71);
    private Rectangle o4h = new Rectangle(341, 549, 760, 71);
    
    private Rectangle o1v = new Rectangle(195, 214, 82, 466);
    private Rectangle o2v = new Rectangle(341, 281, 82, 269);
    private Rectangle o3v = new Rectangle(935, 351, 82, 137);
    private Rectangle o4v = new Rectangle(1100, 214, 82, 406);
    
    // Construct obstacles Moving
    private ObjectMoving o1vMove = new ObjectMoving(85, 600, 110, 70);
    private ObjectMoving o2vMove = new ObjectMoving(1182, 0, 110, 70);
    private ObjectMoving o3vMove = new ObjectMoving(1017, 145, 110, 70);
    private ObjectMoving o4vMove = new ObjectMoving(276, 671, 65, 70);
    private ObjectMoving o5vMove = new ObjectMoving(421, 550, 67, 70);
    
    private ObjectMoving o1hMove = new ObjectMoving(-200, 89, 70, 55);
    private ObjectMoving o2hMove = new ObjectMoving(196, 213, 70, 70);
    private ObjectMoving o3hMove = new ObjectMoving(343, 348, 70, 70);
    private ObjectMoving o4hMove = new ObjectMoving(342, 483, 70, 70);
    private ObjectMoving o5hMove = new ObjectMoving(196, 619, 70, 70);
    
    // Construct obstables Rotation

    public Map10(GameFrame gameFrame){
        this.gameFrame = gameFrame;
        setLayout(null);
        setPreferredSize(FRAME_SIZE);

        // Label Components
        mapNumber = new JLabel();
        mapNumber.setText("MAP 10");
        mapNumber.setBounds(600, 22, 200, 50);
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

        ActionListener updateTask = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                o1vMove.moveUp(660, 0, 3);
                o2vMove.moveDown(0, 670, 3);
                o3vMove.moveDown(145, 550, 3);
                o4vMove.moveUp(670, 145, 3);
                o5vMove.moveUp(550, 282, 3);
                
                o1hMove.moveRight(0, 1250, 3);
                o2hMove.moveRight(195, 1100, 3);
                o3hMove.moveRight(344, 938, 3);
                o4hMove.moveLeft(1100, 344, 3);
                o5hMove.moveLeft(1250, 198, 3);

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
        paintMovingObject(g);
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
        g.fillRect(o1h.x, o1h.y, o1h.width, o1h.height);
        g.fillRect(o2h.x, o2h.y, o2h.width, o2h.height);
        g.fillRect(o3h.x, o3h.y, o3h.width, o3h.height);
        g.fillRect(o4h.x, o4h.y, o4h.width, o4h.height);

        g.fillRect(o1v.x, o1v.y, o1v.width, o1v.height);
        g.fillRect(o2v.x, o2v.y, o2v.width, o2v.height);
        g.fillRect(o3v.x, o3v.y, o3v.width, o3v.height);
        g.fillRect(o4v.x, o4v.y, o4v.width, o4v.height);
    }

    private void paintMovingObject(Graphics g){
        g.setColor(colorBox.darker().darker());
        o1vMove.paintMovingObject(g);
        o2vMove.paintMovingObject(g);
        o3vMove.paintMovingObject(g);
        o4vMove.paintMovingObject(g);
        o5vMove.paintMovingObject(g);
        
        o1hMove.paintMovingObject(g);
        o2hMove.paintMovingObject(g);
        o3hMove.paintMovingObject(g);
        o4hMove.paintMovingObject(g);
        o5hMove.paintMovingObject(g);
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
            //System.out.println("mouseX:" + e.getX() + ", mouseY:" + e.getY());
        }
        private void winGoal(){
            // Box Get Goal
            if (player.boxChar.intersects(goal.goalChar)){
                System.out.println("Congratulations!!!");
                ResetPlayer();
                
                // JOptionPane.showInternalMessageDialog(null,"You Win!!", "Congratulation",JOptionPane.PLAIN_MESSAGE);
                // repaint();
                changeMap(gameFrame.map11);
            }
        }
        private void changeMap(JPanel newMap){
            gameFrame.cp.remove(gameFrame.map10);
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
            if (player.boxChar.intersects(o1h) || player.boxChar.intersects(o2h)
                || player.boxChar.intersects(o3h) || player.boxChar.intersects(o4h)
                || player.boxChar.intersects(o1v) || player.boxChar.intersects(o2v)
                || player.boxChar.intersects(o3v) || player.boxChar.intersects(o4v)){
                // Reset State
                ResetPlayer();
            }
            // Add hit the moveing's obstacles
            if (player.boxChar.intersects(o1hMove.object) || player.boxChar.intersects(o2hMove.object)
                || player.boxChar.intersects(o3hMove.object) || player.boxChar.intersects(o4hMove.object)
                || player.boxChar.intersects(o5hMove.object)
                || player.boxChar.intersects(o1vMove.object) || player.boxChar.intersects(o2vMove.object)
                || player.boxChar.intersects(o3vMove.object) || player.boxChar.intersects(o4vMove.object)
                || player.boxChar.intersects(o5vMove.object)){
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
