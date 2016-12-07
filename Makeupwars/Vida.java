import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase para la imagen de vida
 * 
 * @author (Naomi Aguiñaga) 
 * @version (1.0)
 */
public class Vida extends Actor
{            
    /**
     *Campia la imagen del objeto a vida media 
     */
    public void setHalf(){
        setImage("hHalf.png");    
    }
    
    /**
     *Campia la imagen del objeto a vida vacia
     */
    public void setEmpty(){
        setImage("hEmpty.png");
    }
    
    /**
     *Campia la imagen del objeto a vida llena
     */
    public void setFull(){
        setImage("hFull.png");
    }
}
