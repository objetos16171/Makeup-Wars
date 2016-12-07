import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends MyWorld
{
    private boolean crear;
    private boolean prepareenemy;
    private boolean item;
    Items items;
    Balas bala ;
    Esmalte esmalte;
    Lip lip ;
    Paleta paleta ;     
    Player player ;    
    private A[] arrayEneA; 
    int level;
    int tiempo;
    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1()
    {
        super();
        which = true; 
        level = 2;
        tiempo = 30;
        prepareEnemies(which);
        mirror.setLevel(level);                                                         
    }             
}
