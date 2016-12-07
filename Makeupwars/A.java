import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class A here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class A extends Enemy
{
    int start;   
    boolean check; 
    boolean alive;
    int animationE;
    private GreenfootImage AtrEA; 
    private GreenfootImage DerEA1;
    private GreenfootImage DerEA2;
    private GreenfootImage DerEA3;
    private GreenfootImage FrtEA1;
    private GreenfootImage FrtEA2;
    private GreenfootImage FrtEA3;
    private GreenfootImage IzqEA1;
    private GreenfootImage IzqEA2;
    private GreenfootImage IzqEA3; 
    /**
     * Se inicializan las imagenes y el frame del movimiento
     */
    public A(){        
        super();
        AtrEA = new GreenfootImage("AtrEA.png");
        DerEA1 = new GreenfootImage("DerEA1.png");
        DerEA2 = new GreenfootImage("DerEA2.png");
        DerEA3 = new GreenfootImage("DerEA3.png");
        FrtEA1 = new GreenfootImage("FrtEA1.png");
        FrtEA2 = new GreenfootImage("FrtEA2.png");
        FrtEA3 = new GreenfootImage("FrtEA3.png");
        IzqEA1 = new GreenfootImage("IzqEA1.png");
        IzqEA2 = new GreenfootImage("IzqEA2.png");
        IzqEA3 = new GreenfootImage("IzqEA3.png");        
        animationE = 0;
        start = 1;                                             
    }    
    
    /**
     * En el metodo act, se revisa el borde,la bandera de restaura,
     * el frame de animacion y si aun deberia estar vivo el enemigo.
     */
    public void act() {                        
        check = borde(flag);
        if(check == true )
            restaura();
        moveRandom(move);
        if(animationE % 3 == 0){
            checkanimation();
        }        
        animationE++;        
        alive=checkfire();
        if(alive == true){
            enemyoff();
        }   
        
    }    
    
    /**
     * Este metodo decodifica la direccion, para hacer la animacion
     * respectiva
     */
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
    
    /**
     * Animacion arriba
     */
    public void animationup(){
         if(start == 1)
            setImage(AtrEA);
        else if(start == 2)
            setImage(AtrEA);
          else if(start == 3){
            setImage(AtrEA);
            start = 1;
            return;
        }
        start++;    
    }
    
    /**
     * Animacion arriba
     */
    public void animationdown(){
         if(start == 1)
            setImage(FrtEA1);
        else if(start == 2)
            setImage(FrtEA2);
          else if(start == 3){
            setImage(FrtEA3);
            start = 1;
            return;
        }
        start++;   
    }
    
     public void animationleft(){
         if(start == 1)
            setImage(IzqEA1);
        else if(start == 2)
            setImage(IzqEA2);
          else if(start == 3){
            setImage(IzqEA3);
            start = 1;
            return;
        }
        start++;    
    }
    
    /**
     * Animacion arriba
     */    
       public void animationright(){
         if(start == 1)
            setImage(DerEA1);
        else if(start == 2)
            setImage(DerEA2);
          else if(start == 3){
            setImage(DerEA3);
            start = 1;
            return;
        }
        start++;    
    }
    
    /**
     * Imagen que restaura el enemigo
     */
    public void restaura(){     
        super.restauraE();
        setImage("FrtEA1.png"); 
        check = false;    
    }
    
    /**
     * Remueve al enemigo del mundo
     */
    public void enemyoff(){
        getWorld().removeObject(this);
    }
}
