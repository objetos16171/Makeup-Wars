import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ListIterator;
/**
 * Clase de smartbom
 * 
 * @author (Naomi Aguiñaga) 
 * @version (1.3)
 */
public class smartbom extends Actor
{
    /**
     * Act Se mueve siempre una posicion, detecta al jugador
     * revisa lac colisiones
     */
    public void act() 
    {         
        masCercano();
        move(1);
        collision();
    }
    
    /**
     *Entrega la distancia a la que se encuentra el jugador
     */
    public double distance(Actor a){
        int x= getX();
        int y = getY();        
        int dx = x- a.getX();
        int dy = y- a.getY();        
        return Math.sqrt( dx * dx + dy * dy);
    }
    
    /**
     * Hace una lista con los objetos mas cercanos para seguirlos
     */
    public void masCercano(){
        double distancia;
        Player cercano;
        World my = getWorld();
        List<Player> theplayer = my.getObjects(Player.class);
        ListIterator<Player>  iter = theplayer.listIterator();
        if(theplayer.isEmpty()){
            return;
        }        
        Player current = iter.next();
        distancia = distance(current);
        cercano = current;
        while(iter.hasNext()){
            current = iter.next();
            double cDst = distance(current);
            if(cDst < distancia){
                distancia = cDst;
                cercano = current;
            }
        }        
        turnTowards(cercano.getX(), cercano.getY());        
    }
    
    /**
     * Detecta las colisiones con las balas
     */
    public void collision(){
        if(isTouching(Balas.class)){
            getWorld().removeObject(this);
        }        
    }        
}
