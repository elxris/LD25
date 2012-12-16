package me.elxris.art;

import me.elxris.ld25.Game;

public class Yo extends Sprite{
    private int v, vC;
    
    public Yo(Game g) {
        super(g, "res/sprite");
        v = 4;
    }
    
    public void draw(){
        if((vC++)%v == 0)
            addEstado(1);
        super.draw();
    }
    @Override
    public void moveX(int x) {
        super.moveX(x);
    }
    public void moveY(int y) {
        super.moveY(y);
    }
}
