import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Goal{
    // The Goal Setup
    protected int sizeGoal;
    private Color colorGoal;
    protected Rectangle goalChar;

    // Constructor for Constructor the Goal
    public Goal(int goalX, int goalY, Color colorGoal){
        this.colorGoal = colorGoal;
        this.sizeGoal = 50;
        goalChar = new Rectangle(goalX, goalY, sizeGoal, sizeGoal);
    }

    // Constructor for Constructor the Goal define with size
    public Goal(int goalX, int goalY, int size, Color colorGoal){
        this.colorGoal = colorGoal;
        this.sizeGoal = size;
        goalChar = new Rectangle(goalX, goalY, size, size);
    }

    // paint the Goal
    public void paintGoal(Graphics g){
        g.setColor(colorGoal);
        g.fillRect(goalChar.x, goalChar.y, sizeGoal, sizeGoal);
    }

    // to String
    @Override
    public String toString() {
        return "Goal [SIZE_GOAL=" + sizeGoal + ", colorGoal=" + colorGoal + ", goal=" + goalChar + "]";
    }
}