// World
import java.awt.*;
import javax.swing.*;

public class World1 {
    // Construct canvas/World 
    protected DrawWorld canvas;
    protected Color innerWorld, outerWorld; 
    protected int topLeftx;
    protected int topLefty;
    // Constructor
    public World1(){
        this.innerWorld = Color.BLACK;
        this.outerWorld = Color.GREEN;
        this.topLeftx = 30;
        this.topLefty = 20;

        canvas = new DrawWorld();
        canvas.setBackground(outerWorld);

    }
    // Inner Class for paint World
    private class DrawWorld extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(innerWorld);
            g.fillRect(topLeftx, topLefty, canvas.getBounds().width - (2 * topLeftx), canvas.getBounds().height - (2 * topLefty));
        }
    }
}

