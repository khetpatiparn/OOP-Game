import java.awt.*;

public class theBox {
    // Declare field of Box
    protected int startX;
    protected int startY;
    protected int sizeBox;
    protected Color colorBox;
    // Constructor
    public theBox(int startX, int startY, int size){
        this.startX = startX;
        this.startY = startY;
        this.sizeBox = size;
    }

    public theBox(int startX, int startY, int size, Color color){
        this(startX, startY, size);
        this.colorBox = color;
    }

    // Graphics of Box
    public void paintBox(Graphics g){
        g.setColor(colorBox);
        g.fillRect(startX, startY, sizeBox, sizeBox);
    }

    public void paintBox2(Graphics g){
        g.fillRect(startX, startY, sizeBox, sizeBox);
    }
}
