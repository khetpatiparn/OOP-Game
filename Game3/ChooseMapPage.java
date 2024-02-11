import javax.swing.*;
import java.awt.*;

public class ChooseMapPage extends JPanel{
    // Window Game Size
    private final int FRAME_WIDTH = 1366;
    private final int FRAME_HEIGHT = 768;
    private final Dimension FRAME_SIZE = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);

    // Declare Components
    JButton chMap1, chMap2, chMap3, chMap4, chMap5, chMap6, chMap7, chMap8, chMap9, chMap10;

    // Constructor for Setup Component
    public ChooseMapPage(){
        setPreferredSize(FRAME_SIZE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.GRAY);

        // Construcdt Button
        chMap1 = new JButton("LEVEL 01");
        chMap1.setPreferredSize(new Dimension(500, 500));
        // Add Buttons
        add(chMap1);

        chMap2 = new JButton("LEVEL 02");
        chMap2.setPreferredSize(new Dimension(500, 500));
        add(chMap2);

        chMap3 = new JButton("LEVEL 03");
        chMap3.setPreferredSize(new Dimension(500, 500));
        add(chMap3);

        chMap4 = new JButton("LEVEL 04");
        chMap4.setPreferredSize(new Dimension(500, 500));
        add(chMap4);

        chMap5 = new JButton("LEVEL 05");
        chMap5.setPreferredSize(new Dimension(500, 500));
        add(chMap5);

        chMap6 = new JButton("LEVEL 06");
        chMap6.setPreferredSize(new Dimension(500, 500));
        add(chMap6);

        chMap7 = new JButton("LEVEL 07");
        chMap7.setPreferredSize(new Dimension(500, 500));
        add(chMap7);

        chMap8 = new JButton("LEVEL 08");
        chMap8.setPreferredSize(new Dimension(500, 500));
        add(chMap8);

        chMap9 = new JButton("LEVEL 09");
        chMap9.setPreferredSize(new Dimension(500, 500));
        add(chMap9);

        chMap10 = new JButton("LEVEL 10");
        chMap10.setPreferredSize(new Dimension(500, 500));
        add(chMap10);
    }
}
