import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class TitleGameScreen extends JPanel{
    // Window Game Size
    private final int FRAME_WIDTH = 1366;
    private final int FRAME_HEIGHT = 768;
    private final Dimension FRAME_SIZE = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);

    // About Font
    Font WatchOutFont ,SqaureFont, GameStartFont, CreditsFont, ExitFont;
    
    // Color
    Color tomato = new Color(255, 87, 87);
    Color offWhite = new Color(250, 249, 246);
    Color black = new Color(25, 28, 32);
    
    // Label
    JLabel title_p1, title_p2;
    
    // Button
    JLabel GameStart, Exit, Credits;
    
    // Arrow Btn
    Polygon triangleLeft, triangleRight;
    int pointX_triangleLeft = 490;
    int pointX_triangleRight = 800;
    int pointY_triangle = 435; 
    int sizeTriangleBox = 35;
    // Arrow Btn Right
    int[] xLeft = {sizeTriangleBox + pointX_triangleLeft, sizeTriangleBox + pointX_triangleLeft, pointX_triangleLeft};
    int[] yLeft = {pointY_triangle, sizeTriangleBox + pointY_triangle, pointY_triangle + sizeTriangleBox / 2};
    // Arrow Btn Right
    int[] xRight = {pointX_triangleRight, pointX_triangleRight, pointX_triangleRight + sizeTriangleBox};
    int[] yRight = {pointY_triangle, sizeTriangleBox + pointY_triangle, pointY_triangle + sizeTriangleBox / 2};
    
    // Footer backgound
    Rectangle floor = new Rectangle(0, 600, FRAME_WIDTH + 50, 200);
    Rectangle Box = new Rectangle(1000, 555, 70, 70);
    
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
        CreditsFont = usingFontsBold(CreditsFont, 25f, "font/Shantell_Sans/static/ShantellSans-Regular.ttf");
        Credits.setForeground(black);
        Credits.setFont(CreditsFont);

        // Event-Handler Section
        addMouseListener(new ArrowAction()); // click arrow to change label
        addMouseMotionListener(new Mouse());
    }
    // Main PaintComponents Method
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); // for smoothly rect
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
    
    // Main Test Section
    public static void main(String[] args) {
        JFrame frame = new JFrame("Title Game Screen");
        frame.setContentPane(new TitleGameScreen());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    // Inner Class for Event Handler Section
    private class Mouse extends MouseAdapter{
        @Override
        public void mouseMoved(MouseEvent e) {
        // Check mouse's position
        System.out.println("mouseX:" + e.getX() + ", mouseY:" + e.getY());
        }
    }
    private class ArrowAction extends MouseAdapter{
        @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (triangleLeft.contains(e.getPoint()) || triangleRight.contains(e.getPoint())){
                    System.out.println("is in Triangle");
                    if (GameStart.isShowing()){
                        remove(GameStart);
                        add(Credits);
                        validate();
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
}