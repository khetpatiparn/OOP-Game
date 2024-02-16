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
    Font font_p1; // font name1
    Font font_p2; // font name2
    Font fontGameStartBtn;
    // Color
    Color tomato = new Color(255, 87, 87);
    Color offWhite = new Color(250, 249, 246);
    Color black = new Color(25, 28, 32);
    // Label
    JLabel title_p1;
    JLabel title_p2;
    // Button
    JLabel GameStart;
    JButton Exit;
    JButton Credits;
    // Arrow Btn
    Polygon triangleLeft;
    Polygon triangleRight;
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
    int direction = 1;
    Rectangle floor = new Rectangle(0, 600, FRAME_WIDTH + 50, 200);
    Rectangle Box = new Rectangle(1000, 575, 70, 70);
    // Constructor
    public TitleGameScreen(){
        setPreferredSize(FRAME_SIZE); // set Size of Title Game Screen
        setLayout(null); // use absolute layout
        // setBackground(Color.WHITE); // set Background of Panel Title Game Screen
        setBackground(offWhite);
        //event handler
        addMouseMotionListener(new Mouse());

        // Watch Out Screen Label
        title_p1 = new JLabel();
        title_p1.setText("Watch Out,");
        title_p1.setBounds(310, 258, 454, 104);
        title_p1.setForeground(black);
        font_p1 = usingFontsBold(font_p1, 65f, "font/Shantell_Sans/static/ShantellSans-Regular.ttf");
        title_p1.setFont(font_p1);
        add(title_p1);
        // SQUARE Screen Label
        title_p2 = new JLabel();
        title_p2.setText("SQUARE!!");
        title_p2.setBounds(708, 237, 405, 128);
        font_p2 = usingFontsBold(font_p2, 90f, "font/Oswald/static/Oswald-Medium.ttf");
        title_p2.setFont(font_p2);
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
        fontGameStartBtn = usingFontsBold(fontGameStartBtn, 25f, "font/Shantell_Sans/static/ShantellSans-Regular.ttf");
        GameStart.setForeground(black);
        GameStart.setFont(fontGameStartBtn);
        add(GameStart);
        // ActionListener
        ActionListener updateTask = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Box.x <= 1000){
                    Box.x -= Math.cos(Math.toRadians(5)) * 5;
                }
                repaint();
            }
        };
        new Timer(1, updateTask).start();

    }
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
            System.out.println("Font Problems");
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
            System.out.println("Font Problems");
            return null;
        }
    }
    
    // Paint Method Section
    public void paintFloor(Graphics2D g2d){
        g2d.setColor(black);
        AffineTransform tfFloor = new AffineTransform();
        tfFloor.translate(-10, 42);
        // tfFloor.rotate(Math.toRadians(177), floor.getCenterX(), floor.getCenterY());
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
        tfBox.rotate(Math.toRadians(180), Box.getCenterX(), Box.getCenterY());
        Shape tfShapeBox = tfBox.createTransformedShape(Box);
        g2d.fill(tfShapeBox);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Title Game Screen");
        frame.setContentPane(new TitleGameScreen());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    private class Mouse extends MouseAdapter{
        @Override
        public void mouseMoved(MouseEvent e) {
        // Check mouse's position
        System.out.println("mouseX:" + e.getX() + ", mouseY:" + e.getY());
        }
    }
}