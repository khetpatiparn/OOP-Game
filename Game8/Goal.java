import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Goal{
    // The Goal Setup
    protected int sizeGoal;
    private Color colorGoal;
    protected Rectangle goalChar;
    protected int weightGoal;
    protected int heightGoal;

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

    // Custom Goal
    public Goal(int goalX, int goalY, int w, int h, Color colorGoal){
        this.colorGoal = colorGoal;
        this.weightGoal = w;
        this.heightGoal = h;
        goalChar = new Rectangle(goalX, goalY, w, h);
    }

    // paint the Goal
    public void paintGoal(Graphics g){
        g.setColor(colorGoal);
        g.fillRect(goalChar.x, goalChar.y, sizeGoal, sizeGoal);
    }
    public void paintGoalCustomSize(Graphics g){
        g.setColor(colorGoal);
        g.fillRect(goalChar.x, goalChar.y, weightGoal, heightGoal);
    }

    // to String
    @Override
    public String toString() {
        return "Goal [SIZE_GOAL=" + sizeGoal + ", colorGoal=" + colorGoal + ", goal=" + goalChar + "]";
    }
}