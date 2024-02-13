import java.awt.*;

public class Goal{
    // The Goal Setup
    protected int sizeGoal = 50;
    private Color colorGoal = Color.BLUE;
    protected Rectangle goalChar;

    public Goal(int goalX, int goalY){
        goalChar = new Rectangle(goalX, goalY, sizeGoal, sizeGoal);
    }

    public Goal(int goalX, int goalY, int size){
        goalChar = new Rectangle(goalX, goalY, sizeGoal, sizeGoal);
        this.sizeGoal = size;
    }

    public void paintGoal(Graphics g){
        g.setColor(colorGoal);
        g.fillRect(goalChar.x, goalChar.y, sizeGoal, sizeGoal);
    }

    @Override
    public String toString() {
        return "Goal [SIZE_GOAL=" + sizeGoal + ", colorGoal=" + colorGoal + ", goal=" + goalChar + "]";
    }
}