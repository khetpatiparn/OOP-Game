import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class SelectMapScreen extends JPanel{
    // Window Game Size
    private final int FRAME_WIDTH = 1366;
    private final int FRAME_HEIGHT = 768;
    private final Dimension FRAME_SIZE = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);

    // About Font
    Font selectMapFont, mapBoxFont;
    
    // Color
    Color tomato = new Color(255, 87, 87);
    Color offWhite = new Color(250, 249, 246);
    Color black = new Color(25, 28, 32);
    Color []mColor = {new Color(255, 104, 104), // 0
                    new Color(203,108,230), // 1
                    new Color(255,222,89), // 2
                    new Color(56,182,255), // 3
                    new Color(126,217,87), // 4
                    new Color(255,189,89), // 5
                    new Color(139,80,44), // 6
                    new Color(0,151,178), // 7
                    new Color(0,191,99), // 8
                    new Color(255,145,77), // 9
                    new Color(0,74,173), // 10
                    new Color(166,166,166), //11
    };
    
    // Label
    JLabel selectMap;

    // Button but Label
    JLabel[] map = new JLabel[12];
    int hGap = 50;
    int sizeBtn = 150; 
    
    // Constructor to setup Component and Event handler
    public SelectMapScreen(){
        setPreferredSize(FRAME_SIZE); // set Size of Title Game Screen
        setLayout(null); // use absolute layout
        setBackground(offWhite);

        // Select Map Screen Label
        selectMap = new JLabel();
        selectMap.setText("Select Map !!!");
        selectMap.setBounds(500, 90, 360, 104);
        selectMap.setOpaque(false);
        selectMap.setBackground(Color.RED);
        selectMap.setForeground(black);
        selectMapFont = usingFontsBold(selectMapFont, 50f, "font/Shantell_Sans/ShantellSans-Regular.ttf");
        selectMap.setFont(selectMapFont);
        add(selectMap);

        // Button of Maps (But Label)
        for (int i = 0; i < map.length - 6; i++){ // Row 1
            map[i] = new JLabel();
            map[i].setText(String.valueOf(i));
            map[i].setBounds(new Rectangle(110 + i * (hGap + sizeBtn), 230, sizeBtn, sizeBtn));
            map[i].setOpaque(true);
            map[i].setBackground(mColor[i]);
            map[i].setForeground(offWhite);
            map[i].setHorizontalAlignment(SwingConstants.CENTER);
            map[i].setVerticalAlignment(SwingConstants.CENTER);
            mapBoxFont = usingFontsBold(mapBoxFont, 60f, "font/Oswald/Oswald-Medium.ttf");
            map[i].setFont(mapBoxFont);
            System.out.println("Map : " + map[i].getText());
            add(map[i]);
        }
        for (int i = 6; i < map.length; i++){ // Top Section
            map[i] = new JLabel();
            map[i].setText(String.valueOf(i));
            map[i].setBounds(new Rectangle(110 + (i - 6) * (hGap + sizeBtn), 430 , sizeBtn, sizeBtn));
            map[i].setOpaque(true);
            map[i].setBackground(mColor[i]);
            map[i].setForeground(offWhite);
            map[i].setHorizontalAlignment(SwingConstants.CENTER);
            map[i].setVerticalAlignment(SwingConstants.CENTER);
            mapBoxFont = usingFontsBold(mapBoxFont, 60f, "font/Oswald/Oswald-Medium.ttf");
            map[i].setFont(mapBoxFont);
            System.out.println("Map : " + map[i].getText());
            add(map[i]);
        }

        
        // Event-Hander
        addMouseMotionListener(new Mouse());
    }
    // Main PaintComponents Method
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); // for smoothly 
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

    // Inner Class for Event Handler Section
    private class Mouse extends MouseAdapter{
        @Override
        public void mouseMoved(MouseEvent e) {
        // Check mouse's position
        System.out.println("mouseX:" + e.getX() + ", mouseY:" + e.getY());
        }
    }

    // Main Test Section
    public static void main(String[] args) {
        JFrame frame = new JFrame("Title Game Screen");
        frame.setContentPane(new SelectMapScreen());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    private class OpacityMouseAction extends MouseMotionAdapter{
        
    }
}