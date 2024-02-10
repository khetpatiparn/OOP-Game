import java.awt.*;

public class Box {
    // The Box setup
    protected final int SIZE_BOX = 30;
    private Color boxColor = Color.GREEN;
    protected Rectangle boxChar;

    public Box(int startX, int startY){
        boxChar = new Rectangle(startX, startY, SIZE_BOX, SIZE_BOX);
    }

    public void paintBox(Graphics g) {
        g.setColor(boxColor);
        g.fillRect(boxChar.x, boxChar.y, SIZE_BOX, SIZE_BOX);
    }

    @Override
    public String toString() {
        return "Box [SIZE_BOX=" + SIZE_BOX + ", boxColor=" + boxColor + ", boxChar=" + boxChar + "]";
    }
    
}