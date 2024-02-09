import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyFrame extends JFrame{
    Image image;
    Graphics graphics;
    Box player;
    Box enemy;
    boolean gameOver;
    MyFrame(){
        
        player = new Box(100, 300, 50, 50, Color.BLUE);
        enemy = new Box(400, 300, 50, 50, Color.RED);
        gameOver = false;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setVisible(true);

        this.addKeyListener(new AL());
    }
    public void paint(Graphics g){
        image = createImage(this.getWidth(), this.getHeight());
        graphics = image.getGraphics();
        g.drawImage(image,0,0,this);

        player.draw(g);
        enemy.draw(g);
    }

    public void checkCollistion(){
        if(player.intersects(enemy)){
            gameOver = true;
            // System.out.println("Game Over!");
            JOptionPane.showMessageDialog(null, "Game Over!!");
        }
    }
    public class AL extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            player.keyPressed(e);
            checkCollistion();
            repaint();
        }
    }
}