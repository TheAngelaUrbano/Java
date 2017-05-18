package urbano_a06;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Field extends JPanel
{
   RunningBack rb;
   private int field_width = 700;
   private int field_height = 450;
    
   public Field()
   {
       setPreferredSize(new Dimension(field_width,field_height));
       setBackground(Color.GREEN);
       
   }
   
   public int get_field_width()
   {
       return field_width;
   }           
   
   public int get_field_height()
   {
       return field_height;
   }
   
   public void add(PlayerView view)
   {
       super.add(view);
   }
    
   public void paintComponent(Graphics g)
   {
       super.paintComponent(g);
       
   }
}
