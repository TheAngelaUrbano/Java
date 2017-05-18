/*
The objective of this assignment is to create a game in which the running back has to carry the ball to the goal line. 
1.	The tackles will move constantly (using the timer) in pursuit of the running back
2.	The running back movements will be controled by the keyboard 
3.	The actual score (touchdowns and missed attempts) has to be shown.

4.	Implement a JSlider to set the speed of the game 
5.	Implement choices for the runninback team (at least 3 different choices).

6. add more functionality for extra points
*/

package urbano_a06;

import com.sun.prism.paint.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.*;

public class Urbano_A06 
{

    public static void main(String[] args) 
    {
        int minSlider = 0;
        int maxSlider = 15;
        int rb_initial_x = 600;
        int rb_initial_y = 225;
        
        JFrame frame = new JFrame("Tackle-Breaking Running Back");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
       
        Field field = new Field();
        panel.add(field);
        field.setLayout(null);
        
        ScorePanel score = new ScorePanel();
        panel.add(score);
        
        JSlider slider = new JSlider(minSlider,maxSlider);
        Hashtable labels = new Hashtable();
        slider.setFocusable(false);
        slider.setPaintTicks(true);
        labels.put(minSlider,new JLabel("Slow"));
        labels.put(maxSlider, new JLabel("Fast"));
        slider.setLabelTable(labels);
        slider.setPaintLabels(true);
        panel.add(slider);

        Game tournament = new Game(score,field,slider);
        
        RunningBack john = new RunningBack(rb_initial_x,rb_initial_y);
        tournament.addRB(john);
        RunningBackView rb_view = new RunningBackView(rb_initial_x,rb_initial_y);
        new PlayerController(john,rb_view);
        field.add(rb_view);
        
        ArrayList<LineBacker> linebackers = new ArrayList<>();
        int numLineBacker = tournament.getNumLineBacker();
        double division = field.get_field_height() / numLineBacker;
        for (int i = 0; i < numLineBacker; i++)
        {
            double min = division * i;
            double d = min + Math.random() * division;
            LineBacker player = new LineBacker(50,(int) d,john,linebackers);
            tournament.addLB(player);
            LineBackerView lb_view = new LineBackerView(50,(int)d);
            new PlayerController (player,lb_view);
            linebackers.add(player);
            field.add(lb_view);
        }

        frame.pack();
        frame.setVisible(true);
        
        new Thread(tournament).start();
                   
    }
    
}
