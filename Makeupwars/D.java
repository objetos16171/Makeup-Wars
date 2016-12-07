import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class C here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class D extends Enemyfolloxer
{
    int start; 
    int animationE;
    int flag;
    int liveD;
    int puntaje;    
    boolean canM;
    boolean track;
    boolean canbullet;    
    private GreenfootImage AtrED1; 
    private GreenfootImage AtrED2; 
    private GreenfootImage AtrED3; 
    private GreenfootImage DerED1;
    private GreenfootImage DerED2;
    private GreenfootImage DerED3;
    private GreenfootImage FrtED1;
    private GreenfootImage FrtED2;
    private GreenfootImage FrtED3;
    private GreenfootImage IzqED1;
    private GreenfootImage IzqED2;
    private GreenfootImage IzqED3;    
    smartbom crem;
       
    /**
     * Inicializa imagenes y contadores
     */
    public D()
    {
        super();        
        AtrED1 = new GreenfootImage("AtrED1.png");
        AtrED2 = new GreenfootImage("AtrED2.png");
        AtrED3 = new GreenfootImage("AtrED3.png");
        DerED1 = new GreenfootImage("DerED1.png");
        DerED2 = new GreenfootImage("DerED2.png");
        DerED3 = new GreenfootImage("DerED3.png");
        FrtED1 = new GreenfootImage("FrtED1.png");
        FrtED2 = new GreenfootImage("FrtED2.png");
        FrtED3 = new GreenfootImage("FrtED3.png");
        IzqED1 = new GreenfootImage("IzqED1.png");
        IzqED2 = new GreenfootImage("IzqED2.png");
        IzqED3 = new GreenfootImage("IzqED3.png");                                                  
        animationE = 0;
        start = 1;        
        steps = 1;
        flag = 0;  
        liveD = 7;                
        canM = true;  
        track= true;
        canbullet = true;         
    }    
    
    /**
     * Contador para el tiempo de balas, tiempo de reaccion, revisa balas,
     * cambio de direccion, y resta de vida.
     */
    public void act(){
        timerDir();                 
         canM = true;            
         follow();
        checkanimation();                          
         bulletD();
         if(contDir.getValue() % 50 == 0){                      
                track = true;
            }
         setUbicacion();
         lessLife(); 
        animationE++;
    }
    
    /**
     * Revisa la animacion
     */
        public void checkanimation(){
       int ani = follow();
        if(ani == 1)
            animationup();
        if( ani== 2)
            animationdown();
        if(ani == 3)
            animationleft();
        if(ani== 4)
            animationright();       
    }
    
    /**
     * Animacion para arriba
     */
    public void animationup(){
         if(start == 1)
            setImage(AtrED1);
        else if(start == 2)
            setImage(AtrED2);
          else if(start == 3){
            setImage(AtrED3);
            start = 1;
            return;
        }
        start++;    
    }
    
    /**
     * Animacion para abajo
     */
    public void animationdown(){
         if(start == 1)
            setImage(FrtED1);
        else if(start == 2)
            setImage(FrtED2);
          else if(start == 3){
            setImage(FrtED3);
            start = 1;
            return;
        }
        start++;    
    }
    
    /**
     * Animacion para la izquierda
     */
     public void animationleft(){
         if(start == 1)
            setImage(IzqED1);
        else if(start == 2)
            setImage(IzqED2);
          else if(start == 3){
            setImage(IzqED3);
            start = 1;
            return;
        }
        start++;    
    }
    
    /**
     * Animacion para la derecha
     */
       public void animationright(){
         if(start == 1)
            setImage(DerED1);
        else if(start == 2)
            setImage(DerED2);
          else if(start == 3){
            setImage(DerED3);
            start = 1;
            return;
        }
        start++;    
    }
    
    /**
     * Resta la vida de el enemigo
     */
    public void lessLife(){
        lesslife = checkfireCD();
        if(lesslife == true && canM == true){
            liveD--;                      
        }                         
        if(liveD <= 0){
            getWorld().removeObject(this);            
            }                         
    }
    
    /**
     * Añade su bala
     */
    public void bulletD(){
        Level3 lev = new Level3();         
        if(track == true){
            if(contDir.getValue() % 5 == 0 && canbullet == true){     
                crem = new smartbom();
                getWorld().addObject(crem, getX() +5, getY());                 
                canbullet = false;
            }
            track = false;
        }                                
      }         
}
