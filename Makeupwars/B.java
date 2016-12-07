import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class B here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class B extends Enemy
{
    boolean check;
    boolean alive;
    int start; 
    int animationE;
    private GreenfootImage AtrEB1; 
    private GreenfootImage AtrEB2; 
    private GreenfootImage AtrEB3; 
    private GreenfootImage DerEB1;
    private GreenfootImage DerEB2;
    private GreenfootImage DerEB3;
    private GreenfootImage FrtEB1;
    private GreenfootImage FrtEB2;
    private GreenfootImage FrtEB3;
    private GreenfootImage IzqEB1;
    private GreenfootImage IzqEB2;
    private GreenfootImage IzqEB3;
    /**
     * Act - do whatever the B wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public B() 
    {
        super();        
        AtrEB1 = new GreenfootImage("AtrEB1.png");
        AtrEB2 = new GreenfootImage("AtrEB2.png");
        AtrEB3 = new GreenfootImage("AtrEB3.png");
        DerEB1 = new GreenfootImage("DerEB1.png");
        DerEB2 = new GreenfootImage("DerEB2.png");
        DerEB3 = new GreenfootImage("DerEB3.png");
        FrtEB1 = new GreenfootImage("FrtEB1.png");
        FrtEB2 = new GreenfootImage("FrtEB2.png");
        FrtEB3 = new GreenfootImage("FrtEB3.png");
        IzqEB1 = new GreenfootImage("IzqEB1.png");
        IzqEB2 = new GreenfootImage("IzqEB2.png");
        IzqEB3 = new GreenfootImage("IzqEB3.png");        
        animationE = 0;
        start = 1;
        steps = 1;
    }   
    
    public void act(){
        check = borde(flag);
        if(check == true )
            restaura();
        moveRandom(move);
        if(animationE % 3 == 0){
            checkanimation();
        }
        alive=checkfire();
        if(alive == true){
            enemyoff();
        }
        animationE++;              
    }
    
        public void checkanimation(){       
        if(super.movecheck(flag) == 1)
            animationup();
        if( super.movecheck(flag)== 2)
            animationdown();
        if(super.movecheck(flag) == 3)
            animationleft();
        if(super.movecheck(flag)== 4)
            animationright();       
    }
    
    public void animationup(){
         if(start == 1)
            setImage(AtrEB1);
        else if(start == 2)
            setImage(AtrEB2);
          else if(start == 3){
            setImage(AtrEB3);
            start = 1;
            return;
        }
        start++;    
    }
    
    public void animationdown(){
         if(start == 1)
            setImage(FrtEB1);
        else if(start == 2)
            setImage(FrtEB2);
          else if(start == 3){
            setImage(FrtEB3);
            start = 1;
            return;
        }
        start++;    
    }
    
     public void animationleft(){
         if(start == 1)
            setImage(IzqEB1);
        else if(start == 2)
            setImage(IzqEB2);
          else if(start == 3){
            setImage(IzqEB3);
            start = 1;
            return;
        }
        start++;    
    }
    
       public void animationright(){
         if(start == 1)
            setImage(DerEB1);
        else if(start == 2)
            setImage(DerEB2);
          else if(start == 3){
            setImage(DerEB3);
            start = 1;
            return;
        }
        start++;    
    }
    
    public void restaura(){     
        super.restauraE();
        setImage("FrtEB1.png"); 
        check = false;    
    }
    
     public void enemyoff(){
        getWorld().removeObject(this);
    }
}
