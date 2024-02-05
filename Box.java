import java.awt.*;

public class Box {
    // Declare Attribute for Drawing Box
    int x = 100;
    int y = 100;
    int sqaure = 100;
    Color color = Color.BLUE;

    public Box(int x, int y, int square){
        this.x = x;
        this.y = y;
        this.sqaure = square;
    }

    public void paintBox(Graphics g){
        g.fillRect(x, y, sqaure, sqaure);
        g.setColor(color);
    }
}
