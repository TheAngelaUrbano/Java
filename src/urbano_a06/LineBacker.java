package urbano_a06;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class LineBacker extends Player
{
    
    Player rb;
    ArrayList<LineBacker> lb;
   
    public LineBacker(int x, int y,RunningBack rb,ArrayList<LineBacker> linebackers)
    {
        super(x,y);
        Timer timer = new Timer();
        timer.schedule(task,500,500);
        this.rb = rb;
        lb = linebackers;
    }

    MyTimerTask task = new MyTimerTask();
    private class MyTimerTask extends TimerTask
    {
        public void run()
        {
                if (LineBacker.this.rb.getX() < LineBacker.this.getX())
                {
                    LineBacker.this.moveLeft();
                
                    for (LineBacker p : lb)
                    {
                        if (LineBacker.this == p)
                        {
                            continue;
                        }
                        
                        // if linebackers intersect, move to the opposite direction to avoid
                        if (LineBacker.this.intersects(p))
                        {
                            LineBacker.this.moveRight();
                            LineBacker.this.moveRight();
                            LineBacker.this.moveRight();
                            LineBacker.this.moveRight();
                        }
                    }
                
                }
                
                else if(LineBacker.this.rb.getX() > LineBacker.this.getX())
                {
                    LineBacker.this.moveRight();
                    
                    for (LineBacker p : lb)
                    {
                        if (LineBacker.this == p)
                        {
                            continue;
                        }
                            if (LineBacker.this.intersects(p))
                        {
                            LineBacker.this.moveLeft();
                            LineBacker.this.moveLeft();
                            LineBacker.this.moveLeft();
                            LineBacker.this.moveLeft();
                        }
                    }
                    
                } 
                
                if (LineBacker.this.rb.getY() < LineBacker.this.getY())
                {
                    LineBacker.this.moveUp();
                    
                    
                    for (LineBacker p : lb)
                    {
                        if (LineBacker.this == p)
                        {
                            continue;
                        }
                            if (LineBacker.this.intersects(p))
                        {
                            LineBacker.this.moveDown();
                            LineBacker.this.moveDown();
                            LineBacker.this.moveDown();
                            LineBacker.this.moveDown();
                        }
                    }
                }
                
                else if(LineBacker.this.rb.getY() > LineBacker.this.getY())
                {
                    LineBacker.this.moveDown();
                    
                    for (LineBacker p : lb)
                    {
                        if (LineBacker.this == p)
                        {
                            continue;
                        }
                            if (LineBacker.this.intersects(p))
                        {
                            LineBacker.this.moveUp();
                            LineBacker.this.moveUp();
                            LineBacker.this.moveUp();
                            LineBacker.this.moveUp();
                        }
                    }
                }
            
          
        }
        
    };
            
            
}
