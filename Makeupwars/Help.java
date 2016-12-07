import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este es el escenario para mostrar la ayuda
 * 
 * @author (Xochil Villanueva) 
 * @version (1.0)
 */
public class Help extends World
{
    private Ret ret;
    /**
     * Constructor for objects of class Help.
     * 
     */
    public Help()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 350, 1); 
        
        ret=new Ret();
        addObject(ret ,550,300);
    }
}
