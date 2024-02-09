import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TheGame extends JFrame {
    // Window Game Size
    private final int FRAME_WIDTH = 1366;
    private final int FRAME_HEIGHT = 768;
    private Dimension dim = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);

    // Declare canvas
    private DrawCanvas canvas;

    // Start positions Setup
    private int startX = 100;
    private int startY = 100;

    // The Box Setup
    private int boxX = startX;
    private int boxY = startY; 
    private final int SIZE_BOX = 30;
    private Color colorBox = Color.GREEN;
    private Rectangle boxChar = new Rectangle(boxX, boxY, SIZE_BOX, SIZE_BOX);

    // The Goal Setup
    private int goalX = 300;
    private int goalY = 500;
    private final int SIZE_GOAL = 60;
    private Color colorGoal = Color.RED;

    // Component to check position
    // private JTextField tfX;
    // private JTextField tfY;
    
    // Declare Wall
    private final int WALL_HEIGHT = 30;
    private final int WALL_WIDTH = 40;
    private Rectangle wallTop = new Rectangle(0, 0, FRAME_WIDTH, WALL_HEIGHT);
    private Rectangle wallBottom = new Rectangle(0, FRAME_HEIGHT - WALL_HEIGHT, FRAME_WIDTH, WALL_HEIGHT);
    private Rectangle wallLeft = new Rectangle(0, 0, WALL_WIDTH, FRAME_HEIGHT);
    private Rectangle wallRight = new Rectangle(FRAME_WIDTH - WALL_WIDTH, 0, WALL_WIDTH, FRAME_HEIGHT);

    // Constructor to Setup Component and Event-Handler
    public TheGame() {
        // Construct canvas into Frame
        canvas = new DrawCanvas();
        canvas.setPreferredSize(dim); // setSize Canvas
        // setLayout(new FlowLayout()); // Layout Manger of Components
        setContentPane(canvas); // set ContentPane

        // Component to show Mouse's position
        // add(new JLabel("X :")); // X Mouse's position
        // tfX = new JTextField(10);
        // tfX.setEditable(false);
        // add(tfX);
        // add(new JLabel("Y :")); // Y Mouse's position
        // tfY = new JTextField(10);
        // tfY.setEditable(false);
        // add(tfY);
        
        // Register MouseAction with listener 
        MouseAction mouseAction = new MouseAction();
        canvas.addMouseMotionListener(mouseAction);

        // Set up Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game");
        pack(); // fit with canvas
        setVisible(true);
        repaint();
        System.out.println(getWidth());
    }

    // Inner class for Drawing Canvas 
    private class DrawCanvas extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // paintGoal(g);
            // paintBox(g);
            TheWall(g);
        }
    }
    // Inner class for Control The Box follows with Mouse
    private class MouseAction extends MouseAdapter{
        private boolean isMouseInsideBox = false;

        private int cursorX;
        private int cursorY;

        @Override
        public void mouseMoved(MouseEvent e) {
            // Check postion
            checkpositionXY(e);
            // Move the box
            cursorX = e.getX();
            cursorY = e.getY();
            
            if (isMouseInsideBox) {
                boxChar.x = cursorX - SIZE_BOX / 2;
                boxChar.y = cursorY - SIZE_BOX / 2;
                // System.out.println(e.getPoint());
                repaint();
                // Collistion();
                // getGoal();
            } else {
                if ((cursorX > boxChar.x && cursorX < boxChar.x + SIZE_BOX) && 
                    (cursorY > boxChar.y && cursorY < boxChar.y + SIZE_BOX)) {
                    isMouseInsideBox = true;
                }
            }
        }

        private void checkpositionXY(MouseEvent e){
            System.out.println("mouseX:" + e.getX() + ", mouseY:" + e.getY());
        }

        private void getGoal(){
            // Box Get Goal
            int rightTopB = boxChar.x + SIZE_BOX;
            int rightTopG = goalY + SIZE_GOAL;
            int leftBottomG = goalX + SIZE_GOAL;
            int leftBottomB = boxChar.y + SIZE_BOX;
    
            if ((rightTopB >= goalX) && (boxChar.y <= rightTopG) 
            && (boxChar.x <= leftBottomG) && (leftBottomB >= goalY)){
                // System.out.println("Congratulations!!!");
                isMouseInsideBox = false;
                
                boxChar.x = startX;
                boxChar.y = startY;
                
                JOptionPane.showInternalMessageDialog(null,"You Win!!", "Congratulation",JOptionPane.PLAIN_MESSAGE);
                repaint();
            }
        }

        private void Collistion(){
            if (boxChar.intersects(wallTop) || boxChar.intersects(wallLeft) || boxChar.intersects(wallRight) || boxChar.intersects(wallBottom)){
                isMouseInsideBox = false;

                boxChar.x = startX;
                boxChar.y = startY;
            }
        }
    }

    private void paintBox(Graphics g) {
        g.setColor(colorBox);
        g.fillRect(boxChar.x, boxChar.y, boxChar.width, boxChar.height);
    }

    private void paintGoal(Graphics g) {
        g.setColor(colorGoal);
        g.fillRect(goalX, goalY, SIZE_GOAL, SIZE_GOAL);
    }

    private void TheWall(Graphics g){
        // g.setColor(Color.BLACK);
        g.fillRect(wallTop.x, wallTop.y, wallTop.width, wallTop.height);
        g.fillRect(wallBottom.x, wallBottom.y, wallBottom.width, wallBottom.height);
        g.fillRect(wallLeft.x, wallLeft.y, wallLeft.width, wallLeft.height);
        g.fillRect(wallRight.x, wallRight.y, wallRight.width, wallRight.height);

    }
}