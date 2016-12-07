import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends MyWorld
{
    int level;
    boolean cannot;
    C c;
    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {
        which = false;
        cannot = true;
        prepareEnemies(which);
        c = new C();
        level = 3;
        mirror.setLevel(level);        
        
    }
    
    public void act(){
        super.act();
        enemyC();
        
    }
    
    /**
     * Prepara el enemigo C para este nivel.    
     */
    public void enemyC(){
        if( timerItem.getValue() >= 3 && cannot == true){                                      
                addObject(c, Greenfoot.getRandomNumber(500),Greenfoot.getRandomNumber(500)+22);               
                 cannot = false;          
            } 
        }

 
}
