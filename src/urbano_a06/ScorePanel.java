package urbano_a06;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel
{
    private int tackle = 0;
    private int touchdown = 0;
    private int level = 0;
    JLabel tackleCount = new JLabel("Tackle: " + tackle);
    JLabel touchdownCount = new JLabel("Touchdown: " + touchdown); 
    JLabel levelCount = new JLabel("Level: " + level);
    JLabel gameMessage = new JLabel();
    
    public ScorePanel()
    {
       setPreferredSize(new Dimension(600,200));
       setBackground(Color.BLUE);
       this.add(tackleCount);
       this.add(touchdownCount);
       this.add(levelCount);
       this.add(gameMessage);
       tackleCount.setForeground(Color.white);
       touchdownCount.setForeground(Color.white);
       levelCount.setForeground(Color.white);
    }
    
    void addLevel()
    {
        level++;
        levelCount.setText("Level: " + level);
    }
    
    int getLevel()
    {
        return level;
    }
    
    void addTackle()
    {
        tackle++;
        tackleCount.setText("Tackle: " + tackle);
        gameMessage.setText("Nice tackle!");
        gameMessage.setForeground(Color.white);
    }
    
    void addTouchdown()
    {
        touchdown++;
        touchdownCount.setText("Touchdown: " + touchdown);
        gameMessage.setText("Great touchdown!");
        gameMessage.setForeground(Color.white);
    }
    
    
    
}
