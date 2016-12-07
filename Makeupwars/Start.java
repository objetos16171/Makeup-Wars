import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Boton de star, es para iniciar el juego.
 * 
 * @author (Xochil Villanueva) 
 * @version (1.0)
 */
public class Start extends Actor
{
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       click();
    }    
        
        private void click() {
            if(Greenfoot.mouseClicked(this))
            {
                Greenfoot.setWorld(new Level1());
            }
        }
}
