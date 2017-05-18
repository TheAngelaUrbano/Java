package urbano_a06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Player extends AbstractModel
{
    private int baseSpeed = 5;
    private int playerSpeed = baseSpeed;
    private int initial_x;
    private int initial_y;
    private int x;
    private int y;
    private int width;
    private int height;
    
    public Player(int x, int y)
    {
        super();
        this.x = x;
        this.y = y;
        initial_x = this.x;
        initial_y = this.y;
        this.width = 30;
        this.height = 30;
    }
    
    int getSpeed()
    {
        return playerSpeed;
    }
    
    boolean intersects(Player p)
    {
        int[] xcandidate = {p.getX(),p.getX()+30};
        int[] ycandidate = {p.getY(),p.getY()+30};
        
        for (int x: xcandidate)
        {
            for (int y : ycandidate)
            {
                if (x >= this.getX() && x<= this.getX()+30 && y >= this.getY() && y <= this.getY()+30)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void setX(int x)
    {
        int current_x = this.x;
        this.x = x;
        firePropertyChange("X_property",current_x,this.x);
    }
    
    public void setY(int y)
    {
        int current_y = this.y;
        this.y = y;
        firePropertyChange("Y_property",current_y,this.y);
    }
    
    public void resetPosition()
    {
        int current_x = this.x;
        int current_y = this.y;
        this.x = initial_x;
        this.y = initial_y;
        firePropertyChange("X_property",current_x,this.x);
        firePropertyChange("Y_property",current_y,this.y);
    }
    
    public void moveUp()
    {
        int current_y = this.y;
        this.y -= playerSpeed;
        firePropertyChange("Y_property",current_y,this.y);
    }
    
    public void moveDown()
    {
        int current_y = this.y;
        this.y += playerSpeed;
        firePropertyChange("Y_property",current_y,this.y);
    }
    
    public void moveLeft()
    {
        int current_x = this.x;
        this.x -= playerSpeed;
        firePropertyChange("X_property",current_x,this.x);
    }
    
    public void moveRight()
    {
        int current_x = this.x;
        this.x += playerSpeed;
        firePropertyChange("X_property",current_x,this.x);
    }    
    
    public void setSpeed(int speedChange)
    {
        playerSpeed = baseSpeed + speedChange;
    }
    
    public void makeBetter()
    {
        baseSpeed += 3;
    }
    
}
