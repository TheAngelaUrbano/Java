package urbano_a06;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class PlayerController implements PropertyChangeListener
{
    Player player;
    PlayerView view;

    public PlayerController(Player player, PlayerView view)
    {
        this.player = player;
        this.view = view;
        setViewController();
        this.player.addPropertyChangeListener(this);
    }
    
    public void setViewController()
    {
        this.view.setController(this);
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) 
    {
        if (evt.getPropertyName().equals("X_property"))
        {
           view.set_x((int)evt.getNewValue());
        }
        
        if (evt.getPropertyName().equals("Y_property"))
        {
            view.set_y((int)evt.getNewValue());
        }
    }
    
    void moveModelLeft()
    {
        player.moveLeft();
    }
    
    void moveModelRight()
    {
        player.moveRight();
    }
    
    void moveModelDown()
    {
        player.moveDown();
    }
    
    void moveModelUp()
    {
        player.moveUp();
    }
    
    void makeModelBetter()
    {
        player.makeBetter();
    }
}
