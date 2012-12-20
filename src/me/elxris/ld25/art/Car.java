package me.elxris.ld25.art;

import java.util.Random;

import me.elxris.ld25.motor.Screen;

public class Car extends Sprite {
    private int vl, count;
    private boolean smash;
    private static int cars = 0;
    private boolean visible;
    
    public Car(String src, int v){
        super(src);
        cars++;
        smash = false;
        vl = v;
        setVisible();
        setX(-getAncho());
    }
    public Car(String src, int v, int[] e){ //Para los que requieran colores al azar. e son los colores que pueden tomar.
        this(src, v);
        Random rndm = new Random();
        setColor(e[0], e[rndm.nextInt(e.length)]);
    }
    public void draw(Screen scrn) {
        if((count++)%vl == 0){
            moveX(1);
        }
        if(getVisible()){
            super.draw(scrn);            
        }
        if(getX() > scrn.getAncho()){
            setX(-getAncho());
        }
    }
    public boolean isForSmashing(Screen scrn){ // Dice si está en una posición en la que puedan aplastarlo.
        if(isSmashed()){
            return false;
        }
        int pos = (scrn.getAncho()-getX())-15;
        if((pos < getAncho())&&(pos > -getAncho())){
            return true;
        }
        return false;
    }
    public void smash(){
        setEstado(1);
        smash = true;
        cars--;
    }
    public boolean isSmashed(){
        return smash;
    }
    public static void resetCountCars(){
        cars = 0;
    }
    public static int getCountCars(){
        return cars;
    }
    public boolean isTrash(){
        if(smash && isOut()){
            return true;
        }
        return false;
    }
    public boolean isOut(){
        return ((getX() == -getAncho()) && ((count%vl) == 0));
    }
    public void setVisible(){
        visible = true;
    }
    public void setInvisible(){
        visible = false;
    }
    public boolean getVisible(){
        return visible;
    }
}
