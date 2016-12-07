import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este es el objeto que te retorna al menu.
 * 
 * @author (Xochil Villanueva) 
 * @version (1.0)
 */
public class Ret extends Actor
{
    /**
     * Revisa si al objeto se le dio un click.
     */
    public void act() 
    {
        click();
    }    
 private void click()
    {
        if(Greenfoot.mouseClicked(this))
        {
        Greenfoot.setWorld(new Menu()); 
    }
}
}
