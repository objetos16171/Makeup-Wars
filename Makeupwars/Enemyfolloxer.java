import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Esta clase contiene el movimiento de seguir al usuario, la velocidad 
 * de reaccion,la posibilidad de cambio de direccion,la interseccion 
 * con las balas, y el cambio de lugar cuando choca con el jugador.
 * @author (Naomi Aguiñaga) 
 * @version (1.8)
 */
public class Enemyfolloxer extends Enemy
{            
    /**
     * Metodo que determina la direccion que debe llevar para seguir al
     * jugador, asi como su velocidad de reaccion.
     */        
    public int follow(){
        Player user = lookingAt();
        if( user!= null){
            int px = user.getX();
            int py = user.getY();
            boolean can = setMove();
            if( contDir.getValue() % 3 == 0 && can == true){
                if(px < getX()){
                    //Se va hacia la izquierda
                    moveX = false;                    
                    flag = 3;
                    return 3;                    
                }
                else{
                   // se va a la derecha
                    moveX = false;
                    flag = 4;
                    return 4;                    
                }                
            }            
            if(contDir.getValue() % 5 == 0 && can == false){
                if( getY() < py){
                    //va hacia abajo
                    moveY = false;
                    flag = 2; 
                    return 2;                    
                }
                else{
                    // va arriba
                    moveY = false;
                    flag = 1;
                    return 1;                    
                }
            }
        }
        else
            return 0;
        //Actualiza la bandera , para modificar la direccion
        movecheck(flag);        
        return 0;
    }
    
    /**
     * Metodo encargado de hacer una lista con los objetos tipo player,que
     * estan en un rango de 530.
     */  
    public Player lookingAt(){
        List<Player> p;
        p = getObjectsInRange(530,Player.class);
        if(!p.isEmpty()){
            Player person = p.get(p.size()-1);           
            if(person != null){
                return person;
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }              
    
    /**
     * Timer, para la velocidad de reaccion de el enemigo.
     */  
     public void timerDir(){
        if(timer.millisElapsed() > 100 ){         
            contDir.add(1);            
            timer.mark();
        }        
    }
    
    /**
     * Actualiza las banderas que permiten el movimiento.
     */ 
    public boolean setMove(){
        if(contDir.getValue() % 2 == 0 && contDir.getValue() != 0){
            moveX = true;
            moveY = true;      
            return true;
        }
        return false;               
    }        
    
   /**
     * Revisa si al enemigo C y D fueron tocados por una bala.
     */ 
    public boolean checkfireCD(){
        Actor a = this.getOneIntersectingObject(Balas.class);  
        if(a!= null){ 
            Balas bala = (Balas)a;
            bala.balasoff();
            return true;            
        }
        return false;
    }      
    
    /**
     * Cambia la ubicacion, al chocar con el jugador.
     */ 
    public void setUbicacion(){        
        if(isTouching(Player.class)){
            setLocation(Greenfoot.getRandomNumber(300), 400);
        }
    }
}


