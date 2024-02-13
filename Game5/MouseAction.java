import java.awt.event.*;

import javax.swing.JOptionPane;

public class MouseAction extends MouseAdapter{
    private boolean isMouseInsideBox = false;
    private Map1 map1;

    private int cursorX;
    private int cursorY;

    public MouseAction(Map1 map1){
        this.map1 = map1;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        cursorX = e.getX();
        cursorY = e.getY();

        if (isMouseInsideBox) {
            map1.player.boxChar.x = cursorX - map1.player.sizeBox / 2; 
            map1.player.boxChar.y = cursorY - map1.player.sizeBox / 2;
            Collistion();
            winGoal();
            map1.repaint();
            
        } else if ((cursorX > map1.player.boxChar.x &&
            cursorX < map1.player.boxChar.x + map1.player.sizeBox) && 
            (cursorY > map1.player.boxChar.y && 
            cursorY < map1.player.boxChar.y + map1.player.sizeBox )){
            isMouseInsideBox = true;
        }
        //Check mouse's position
        // System.out.println("mouseX:" + e.getX() + ", mouseY:" + e.getY());
    }

    private void winGoal(){
            // Box Get Goal
            int rightTopB = map1.player.boxChar.x + map1.player.sizeBox;
            int rightTopG = map1.goal.goalChar.y + map1.goal.sizeGoal;
            int leftBottomG = map1.goal.goalChar.x + map1.goal.sizeGoal;
            int leftBottomB = map1.player.boxChar.y + map1.player.sizeBox;
    
            if ((rightTopB >= map1.goal.goalChar.x) && (map1.player.boxChar.y <= rightTopG) 
            && (map1.player.boxChar.x <= leftBottomG) && (leftBottomB >= map1.goal.goalChar.y)){
                System.out.println("Congratulations!!!");
                ResetPlayer();
                
                JOptionPane.showInternalMessageDialog(null,"You Win!!", "Congratulation",JOptionPane.PLAIN_MESSAGE);
                map1.repaint();
            }
        }

    private void Collistion(){
        // Hit the Wall
        if (map1.player.boxChar.intersects(map1.wallTop) || map1.player.boxChar.intersects(map1.wallLeft) 
            || map1.player.boxChar.intersects(map1.wallRight) || map1.player.boxChar.intersects(map1.wallBottom)){
            // Reset State
            ResetPlayer();
        }
        // Add Hit the Obstacles Here!! ma friends
        if (map1.player.boxChar.intersects(map1.o1) || map1.player.boxChar.intersects(map1.o2)){
            // Reset State
            ResetPlayer();
        }
        // Add hit the moveing's obstacles
        if (map1.player.boxChar.intersects(map1.o1Moving.object)){
            ResetPlayer();
        }
        // Add hit the rotation's obstacles
        
    }
    
    private void ResetPlayer(){
        isMouseInsideBox = false;
        map1.player.boxChar.x = map1.START_X;
        map1.player.boxChar.y = map1.START_Y;
    }
    
}
