import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class TheGame extends JFrame {
    private static final int BAR_X = 8;
    private static final int BAR_Y = 31;
    DrawWorld canvas;
    // Start position Setup
    private int startX = 100;
    private int startY = 100;

    // The Box Setup
    private int boxX = startX - BAR_X;
    private int boxY = startY - BAR_Y; 
    private final int SIZE_BOX = 30;
    private Color colorBox = Color.GREEN;
    // The Goal Setup
    private int goalX = 1000 - BAR_X;
    private int goalY = 500 - BAR_Y;
    private final int SIZE_GOAL = 60;
    private Color colorGoal = Color.RED;

    // Component to check position
    JTextField tfX;
    JTextField tfY;

    public TheGame() {
        canvas = new DrawWorld();
        setPreferredSize(new Dimension(1366, 768));
        setLayout(new FlowLayout());
        setContentPane(canvas);
        // Component
        add(new JLabel("X :"));
        tfX = new JTextField(10);
        tfX.setEditable(false);
        add(tfX);
        add(new JLabel("Y :"));
        tfY = new JTextField(10);
        tfY.setEditable(false);
        add(tfY);
        
        // mouseAction
        MouseAction mouseAction = new MouseAction();
        addMouseMotionListener(mouseAction);
        // Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game");
        pack();
        setVisible(true);
        repaint();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TheGame();
            }
        });
    }
    
    private class DrawWorld extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            paintGoal(g);
            paintBox(g);
        }
    }

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
                if (IsInsideBox(isMouseInsideBox)) {
                    boxX = cursorX - BAR_X - SIZE_BOX / 2;
                    boxY = cursorY - BAR_Y - SIZE_BOX / 2;
                    // System.out.println(e.getPoint());
                    
                    repaint();
                }
                // Box Get Goal
                getGoal();
            }

        private boolean IsInsideBox(boolean nsb){
            if ((cursorX > boxX + BAR_X && cursorX < boxX + BAR_X + SIZE_BOX) && 
                (cursorY > boxY + BAR_Y && cursorY < boxY + BAR_Y + SIZE_BOX)) {
                isMouseInsideBox = true;
            }
            return isMouseInsideBox;
        }
    }

    public void paintBox(Graphics g) {
        g.setColor(colorBox);
        g.fillRect(boxX, boxY, SIZE_BOX, SIZE_BOX);
    }

    public void paintGoal(Graphics g) {
        g.setColor(colorGoal);
        g.fillRect(goalX, goalY, SIZE_GOAL, SIZE_GOAL);
    }

    public void getGoal(){
        // Box Get Goal
        int rightTopB = boxX + SIZE_BOX;
        int rightTopG = goalY + SIZE_GOAL;
        int leftBottomG = goalX + SIZE_GOAL;
        int leftBottomB = boxY + SIZE_BOX;

        if ((rightTopB >= goalX) && (boxY <= rightTopG) 
        && (boxX <= leftBottomG) && (leftBottomB >= goalY)){
            // System.out.println("Congratulations!!!");
            JOptionPane.showInternalMessageDialog(null,"You Win!!", "Congratulation",JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void checkpositionXY(MouseEvent e){
        tfX.setText(e.getX() + "");
        tfY.setText(e.getY() + "");
    }

}