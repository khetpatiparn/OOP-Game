import java.awt.*;

public class Goal{
    // The Goal Setup
    protected final int SIZE_GOAL = 60;
    private Color colorGoal = Color.BLUE;
    protected Rectangle goalChar;

    public Goal(int goalX, int goalY){
        goalChar = new Rectangle(goalX, goalY, SIZE_GOAL, SIZE_GOAL);
    }

    public void paintGoal(Graphics g){
        g.setColor(colorGoal);
        g.fillRect(goalChar.x, goalChar.y, goalChar.width, goalChar.height);
    }

    @Override
    public String toString() {
        return "Goal [SIZE_GOAL=" + SIZE_GOAL + ", colorGoal=" + colorGoal + ", goal=" + goalChar + "]";
    }
    
}
