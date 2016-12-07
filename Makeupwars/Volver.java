import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este es la clase para el objeto boton que te hace volver a jugar
 * 
 * @author (Xochil Villanueva) 
 * @version (1.0)
 */
public class Volver extends Actor
{
    /**
     * Act - do whatever the Volver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        click();
    }    
    
     private void click()
    {
        if(Greenfoot.mouseClicked(this))
        {
        Greenfoot.setWorld(new Level1()); 
    }
   }
}
