// About Game.java for input Worlds or Maps and Properties
// Game has got Frame only
import java.awt.*;
import javax.swing.*;

public class Game extends JFrame {
    // Construct Frame
    private final int FRAME_WIDTH  = 1366;
    private final int FRAME_HEIGHT = 768;

    World1 world; // Declare World
    TheBox box; 
    // Constructor to setup Worlds/Maps, Obstacles and The Box
    public Game() {
        // Set UP World/Maps , Obstacles and The Box Zone
        // ContentPane & Construct World
        world = new World1();
        setContentPane(world.canvas);
        // Construct TheBox
        
        




        //////////////////////////////////////////////////
        
        // Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game");
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Game();
    }
}
