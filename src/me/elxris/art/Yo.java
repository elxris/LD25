package me.elxris.art;

import me.elxris.ld25.Screen;

public class Yo extends Sprite{
    private int v, vC;
    
    public Yo() {
        super("res/sprite");
        v = 4;
    }
    
    public void draw(Screen scrn){
        if((vC++)%v == 0)
            addEstado(1);
        super.draw(scrn);
    }
    @Override
    public void moveX(int x) {
        super.moveX(x);
    }
    public void moveY(int y) {
        super.moveY(y);
    }
}
