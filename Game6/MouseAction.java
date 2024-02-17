import java.awt.event.*;

import javax.swing.JOptionPane;

public class MouseAction extends MouseAdapter{
    private boolean isMouseInsideBox = false;
    private Map0 map0;

    private int cursorX;
    private int cursorY;

    public MouseAction(Map0 map0){
        this.map0 = map0;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        cursorX = e.getX();
        cursorY = e.getY();

        if (isMouseInsideBox) {
            map0.player.boxChar.x = cursorX - map0.player.sizeBox / 2; 
            map0.player.boxChar.y = cursorY - map0.player.sizeBox / 2;
            Collistion();
            winGoal();
            map0.repaint();
            
        } else if ((cursorX > map0.player.boxChar.x &&
            cursorX < map0.player.boxChar.x + map0.player.sizeBox) && 
            (cursorY > map0.player.boxChar.y && 
            cursorY < map0.player.boxChar.y + map0.player.sizeBox )){
            isMouseInsideBox = true;
        }
        //Check mouse's position
        System.out.println("mouseX:" + e.getX() + ", mouseY:" + e.getY());
    }

    private void winGoal(){
            // Box Get Goal
            // int rightTopB = map0.player.boxChar.x + map0.player.sizeBox;
            // int rightTopG = map0.goal.goalChar.y + map0.goal.sizeGoal;
            // int leftBottomG = map0.goal.goalChar.x + map0.goal.sizeGoal;
            // int leftBottomB = map0.player.boxChar.y + map0.player.sizeBox;
    
            // if ((rightTopB >= map0.goal.goalChar.x) && (map0.player.boxChar.y <= rightTopG) 
            // && (map0.player.boxChar.x <= leftBottomG) && (leftBottomB >= map0.goal.goalChar.y)){
            //     System.out.println("Congratulations!!!");
            //     ResetPlayer();
                
            //     JOptionPane.showInternalMessageDialog(null,"You Win!!", "Congratulation",JOptionPane.PLAIN_MESSAGE);
            //     map0.repaint();
            // }

            if (map0.player.boxChar.intersects(map0.goal.goalChar)){
                System.out.println("Congratulations!!!");
                ResetPlayer();
                
                JOptionPane.showInternalMessageDialog(null,"You Win!!", "Congratulation",JOptionPane.PLAIN_MESSAGE);
                map0.repaint();
            }
        }

    private void Collistion(){
        // Hit the Wall
        if (map0.player.boxChar.intersects(map0.wallTop) || map0.player.boxChar.intersects(map0.wallLeft) 
            || map0.player.boxChar.intersects(map0.wallRight) || map0.player.boxChar.intersects(map0.wallBottom)){
            // Reset State
            ResetPlayer();
        }
        // Add Hit the Obstacles Here!! ma friends
        if (map0.player.boxChar.intersects(map0.o1)){
            // Reset State
            ResetPlayer();
        }
        // Add hit the moveing's obstacles
        // if (map0.player.boxChar.intersects(map0.o1Moving.object)){
        //     ResetPlayer();
        // }
        // Add hit the rotation's obstacles
        
    }
    
    private void ResetPlayer(){
        isMouseInsideBox = false;
        map0.player.boxChar.x = map0.START_X;
        map0.player.boxChar.y = map0.START_Y;
    }
    
}
