import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Enemigo clase C
 * 
 * @author (Naomi Aguiñaga & Xochil Villanueva) 
 * @version (a version number or a date)
 */
public class C extends Enemyfolloxer
{
    int start; 
    int animationE;
    int flag;    
    int liveC;
    boolean alive;
    boolean canM;        
    private GreenfootImage AtrEC1; 
    private GreenfootImage AtrEC2; 
    private GreenfootImage AtrEC3; 
    private GreenfootImage DerEC1;
    private GreenfootImage DerEC2;
    private GreenfootImage DerEC3;
    private GreenfootImage FrtEC1;
    private GreenfootImage FrtEC2;
    private GreenfootImage FrtEC3;
    private GreenfootImage IzqEC1;
    private GreenfootImage IzqEC2;
    private GreenfootImage IzqEC3;       
    
    /**
     * Se asiganan las imagenes y se inicializan las banderas y contadores
     */
    public C() 
    {                
        AtrEC1 = new GreenfootImage("AtrEC1.png");
        AtrEC2 = new GreenfootImage("AtrEC2.png");
        AtrEC3 = new GreenfootImage("AtrEC3.png");
        DerEC1 = new GreenfootImage("DerEC1.png");
        DerEC2 = new GreenfootImage("DerEC2.png");
        DerEC3 = new GreenfootImage("DerEC3.png");
        FrtEC1 = new GreenfootImage("FrtEC1.png");
        FrtEC2 = new GreenfootImage("FrtEC2.png");
        FrtEC3 = new GreenfootImage("FrtEC3.png");
        IzqEC1 = new GreenfootImage("IzqEC1.png");
        IzqEC2 = new GreenfootImage("IzqEC2.png");
        IzqEC3 = new GreenfootImage("IzqEC3.png");                                        
        animationE = 0;
        start = 1;        
        steps = 1;
        flag = 0;  
        liveC = 3;        
        canM = true; 
        alive = true;         
    }    
    
    /**
     * Se llama el tiempo de reccion, la fucion de seguir y revisar cuando 
     * el jugador le quito una vida.
     */
    public void act(){
        timerDir();                 
         canM = true;            
         follow();
        checkanimation();                 
        setUbicacion();
         lessLife();
        animationE++;
        }            
    
       /**
        * Revisa la bandera de mmovimiento para asignar animacion
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
            setImage(AtrEC1);
        else if(start == 2)
            setImage(AtrEC2);
          else if(start == 3){
            setImage(AtrEC3);
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
            setImage(FrtEC1);
        else if(start == 2)
            setImage(FrtEC2);
          else if(start == 3){
            setImage(FrtEC3);
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
            setImage(IzqEC1);
        else if(start == 2)
            setImage(IzqEC2);
          else if(start == 3){
            setImage(IzqEC3);
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
            setImage(DerEC1);
        else if(start == 2)
            setImage(DerEC2);
          else if(start == 3){
            setImage(DerEC3);
            start = 1;
            return;
        }
        start++;    
    }    
    
    /**
     * Revisa el contador de los enemigos para que sus vidas llegen a 0
     */
    public void lessLife(){
        lesslife = checkfireCD();
        if(lesslife == true && canM == true){
            liveC--;                      
        }         
        if(liveC <= 0){
            getWorld().removeObject(this);            
            }                         
    }      
}


