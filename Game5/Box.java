import java.awt.*;

public class Box {
    // The Box setup
    protected int sizeBox = 30;
    private Color boxColor = Color.GREEN;
    protected Rectangle boxChar;

    public Box(int startX, int startY){
        boxChar = new Rectangle(startX, startY, sizeBox, sizeBox);
    }
    public Box(int startX, int startY, int size){
        boxChar = new Rectangle(startX, startY, size, size);
        this.sizeBox = size;
    }


    public void paintBox(Graphics g) {
        g.setColor(boxColor);
        g.fillRect(boxChar.x, boxChar.y, sizeBox, sizeBox);
    }

    @Override
    public String toString() {
        return "Box [SIZE_BOX=" + sizeBox + ", boxColor=" + boxColor + ", boxChar=" + boxChar + "]";
    }
    
}