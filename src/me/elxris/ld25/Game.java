package me.elxris.ld25;

import java.util.List;
import java.util.ArrayList;

import me.elxris.art.*;

public class Game {
    public Mat math;
    private Yo yo;
    private Alfabet alfa;
    private List<Sprite> sprites = new ArrayList<Sprite>();
    private Panel panel;
    private Screen scrn;
       
    public Game(Panel pan){
        panel = pan;
        //math = new Mat();
        yo = new Yo();
        sprites.add(new Background("res/background3", 3, true));
        sprites.add(new Background("res/background2", 2));
        sprites.add(new Background("res/background"));
        scrn = new Screen(getAncho(), getAlto());
        alfa = new Alfabet();
    }
    public void paint(){
        scrn.prePaint();
        for(Sprite s: sprites){
            s.draw(scrn);
        }
        yo.draw(scrn);
        alfa.draw("Hola", 10, 10, scrn);
        scrn.paint(panel.getGraphics());
        return;
    }
    public void key(int k){
        if(k == 68){//D
            yo.moveX(1);
        }
        if(k == 87){//W
            //yo.moveY(1);
        }
        if(k == 65){//A
            yo.moveX(-1);
        }
        if(k == 83){//S
            //yo.moveY(-1);
        }
    }
    public void keyR(int k){
        if(k == 68){//D
            yo.moveX(0);
        }
        if(k == 87){//W
            yo.moveY(0);
        }
        if(k == 65){//A
            yo.moveX(0);
        }
        if(k == 83){//S
            yo.moveY(0);
        }
    }
    public int getAncho(){
        return Main.ANCHO;
    }
    public int getAlto(){
        return Main.ALTO;
    }
}
