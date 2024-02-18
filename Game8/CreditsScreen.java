import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class CreditsScreen extends JPanel {

    Font creditsTitleFont, nameFont, CbackBtnFont;

    JLabel creditsTitle, name1, name2, name3;
    JLabel CbackBtn;

    private Color offWhite = new Color(250, 249, 246);


    public CreditsScreen(){
        setLayout(null);
        setBounds(380, 70, 600, 650);;
        setBackground(new Color(130, 130, 130, 230));

        creditsTitle = new JLabel();
        creditsTitle.setText("CREDITS");
        creditsTitle.setBounds(190, 60, 454, 104);
        creditsTitle.setForeground(offWhite);
        creditsTitleFont = usingFontsBold(creditsTitleFont, 60f, "font/Oswald/Oswald-Medium.ttf");
        creditsTitle.setFont(creditsTitleFont);
        add(creditsTitle);

        name1 = new JLabel();
        name1.setText("66050253  PATIPARN LAKORN");
        name1.setBounds(60, 200, 450, 80);
        // name1.setOpaque(true);
        // name1.setBackground(Color.BLACK);
        name1.setForeground(offWhite);
        nameFont = usingFontsBold(nameFont, 35f, "font/Oswald/Oswald-Medium.ttf");
        name1.setFont(nameFont);
        add(name1);

        name2 = new JLabel();
        name2.setText("66050635  CHATCHAI");
        name2.setBounds(60, 300, 450, 80);
        name2.setForeground(offWhite);
        nameFont = usingFontsBold(nameFont, 35f, "font/Oswald/Oswald-Medium.ttf");
        name2.setFont(nameFont);
        add(name2);

        name3 = new JLabel();
        name3.setText("66050752  TANAKORN");
        name3.setBounds(60, 400, 450, 80);
        name3.setForeground(offWhite);
        nameFont = usingFontsBold(nameFont, 35f, "font/Oswald/Oswald-Medium.ttf");
        name3.setFont(nameFont);
        add(name3);
        
        // BackButton (But use Label)
        CbackBtn = new JLabel();
        CbackBtn.setText("BACK");
        CbackBtn.setBounds(213, 546, 150, 50);
        CbackBtn.setOpaque(true);
        CbackBtn.setBackground(new Color(166, 166, 166).darker().darker());
        CbackBtn.setForeground(offWhite.darker());
        CbackBtn.setHorizontalAlignment(SwingConstants.CENTER);
        CbackBtn.setVerticalAlignment(SwingConstants.CENTER);
        CbackBtnFont = usingFontsBold(CbackBtnFont, 25f, "font/Shantell_Sans/ShantellSans-Regular.ttf");
        CbackBtn.setFont(CbackBtnFont);
        add(CbackBtn);

        addMouseMotionListener(new MousePositionCheck());
        addMouseMotionListener(new OpacityCBackBtn());

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

    private class MousePositionCheck extends MouseAdapter{
        @Override
        public void mouseMoved(MouseEvent e) {
        // Check mouse's position
        System.out.println("mouseX:" + e.getX() + ", mouseY:" + e.getY());
        }
    }

    private class OpacityCBackBtn extends MouseMotionAdapter{
        @Override
        public void mouseMoved(MouseEvent e) {
            super.mouseMoved(e);
            // Hold over on Back Label
            if (CbackBtn.getBounds().contains(e.getPoint())){
                CbackBtn.setBackground(new Color(166, 166, 166));
                CbackBtn.setForeground(offWhite.darker().darker());
            }else{
                CbackBtn.setBackground(new Color(166, 166, 166).darker().darker());
            }
        }
    }
}