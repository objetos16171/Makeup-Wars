import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta es la clase del objeto mirror que te permimte cambiar de
 * nivel
 * 
 * @author (Naomi Aguiñaga & Xochil Villanueva) 
 * @version (1.3)
 */
public class Mirror extends Actor
{
    int level;
    
    /**
     * Act -Revisa si toco un jugador
     */       
    public void act() 
    {
       checkPlayer(); 
    }    
    
    /**
     * Bandera de a que nivel va a saltar
     */ 
    public void setLevel(int level){
        this.level = level;        
    }
    
    /**
     * Hace el cambio de mundos, para los niveles
     */ 
    public void checkPlayer(){
        World m = getWorld();
        MyWorld l = (MyWorld)m;
        if(isTouching(Player.class) ){
            if(level == 2){
                Level2 l2 = new Level2();
                Greenfoot.setWorld(l2); 
            }
            if(level == 3){
                Level3 l3 = new Level3();
                Greenfoot.setWorld(l3); 
            }
            if(level == 4){
                Final f = new Final();
                Greenfoot.setWorld(f); 
            }                       
        }        
    }
}
