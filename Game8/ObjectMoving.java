import java.awt.Graphics;
import java.awt.Rectangle;

public class ObjectMoving {
    
    private boolean moveRight = true;
    private boolean moveLeft = true;
    private boolean moveUp = true;
    private boolean moveDown = true;
    
    protected Rectangle object;

    public ObjectMoving(int x, int y, int width, int height){
        object = new Rectangle(x, y, width, height);
        
    }
    public void paintMovingObject(Graphics g){
        g.fillRect(object.x, object.y, object.width, object.height);
    }
    public void moveLeft2Right(int xStart , int xDest, int xSpeed){
        if (moveRight){
            if (object.x < xDest){
                object.x += xSpeed;
            }else{
                moveRight = false;
            }
        }else{
            if(object.x > xStart){
                object.x -= xSpeed;
            }else{
                moveRight = true;
            }
        }
    }
    public void moveRight2Left(int xStart , int xDest, int xSpeed){
        if (moveLeft){
            if (object.x > xDest){
                object.x -= xSpeed;
            }else{
                moveLeft = false;
            }
        }else{
            if(object.x < xStart){
                object.x += xSpeed;
            }else{
                moveLeft = true;
            }
        }
    }
    public void moveUp2Down(int yStart, int yDest, int ySpeed) {
        if (moveDown) {
            if (object.y < yDest) {
                object.y += ySpeed;
            } else {
                moveDown = false;
            }
        } else {
            if (object.y > yStart) {
                object.y -= ySpeed;
            } else {
                moveDown = true;
            }
        }
    }
    public void moveDown2Up(int yStart, int yDest, int ySpeed) {
        if (moveUp) {
            if (object.y > yDest) {
                object.y -= ySpeed;
            } else {
                moveUp = false;
            }
        } else {
            if (object.y < yStart) {
                object.y += ySpeed;
            } else {
                moveUp = true;
            }
        }
    }

    public void moveUp(int yStart, int yDest, int ySpeed){
            if (moveUp) {
                if (object.y > yDest) {
                    object.y -= ySpeed;
                } else {
                    object.y = yStart;
                }
            }
    }
    public void moveDown(int yStart, int yDest, int ySpeed){
        if (moveDown) {
            if (object.y < yDest) {
                object.y += ySpeed;
            } else {
                object.y = yStart;
            }
        }
}

    public void moveRight(int xStart, int xDest, int xSpeed){
        if (moveRight){
            if (object.x < xDest){
                object.x += xSpeed;
            }else{
                object.x = xStart;
            }
        }
    }
    public void moveLeft(int xStart, int xDest, int xSpeed){
        if (moveLeft){
            if (object.x > xDest){
                object.x -= xSpeed;
            }else{
                object.x = xStart;
            }
        }
    }
}
