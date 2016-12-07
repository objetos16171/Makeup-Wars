import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase contiene lo relacionado con items, cuando el jugador los
 * toca y la cantidad de puntos de deben sumar
 * @author (Naomi Aguiñaga) 
 * @version (2.3)
 */
public class Items extends Actor
{
    private boolean valor;
    private boolean check;
    public int puntos;
    /**
     * Actualiza banderas
     */
     public Items(){
        valor= true;  
        check = false;
        puntos = 0;
    }
    
    /**
     * Revisa siempre cuando choca con un jugador
     */
    public void act(){
        checkItems();       
    }         
    
    /**
     * Metodo que revisa si choco, le suma el puntaje y remueve el objeto.
     */
    public void checkItems(){        
        Actor a = this.getOneIntersectingObject(Player.class);       
        if(a != null && valor == true){    
            Greenfoot.playSound("Take.wav");
            addScorei();
            remuveItem();            
            valor = false;            
        }          
    }
    
    /**
     * Suma al contador
     */
    public void addScorei(){
        
        Actor a = this.getOneIntersectingObject(Player.class);
        Player p = (Player)a;
        p.addScore(puntos);
    }
    
    /**
     * Remueve el objeto
     */
    public void remuveItem(){
        getWorld().removeObject(this);
    }
    
    
    
   
}
