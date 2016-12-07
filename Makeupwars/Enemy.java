import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Esta es la clase que contiene todos los movimientos simples de
 * los enemigos
 * 
 * @author (Naomi Aguiñaga & Xochil Villanueva) 
 * @version (2.7)
 */
public class Enemy extends Actor
{
    int steps = 1;    
    int move;
    int flag = 0; 
    int lifeC;
    boolean moveX;
    boolean moveY;
    boolean lesslife;    
    Balas bala;
    Counter contDir; 
    public SimpleTimer timer; 
    
        /**
         * Este es el constructor, aqui se inicializan las direcciones de 
         * movimiento para hacer la animacion 
         */
        public Enemy(){      
        move = Greenfoot.getRandomNumber(4)+1;  
        timer = new SimpleTimer();
        bala = new Balas();
        contDir = new Counter();        
        moveX = true;
        moveY = true;               
    }
    
    /**
     * Revisa siempre el movimiento
     */
    public void act(){        
        moveRandom(move);                 
    } 
    
    /**
     * Metodo que se utiliza como decodificador del numero random
     */
    public void moveRandom(int move){        
        if(move  == 1 ) {
            flag = 1;
            movecheck(flag);
        }
        if(move == 2){
            flag = 2;
            movecheck(flag);            
        }
        if(move == 3){
            flag = 3;
            movecheck(flag);            
        }
        if(move == 4){            
            flag = 4;
            movecheck(flag);
        }        
    }
    
   /**
     * Este metodo, manda llamar las posiciones para incrementar de acuerdo
     * a la direccion.
     */
    public int movecheck(int flag){                
             if(flag == 1){
                moveup();
                return 1;
            }
            if(flag == 2){
                movedown();
                return 2;
            }
            if(flag == 3){
                moveleft();
                return 3;
            }
            if(flag == 4){
                moveright();
                return 4;
            }        
        return 0;
    }   
    
    /**
     * Cambio de ubicacion, direccion derecha
     */
    public void moveright(){
        setLocation(getX() + steps, getY()); 
    }    
    
    /**
     * Cambio de ubicacion, direccion arriba
     */ 
    public void moveup(){
        setLocation(getX(), getY() - steps);       
    }
    
   /**
     * Cambio de ubicacion, direccion izquierda
     */
    public void moveleft(){
        setLocation(getX() - steps , getY());       
    }
    
    /**
     * Cambio de ubicacion, direccion abajo
     */
    public void movedown(){
        setLocation(getX(), getY() + steps);       
    }    
       
    /**
     * Este metodo determina que hacer en caso de llegar al borde o a la 
     * barra de infomracion.
     */
    public boolean borde(int flag){        
        if(isAtEdge() || getY() < 82){
           if(flag ==1){
               flag =2;
               movecheck(flag);
           }
           if(flag ==2){
               flag = 1;
               movecheck(flag);
           }
           if(flag ==3){
               flag = 4;
               movecheck(flag);
           }
           if(flag ==4){
               flag = 3;
               movecheck(flag);
           }
           return true;
        }         
        return false;   
    }    
    
    /**
     * Aqui se restaura la imagen, para volver a tomar una direccion nueva 
     * cuando borde fue verdadero
     */
    public void restauraE(){
        setLocation(Greenfoot.getRandomNumber(890),Greenfoot.getRandomNumber(460)+50);
    }
    
     /**
     * Este metodo determina si lo toco una bala
     */
    public boolean checkfire(){
        if(isTouching(Balas.class)){            
            getWorld().removeObject(bala);
            return true;
        }
        return false;
    }
    
      
 
}
