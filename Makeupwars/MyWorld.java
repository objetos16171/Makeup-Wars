import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Esta clase contiene todos los elementos para la jugabilidad del 
 * proyecto, asi como sus herramientas.
 * 
 * @author (Naomi Aguiñaga & Xochil Villanueva) 
 * @version (2.3)
 */
public class MyWorld extends World
{   

    private SimpleTimer timer;   
    public Counter timerDisplay;
    public Counter timerItem;
    public Counter puntosI;
    private boolean crear;
    private boolean prepareenemy;
    private boolean item;
    private boolean made;
    private int startX; 
    private int startY;
    public boolean which;
    Items items;
    Balas bala ;
    Esmalte esmalte;
    Lip lip ;
    Mirror mirror;
    Paleta paleta ;   
    Player player ;  
    
    D enemyD;
    private A[] arrayEneA;   
    private B[] arrayEneB; 

    /**
     * El constructor contiene todos los elementos presentes en cada nivel
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(890, 522, 1);
        startX = 445;
        startY = 266;

        crear = true;
        item = true;  
        made = true;
        prepareenemy = true;       
        

        timer = new SimpleTimer();
        items = new Items();
        bala = new Balas();
        arrayEneA = new A[3];
        arrayEneB = new B[3];
        lip = new Lip();        
        player = new Player(this);
        mirror = new Mirror();

        timerDisplay = new Counter("Time: ");                
        timerItem = new Counter("Timeaslknfaj: ");
        puntosI = new Counter("PuntosI: "); 

        addObject(player,Greenfoot.getRandomNumber(50)+500,Greenfoot.getRandomNumber(500)+22);        
        addObject(timerDisplay , 200 , 22);  
        addObject(puntosI , 50 , 22);

        
    }
   
    /**
     * Metodo utilizado para crear los enemigos simples requeridos en el 
     * nivel 1 y 2. Requiere de un boolean para saber cuales son los
     * necesarios dependiento del nivel.
     * 
     */
    public void prepareEnemies(boolean which){
        int enemyX = 50;
        int enemyY = 90; 
        if( prepareenemy == true && which == true){
            for(int x = 0; x < 3 ; x++){
                arrayEneA[x] = new A();            
                addObject(arrayEneA[x], enemyX, enemyY);               
                enemyX = enemyX * 3;            
            }           
            prepareenemy = false;
        }
        else{
            enemyX = 50;
            enemyY = 90;         
            if(which == false ){
                for( int c = 0; c < 3 ; c++){
                    arrayEneB[c] = new B();            
                    addObject(arrayEneB[c], enemyX, enemyY);               
                    enemyY = enemyY * 3;            
                }       
            }
        }
    }

    /**
     * Este es el act, en el cual colocamos timer para mantener el contador
     * andando y checktime que coloca a los items en el mundo.     
     */
    public void act(){
        timerIni();
        checkTimer();  
        checkLife();
    }

    /**
     * Contador del tiempo,items y actualizacion de banderas por segundo.    
     */
    public void timerIni(){
        if(timer.millisElapsed() > 1000 ){
            crear = true;
            item = true;
            timerDisplay.add(1);
            timerItem.add(1);
            timer.mark();
        }
    }

    /**
     * Añade items en el mundo y el espejo del siguiente nivel.     
     */
    public void checkTimer(){
        if(timerItem.getValue() % 1 == 0 && crear == true && timerItem.getValue() != 0){            
            prepareE();
            crear = false;   
        }
        if(timerItem.getValue() % 6 == 0 && item == true  && timerItem.getValue() != 0){            
            prepareP();
            item = false;
        }       
        if(timerItem.getValue() % 30 == 0 && made == true && timerItem.getValue() !=0){                  
            addObject(mirror, 822, 445); 
            made = false;
        }        
         if(timerItem.getValue() % 20 == 0 && item == true  && timerItem.getValue() != 0){            
            prepareL();
            item = false;            
        }     
    }         
     
    /**
     * Metodo que se encarga de subir el puntaje,dependiendo del parametro
     * que enviemos
     */
    public void addScoreM(int puntos){       
        if(puntos == 1)
            puntosI.add(1);
        if(puntos == 5)
            puntosI.add(5); 
        if(puntos == 30)
            puntosI.add(30); 
    }

    /**
     * Prepara el item esmalte.    
     */
    public void prepareE(){
        int coorX = Greenfoot.getRandomNumber(850);
        int coorY = Greenfoot.getRandomNumber(460)+50;   
        if(crear == true){  
            esmalte   = new Esmalte();
            addObject(esmalte, coorX, coorY);
        }
    }

    /**
     * Prepara el item paleta.    
     */
    public void prepareP(){
        int coorX = Greenfoot.getRandomNumber(850); 
        int coorY = Greenfoot.getRandomNumber(460)+50;         
        if (item = true){
            paleta = new Paleta();
            addObject(paleta,coorX,coorY);
        }
    }    
    
    /**
     * Prepara el item lip.    
     */
    public void prepareL(){
        int coorX = Greenfoot.getRandomNumber(850);
        int coorY = Greenfoot.getRandomNumber(460)+50;         
        if (item = true){
            lip = new Lip();
            addObject(lip,coorX,coorY);            
        }
    }  

    /**
     * Retorna el puntaje del jugador  
     */
    public int getPuntaje(){
        int puntos = puntosI.getValue();
        return puntos;
    }           
    
    public void checkLife(){
        int x = player.getLives();
        if(x <= 0){
            End fin = new End();
                Greenfoot.setWorld(fin);
        }
    
    }
    
    
    }
 