import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Map1 extends JPanel{
    // Window Game Size
    private final int FRAME_WIDTH = 1366;
    private final int FRAME_HEIGHT = 768;
    private final Dimension FRAME_SIZE = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);

    // Construct Wall
    private final int WALL_HEIGHT = 30;
    private final int WALL_WIDTH = 40;
    protected Rectangle wallTop = new Rectangle(0, 0, FRAME_WIDTH, WALL_HEIGHT);
    protected Rectangle wallBottom = new Rectangle(0, FRAME_HEIGHT - WALL_HEIGHT, FRAME_WIDTH, WALL_HEIGHT);
    protected Rectangle wallLeft = new Rectangle(0, 0, WALL_WIDTH, FRAME_HEIGHT);
    protected Rectangle wallRight = new Rectangle(FRAME_WIDTH - WALL_WIDTH, 0, WALL_WIDTH, FRAME_HEIGHT);

    // Start positions Setup
    protected final int START_X = 100;
    protected final int START_Y = 100;

    // Goal positions Setup
    protected final int GOAL_X = 1200;
    protected final int GOAL_Y = 620;

    // Construct Box
    protected Box player = new Box(START_X, START_Y);

    // Construct Goal
    protected Goal goal = new Goal(GOAL_X, GOAL_Y);

    // Construct Obstacles Here!! ma friends
    protected Rectangle o1 = new Rectangle(0, 200, 1100, 50);
    protected Rectangle o2 = new Rectangle(250, 500, 1100, 50);
    
    // Construct obstacles Moving
    ObjectMoving o1Moving = new ObjectMoving(1300, 200, 50, 300);
    
    // Construct obstables Rotation

    public Map1(){
        setPreferredSize(FRAME_SIZE);
        
        ActionListener updateTask = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // o1Moving.moveRight2Left(1300, 30, 20);
                repaint();
            }
        };
        new Timer(16, updateTask).start();

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.paintBox(g);
        goal.paintGoal(g);
        paintTheWall(g);
        paintObstacles(g);
        o1Moving.paintMovingObject(g);
    }

    private void paintTheWall(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(wallTop.x, wallTop.y, wallTop.width, wallTop.height);
        g.fillRect(wallBottom.x, wallBottom.y, wallBottom.width, wallBottom.height);
        g.fillRect(wallLeft.x, wallLeft.y, wallLeft.width, wallLeft.height);
        g.fillRect(wallRight.x, wallRight.y, wallRight.width, wallRight.height);
    }
    
    private void paintObstacles(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(o1.x, o1.y, o1.width, o1.height);
        g.fillRect(o2.x, o2.y, o2.width, o2.height);
    }
    
}