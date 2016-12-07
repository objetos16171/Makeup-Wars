import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Es el boton que te permite visualizar la ayuda.
 * 
 * @author (Xochil Villanueva) 
 * @version (1.0)
 */
public class Ayuda extends Actor
{
    /**
     * Revisa si se dio click al objeto.
     */
    public void act() 
    {
        click();
    }    
    
         private void click()
    {
        if(Greenfoot.mouseClicked(this))
        {
        Greenfoot.setWorld(new Help());   
    }
   }
}
