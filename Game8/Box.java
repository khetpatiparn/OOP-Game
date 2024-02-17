import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Box {
    // The Box setup
    protected int sizeBox;
    private Color boxColor;
    protected Rectangle boxChar;

    // Constructor for Constructor the Box
    public Box(int startX, int startY, Color color){
        this.boxColor = color;
        this.sizeBox = 30;
        boxChar = new Rectangle(startX, startY, sizeBox, sizeBox);
    }

    // Constructor for Constructor the Box with size
    public Box(int startX, int startY, int size, Color color){
        this.boxColor = color;
        this.sizeBox = size;
        boxChar = new Rectangle(startX, startY, size, size);
    }

    // paint the Box
    public void paintBox(Graphics g) {
        g.setColor(boxColor);
        g.fillRect(boxChar.x, boxChar.y, sizeBox, sizeBox);
    }

    // To string
    @Override
    public String toString() {
        return "Box [SIZE_BOX=" + sizeBox + ", boxColor=" + boxColor + ", boxChar=" + boxChar + "]";
    }
    
}