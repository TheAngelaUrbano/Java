/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urbano_a06;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


import javax.swing.JButton;

/**
 *
 * @author angelaurbano
 */
public class PlayerView extends JButton
{   
    public static final int HEIGHT = 30;
    public static final int WIDTH = 30;
    PlayerController controller; 
    
    public PlayerView(int x, int y)
    {
        super();
        setSize(WIDTH,HEIGHT);
        setLocation(x,y);
    }
    
    void setController(PlayerController c)
    {
        controller = c;
    }
    
    public void set_x(int x)
    {
        setLocation(x,getY());
    }
    
    public void set_y(int y)
    {
        setLocation(getX(),y);
    }


}

