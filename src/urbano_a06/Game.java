package urbano_a06;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JSlider;

public class Game implements Runnable
{
    private ScorePanel score;
    private Field field;
    private JSlider slider;
    private RunningBack player;
    private ArrayList<LineBacker> linebackers = new ArrayList<>();
    private int numLineBacker = 2;
    
    public Game(ScorePanel score,Field field,JSlider slider)
    {
        this.score = score;
        this.field = field;
        this.slider = slider;
    }
    
    public void run()
    {
        while (true)
        {
            if (player.getX() < 50)
            {
                score.addTouchdown();
                levelUp();
                restart();
            }
            
            //Don't let runningback go past the screen with dimensions of 700 x 400, button dimension = 30 x 30
            if (player.getX() >= 670)
            {
                player.setX(669);
            }
            
            if (player.getY() >= 420)
            {
                player.setY(419);
            }
            else if (player.getY() <= 0)
            {
                player.setY(1);
            }
            
            //Linebacker intersecting the player results in a tackle
            for (Player p : linebackers)
            {
                if (p.intersects(player))
                {
                    score.addTackle();
                    restart();
                }
            }
            
            //Don't let linebackers go past the screen with dimensions of 700 x 400, button dimension = 30 x 30
            for (Player p : linebackers)
            {
                if(p.getY() >= 420)
                {
                    p.setY(419);
                }
                else if(p.getY() <= 0)
                {
                    p.setY(1);
                }
                
                if (p.getX() <= 0)
                {
                    p.setX(1);
                }
                else if (p.getX() >= 670)
                {
                    p.setX(669);
                }
            }
            
            //Set speed depending on slider
            for (Player p : linebackers)
            {
                p.setSpeed(slider.getValue());
            }
            
            player.setSpeed(slider.getValue());
        }
    }
    
    //A tackle increases the level of difficulty by making the linebackers faster
    public void levelUp()
    {
        score.addLevel();
        for (Player p : linebackers)
        {
            p.makeBetter();
        }
        
        //Every 2 levels, add a linebacker (max of 7 linebackers)
        LineBacker lb;
        if (score.getLevel() != 0 && score.getLevel() % 2 == 0 && numLineBacker < 7)
        {
            System.out.println(score.getLevel());
            lb = new LineBacker(50*score.getLevel(),(field.get_field_height()/2),player,linebackers);
            addLB(lb);
            LineBackerView lbview = new LineBackerView(100,100);
            new PlayerController(lb,lbview);
            field.add(lbview);
            numLineBacker++;
            score.gameMessage.setText("Here comes another linebacker!!!");
            score.gameMessage.setForeground(Color.red);
        }
    }
    
    public void restart()
    {
        player.resetPosition();
        for (Player p : linebackers)
        {
            p.resetPosition();
        }
    }
    
    public void addRB(RunningBack rb)
    {
        player = rb;
    }
    
    public void addLB(LineBacker lb)
    {
        linebackers.add(lb);
    }
    
    public int getNumLineBacker()
    {
        return numLineBacker;
    }
}
