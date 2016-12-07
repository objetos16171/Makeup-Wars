import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta es la clase para las balas.
 * 
 * @author (Naomi Aguiñaga) 
 * @version (1.2)
 */
public class Balas extends Actor
{
    
    /**
     *El metodo act, llama el movimiento del objeto y revisar si ha 
     *chocado con algo.
     */     
    public void act() 
    {
        move(4); 
        collision();                
    }  
    
    /**
     *Revisa la direccion que tiene jugador para poder salir en esa 
     *direccion
     */
    public void checkDirection(int flag){
        if(flag == 2){
          setRotation(90);
          setImage("Pañuelo2.png");
        }
        if(flag == 1){            
            setRotation(-90);
            setImage("Pañuelo2.png");
        }
        if(flag == 4){              
            setRotation(0);
            setImage("Pañuelo2.png");
        }
        if(flag == 3){            
            setRotation(180);          
            setImage("Pañuelo2.png");
        }
    }
    
     /**
     *Revisa la colision con el borde del mundo.
     */       
    public void collision(){
        if(isAtEdge()){
            balasoff();
        }        
    } 
    
    /**
     *Elimina el objeto
     */
    public void balasoff(){
        getWorld().removeObject(this);
    }         
    }

