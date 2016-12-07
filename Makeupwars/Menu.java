import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este es el escenario de menu con botones para
 * crear diferentes mundos.
 * 
 * @author (Xochil Villanueva) 
 * @version (1.0)
 */
public class Menu extends World
{
    private Names names;
    private Ayuda ayuda;
    private Start start;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        names=new Names();
        ayuda=new Ayuda();
        start=new Start();         
        addObject(names,300,50);
        addObject(ayuda, 80, 150);  
        addObject(start,580,150); 
    }
}
