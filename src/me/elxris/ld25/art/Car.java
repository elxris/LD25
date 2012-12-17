package me.elxris.ld25.art;

import me.elxris.ld25.motor.Screen;

public class Car extends Sprite {
    private int vl, count;
    public Car(String src, int v){
        super(src);
        vl = v;
    }
    
    public void draw(Screen scrn) {
        if((count++)%vl == 0){
            moveX(1);
        }
        super.draw(scrn);
        if(getX() > scrn.getAncho()){
            setX(-getAncho());
        }
    }
    public void isSmashed(){
        
    }
}
