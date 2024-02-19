import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TitleGameScreen extends JPanel{
    // Window Game Size
    private final int FRAME_WIDTH = 1366;
    private final int FRAME_HEIGHT = 768;
    private final Dimension FRAME_SIZE = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);

    // About Font
    private Font WatchOutFont ,SqaureFont, GameStartFont, CreditsFont, ExitFont;
    
    // Color
    private Color tomato = new Color(255, 87, 87);
    private Color offWhite = new Color(250, 249, 246);
    private Color black = new Color(25, 28, 32);
    
    // Label
    private JLabel title_p1, title_p2;
    
    // Button
    protected JLabel GameStart, Exit, Credits;
    
    // Arrow Btn
    protected Polygon triangleLeft, triangleRight;
    private int pointX_triangleLeft = 490;
    private int pointX_triangleRight = 800;
    private int pointY_triangle = 435; 
    private int sizeTriangleBox = 35;
    // Arrow Btn Right
    private int[] xLeft = {sizeTriangleBox + pointX_triangleLeft, sizeTriangleBox + pointX_triangleLeft, pointX_triangleLeft};
    private int[] yLeft = {pointY_triangle, sizeTriangleBox + pointY_triangle, pointY_triangle + sizeTriangleBox / 2};
    // Arrow Btn Right
    private int[] xRight = {pointX_triangleRight, pointX_triangleRight, pointX_triangleRight + sizeTriangleBox};
    private int[] yRight = {pointY_triangle, sizeTriangleBox + pointY_triangle, pointY_triangle + sizeTriangleBox / 2};
    
    // Footer backgound
    private Rectangle floor = new Rectangle(0, 600, FRAME_WIDTH + 50, 200);
    private Rectangle Box = new Rectangle(1000, 555, 70, 70);

    // Box Background 
    private ObjectMoving bgBox1 = new ObjectMoving(800,478,200,200);
    private ObjectMoving bgBox2 = new ObjectMoving(148,35,360,360);
    private ObjectMoving bgBox3 = new ObjectMoving(760,-100,310,310);
    private ObjectMoving bgBox4 = new ObjectMoving(1390,309,258,230);
    private ObjectMoving bgBox5 = new ObjectMoving(-100,389,250,250);
    private ObjectMoving bgBox6 = new ObjectMoving(1193,690,280,250);
    
    // Constructor to setup Component and Event handler
    public TitleGameScreen(){
        setPreferredSize(FRAME_SIZE); // set Size of Title Game Screen
        setLayout(null); // use absolute layout
        setBackground(offWhite);

        // Watch Out Screen Label
        title_p1 = new JLabel();
        title_p1.setText("Watch Out,");
        title_p1.setBounds(310, 258, 454, 104);
        title_p1.setForeground(black);
        WatchOutFont = usingFontsBold(WatchOutFont, 65f, "font/Shantell_Sans/ShantellSans-Regular.ttf");
        title_p1.setFont(WatchOutFont);
        add(title_p1);

        // SQUARE Screen Label
        title_p2 = new JLabel();
        title_p2.setText("SQUARE!!");
        title_p2.setBounds(708, 237, 405, 128);
        SqaureFont = usingFontsBold(SqaureFont, 90f, "font/Oswald/Oswald-Medium.ttf");
        title_p2.setFont(SqaureFont);
        title_p2.setForeground(tomato);
        add(title_p2);

        // Button Arrow Left and Right
        triangleLeft = new Polygon(xLeft,yLeft, 3);
        triangleRight = new Polygon(xRight,yRight, 3);

        // Button Game start ( use Label)
        GameStart = new JLabel();
        GameStart.setText("Game Start");
        GameStart.setOpaque(false); // show bg color 
        GameStart.setBackground(Color.RED);
        GameStart.setBounds(590 , 430, 155, 45);
        GameStartFont = usingFontsBold(GameStartFont, 25f, "font/Shantell_Sans/ShantellSans-Regular.ttf");
        GameStart.setForeground(black);
        GameStart.setFont(GameStartFont);
        add(GameStart);
        System.out.println("Gamestart's showing");
        
        // Button Exit (use Label)
        Exit = new JLabel();
        Exit.setText("Exit");
        Exit.setOpaque(false); // show bg color 
        Exit.setBackground(Color.RED);
        Exit.setBounds(640 , 430, 60, 45);
        ExitFont = usingFontsBold(ExitFont, 25f, "font/Shantell_Sans/ShantellSans-Regular.ttf");
        Exit.setForeground(black);
        Exit.setFont(ExitFont);

        // Button Credits (use Label)
        Credits = new JLabel();
        Credits.setText("Credits");
        Credits.setOpaque(false); // show bg color 
        Credits.setBackground(Color.RED);
        Credits.setBounds(620 , 430, 100, 45);
        CreditsFont = usingFontsBold(CreditsFont, 25f, "font/Shantell_Sans/ShantellSans-Regular.ttf");
        Credits.setForeground(black);
        Credits.setFont(CreditsFont);

        // Event-Handler Section
        addMouseListener(new ArrowAction()); // click arrow to change label
        addMouseMotionListener(new MousePositionCheck());
        addMouseMotionListener(new HoverButton());

        ActionListener updateTask = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bgBox1.moveLeft(1400, -550, 2);
                bgBox2.moveLeft(1600, -800, 1);
                bgBox3.moveLeft(1550, -1000, 3);
                bgBox4.moveLeft(1750, -1000, 1);
                bgBox5.moveLeft(2000, -1000, 2);
                bgBox6.moveLeft(1400, -300, 2);
                repaint();
            }
        };
        new Timer(10, updateTask).start();
    }
    // Main PaintComponents Method
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); // for smoothly rect
        paintBackgroundBox(g);
        paintArrowBtn(g);
        paintFloor(g2d);
        paintBox(g2d);
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
    
    // Paint Method Section
    public void paintFloor(Graphics2D g2d){
        g2d.setColor(black);
        AffineTransform tfFloor = new AffineTransform();
        tfFloor.translate(-10, 42);
        tfFloor.rotate(Math.toRadians(177), floor.getCenterX(), floor.getCenterY());
        Shape tfShapeFloor = tfFloor.createTransformedShape(floor);
        g2d.fill(tfShapeFloor);
    }
    public void paintArrowBtn(Graphics g){
        g.setColor(black);
        g.fillPolygon(triangleLeft);
        g.fillPolygon(triangleRight);
    }
    public void paintBox(Graphics2D g2d){
        g2d.setColor(black);
        AffineTransform tfBox = new AffineTransform();
        tfBox.rotate(Math.toRadians(177), Box.getCenterX(), Box.getCenterY());
        Shape tfShapeBox = tfBox.createTransformedShape(Box);
        g2d.fill(tfShapeBox);
    }

    public void paintBackgroundBox(Graphics g){
        g.setColor(new Color(255,175,126,255)); // orange
        g.fillRect(bgBox4.object.x, bgBox4.object.y, bgBox4.object.width, bgBox4.object.height);
        
        g.setColor(new Color(255, 104, 104,255).brighter()); // red
        g.fillRect(bgBox1.object.x, bgBox1.object.y, bgBox1.object.width, bgBox1.object.height);
        
        g.setColor(new Color(177,255,143,255)); // green
        g.fillRect(bgBox2.object.x, bgBox2.object.y, bgBox2.object.width, bgBox2.object.height);
        
        g.setColor(new Color(222,158,228,255)); // purple
        g.fillRect(bgBox5.object.x, bgBox5.object.y, bgBox5.object.width, bgBox5.object.height);
        
        g.setColor(new Color(190,245,255,255)); // blue
        g.fillRect(bgBox3.object.x, bgBox3.object.y, bgBox3.object.width, bgBox3.object.height);

        g.setColor(new Color(50,60,50,255)); // black
        g.fillRect(bgBox6.object.x, bgBox6.object.y, bgBox6.object.width, bgBox6.object.height);

    }

    // Inner Class for Event Handler Section
    private class MousePositionCheck extends MouseAdapter{
        @Override
        public void mouseMoved(MouseEvent e) {
        // Check mouse's position
        // System.out.println("mouseX:" + e.getX() + ", mouseY:" + e.getY());
        }
    }
    private class ArrowAction extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if (triangleLeft.contains(e.getPoint()) || triangleRight.contains(e.getPoint())){
                System.out.println(" ==> Triangle's clicked");
                if (GameStart.isShowing()){
                    remove(GameStart);
                    add(Credits);
                    revalidate();
                    repaint();
                    System.out.println("Credits's showing");
                }else if (Credits.isShowing()){
                    remove(Credits);
                    add(Exit);
                    validate();
                    repaint();
                    System.out.println("Exit's showing");
                }else if (Exit.isShowing()){
                    remove(Exit);
                    add(GameStart);
                    validate();
                    repaint();
                    System.out.println("Gamestart's showing");
                }
            }
        }
    }
    private class HoverButton extends MouseAdapter{
        @Override
        public void mouseMoved(MouseEvent e) {
            super.mouseMoved(e);
            if (GameStart.getBounds().contains(e.getPoint())){
                // System.out.println("point at game start button");
                GameStart.setForeground(black.brighter().brighter().brighter().brighter());
                Credits.setForeground(black.brighter().brighter().brighter().brighter());
                Exit.setForeground(black.brighter().brighter().brighter().brighter());
            }else{
                GameStart.setForeground(black);
                Credits.setForeground(black);
                Exit.setForeground(black);

            }
        }
        
        
    }
}