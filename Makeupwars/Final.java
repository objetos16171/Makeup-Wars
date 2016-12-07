import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este es la pantalla final del juego.
 * 
 * @author (Xochil Villanueva) 
 * @version (1.0)
 */
public class Final extends World
{
   private Volver volver;
   private Ret ret;
    /**
     * Constructor for objects of class Final.     
     */
    public Final()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(550, 350, 1); 
        volver = new Volver();
        ret=new Ret();
        addObject(volver,420,280);
        addObject(ret,470,290);        
    }
}
