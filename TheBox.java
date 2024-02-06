import java.awt.*;

public class TheBox {
    // Declare Attribute for Box
    protected int x;
    protected int y;
    protected int size;
    protected Color color;

    // Constructors for Box
    public TheBox(){
        this.x = 100;
        this.y = 100;
        this.size = 50;
        this.color = Color.GREEN;
    }
    // to string
    @Override
    public String toString() {
        return "Box [x=" + x + ", y=" + y + ", size=" + size + ", color=" + color + "]";
    }
    // paint method
    public void paintBox(Graphics g){
        g.fillRect(x, y, size, size); // drawing Sqaure
        g.setColor(color); // color of box
    }

}

