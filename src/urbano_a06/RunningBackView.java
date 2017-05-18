/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urbano_a06;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author angelaurbano
 */
public class RunningBackView extends PlayerView
{
    public RunningBackView(int x, int y)
    {
        super(x,y);
        MyKeyListener c = new MyKeyListener();
        MyActionListener a = new MyActionListener();
        this.addKeyListener(c);
        this.addActionListener(a);
    }
    
    public class MyKeyListener implements KeyListener
    {
        @Override
        public void keyTyped(KeyEvent e) 
        {

        }

        @Override
        public void keyPressed(KeyEvent e) 
        {
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_LEFT:
                    controller.moveModelLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    controller.moveModelRight();
                    break;
                case KeyEvent.VK_UP:
                    controller.moveModelUp();
                    break;
                case KeyEvent.VK_DOWN:
                    controller.moveModelDown();
                    break;

                default:
                    System.out.println("Invalid key stroke");
            }

        }

        @Override
        public void keyReleased(KeyEvent e) 
        {

        }
    }
    
    
    public class MyActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
                controller.makeModelBetter();
        }      
    };
      
  
}
