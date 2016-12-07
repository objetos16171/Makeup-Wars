import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase jugador
 * 
 * @author (Naomi Aguiñaga & Xochil Villanueva) 
 * @version (3.4)
 */
public class Player extends Actor
{
    int start = 1;
    int move = 12;
    int animation = 0;
    int contVidas;
    int x;
    int control;
    boolean vidaB ;
    boolean made;
    private GreenfootImage AtrP1;
    private GreenfootImage AtrP2;
    private GreenfootImage AtrP3;
    private GreenfootImage AtrP4;
    private GreenfootImage DerP1;
    private GreenfootImage DerP2;
    private GreenfootImage DerP3;
    private GreenfootImage DerP4;
    private GreenfootImage FrenteP1;
    private GreenfootImage FrenteP2;
    private GreenfootImage FrenteP3;
    private GreenfootImage FrenteP4;
    private GreenfootImage IzqP1;
    private GreenfootImage IzqP2;
    private GreenfootImage IzqP3;
    private GreenfootImage IzqP4;    
    Vida stamina;
    Carga carga;
    public Counter lives;
    public Counter bullet;
    Balas bala;    
    
    public Player(World world){
        AtrP1 = new GreenfootImage("AtrP1.png");
        AtrP2 = new GreenfootImage("AtrP2.png");
        AtrP3 = new GreenfootImage("AtrP3.png");        
        DerP1 = new GreenfootImage("DerP1.png");
        DerP2 = new GreenfootImage("DerP2.png");
        DerP3 = new GreenfootImage("DerP3.png");        
        FrenteP1 = new GreenfootImage("FrenteP1.png");
        FrenteP2 = new GreenfootImage("FrenteP2.png");
        FrenteP3 = new GreenfootImage("FrenteP3.png");        
        IzqP1 = new GreenfootImage("IzqP1.png");
        IzqP2 = new GreenfootImage("IzqP2.png");
        IzqP3 = new GreenfootImage("IzqP3.png");                      
        stamina = new Vida();
        lives = new Counter("Vidas: ");
        bullet = new Counter("Balas: ");
        carga = new Carga();
        lives.setValue(3);        
        world.addObject(lives , 769 , 22);                
        x = 200;
        contVidas = 1000;
        control = 10;
        made = true;
        vidaB = true;                
    }
    
    /**
     * Act. revisa el frame, lee el teclado para la direccion, revisa la vida
     */
    public void act() 
    {
        int flag = 0;
        animation++;
        flag = leerTeclado();        
        fire(flag);       
        vidaB = true;
        checkVida();
        if(vidaB == false)
        {
            contVidas--;
            if(contVidas == 0)
            {
                vidaB = true;                
                contVidas = 1000;
            }
        }                  
    }  
    
    /**
     * Revisa la tecla que se presiono
     */    
    public int leerTeclado(){
        int flagM =0;        
         if(Greenfoot.isKeyDown("w")){
             flagM = 1;
             movecheck(flagM);
             return 1;             
            }else if (Greenfoot.isKeyDown("s")){
             flagM = 2;
             movecheck(flagM);
             return 2;             
            }else if (Greenfoot.isKeyDown("a")){               
                flagM = 3;
                movecheck(flagM);
                return 3;                
            }else if (Greenfoot.isKeyDown("d")){
             flagM = 4;
             movecheck(flagM); 
              return 4;             
       }
       else {
        return 0;
        }              
    }
    
    /**
     * Detecta la direccion del jugador
     */    
    public void movecheck(int flagM){
        if(animation % 4 == 0){            
            if(flagM == 1)
                moveup();
            if(flagM == 2)
                movedown();
            if(flagM == 3)
                moveleft();
            if(flagM == 4)
                moveright();
        }        
    }
    
    /**
     * Movimiento hacia la derecha
     */    
    public void moveright(){
        setLocation(getX() + move, getY());     
         aniRight();
    }
    
    /**
     * Animacion hacia la derecha
     */ 
    public void aniRight(){        
            if(start == 1)
            setImage(DerP1);
        else if(start == 2)
            setImage(DerP2);
          else if(start == 3){
            setImage(DerP3);
            start = 1;
            return;
        }
        start++;
    }
    
    /**
     * Movimiento hacia la izquierda
     */ 
    public void moveleft(){
        setLocation(getX() - move, getY());     
         aniLeft();
    }
    
    /**
     * Animacion hacia la izquierda
     */ 
    public void aniLeft(){
           if(start == 1)
            setImage(IzqP1);
        else if(start == 2)
            setImage(IzqP2);
          else if(start == 3){
            setImage(IzqP3);
            start = 1;
            return;
        }
        start++;
    }
    
    /**
     * Movimiento hacia arriba
     */ 
    public void moveup(){
        setLocation(getX(), getY() - move ); 
        aniUp();
    }
    
    /**
     * Animacion hacia arriba
     */ 
    public void aniUp(){
            if(start == 1)
            setImage(AtrP1);
        else if(start == 2)
            setImage(AtrP2);
          else if(start == 3){
            setImage(AtrP3);
            start = 1;
            return;
        }
        start++;
    }
    
    /**
     * Movimiento hacia abajo
     */ 
    public void movedown(){
        setLocation(getX(), getY() + move );     
            aniDown();
    }
    
    /**
     * Animaicon hacia abajo
     */ 
    public void aniDown(){
            if(start == 1)
            setImage(FrenteP1);
        else if(start == 2)
            setImage(FrenteP2);    
          else if(start == 3){
            setImage(FrenteP3);
            start = 1;
            return;
        }
        start++;
    }  
    
    /**
     * Añade al puntaje los la suma correspondiente
     */ 
    public void addScore(int puntos){       
       World w = getWorld();
       MyWorld my = (MyWorld)w;
       my.addScoreM(puntos);
       my.addObject(carga,325,23);
       bullet.add(1);
       made = true;
    }
    
    /**
     * Dispara respecto a la direccion que llevaba el jugador
     */ 
    public void fire(int flag){
        if(Greenfoot.isKeyDown("l") && made == true){
            if(bullet.getValue() >= 0){
                MyWorld mw = (MyWorld)getWorld();
                bala = new Balas();
                mw.addObject(bala,0,0);
                bala.setLocation(getX()+5,getY()+5);
                bala.checkDirection(flag);
                Greenfoot.playSound("fire.wav");
                mw.removeObject(carga);
                bullet.add(-1);
                made = false;
            }
        }
    }
    
    /**
     * Revisa las vidas del jugador, y cuando detecta el bonus de vida.     
     */ 
    public void checkVida(){        
        Actor a = this.getOneIntersectingObject(Enemy.class);  
        getWorld().addObject(stamina, 845,23);
         Actor b = this.getOneIntersectingObject(Lip.class);
        removeTouching(Lip.class);   
        Actor c = this.getOneIntersectingObject(smartbom.class);
        removeTouching(smartbom.class);
        if(a != null && vidaB == true){   
             int x= a.getX();
             int y = a.getY();
             x = x *4;
             y = y *2;
            setLocation(x,y);
            addVidas(); 
            setVidas();
            vidaB = false;                 
        }
          if(b != null && vidaB == true){            
             lives.add(1);
             setVidas();                       
        } 
        if(c != null && vidaB == true){               
            addVidas(); 
            setVidas();
            vidaB = false;                 
        }
    }
    
        /**     
     * Cambia la imagen de las vidas.
     */
    public void setVidas(){        
        if(lives.getValue() == 3){
            stamina.setFull();          
        }        
        if(lives.getValue() == 2){
            stamina.setHalf();            
        }    
        if(lives.getValue() == 1){
            stamina.setEmpty();            
        }        
        if(lives.getValue() <= 0){
            getWorld().stopped();
        }
    }
    
        /**
     * Resta una vida
     */
    public void addVidas(){        
        lives.add(-1);        
    }    
   
     /**
     * De vuelve las vidas del jugador
     */
    public int getLives(){
        int live = lives.getValue();
        return live;
    }
}
