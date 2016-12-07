import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ListIterator;
/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends MyWorld
{
    boolean cannot;
    boolean canyes;
    int level;    
    C c;
    D d;        
    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3()
    {
        super();
        c = new C(); 
        d = new D();
         
              
        cannot = true;                
        canyes = true;                               
    }
    
    public void act(){ 
        super.act();
        preparel3();
       setFin();
    }
    
    /*
     * Inicializa los enemigos extras para el mundo.
     */
    public void preparel3(){       
        if( timerItem.getValue() >= 3 && cannot == true){                                      
                addObject(c, Greenfoot.getRandomNumber(500),Greenfoot.getRandomNumber(500)+22);               
                 cannot = false;          
            }             
            if(timerItem.getValue() >= 10 && canyes == true){
            addObject(d, Greenfoot.getRandomNumber(500),Greenfoot.getRandomNumber(500)+22);
            canyes = false;
        }  
        }
        
     public boolean stillAlive(){                  
         List<D> dActor = getObjects(D.class);
         ListIterator<D>  iter = dActor.listIterator();
         if(dActor.isEmpty()){
                return false;
            }
         else{
            return true;
            }
            
        }
        
    public void setFin(){
        boolean alive = stillAlive();
        if(alive == true){
            level = 4;   
        }
        else{
            mirror.setLevel(level); 
        }
        
        }
                         
    }     
         
            
