package me.elxris.ld25.motor;

import java.util.ArrayList;
import java.util.List;

import me.elxris.ld25.art.Alfabet;
import me.elxris.ld25.art.Background;
import me.elxris.ld25.art.Car;
import me.elxris.ld25.art.Sprite;
import me.elxris.ld25.art.Yo;

public class Game {
    public Mat math;
    private Yo yo;
    private Alfabet alfa;
    private List<Sprite> sprites = new ArrayList<Sprite>();
    private List<Sprite> cars = new ArrayList<Sprite>();
    private Panel panel;
    private Screen scrn;
    private int score = 0;
       
    public Game(Panel pan){
        panel = pan;
        //math = new Mat();
        yo = new Yo();
        sprites.add(new Background("/res/background3", 3, true));
        //sprites.add(new Background("res/background3", 3, true));
        sprites.add(new Background("/res/background2", 2));
        sprites.add(new Background("/res/background"));
        sprites.add(new Car("/res/car", 2));
        scrn = new Screen(getAncho(), getAlto());
        alfa = new Alfabet();
        yo.setX(scrn.getAncho()-yo.getAncho());
    }
    public void paint(){
        scrn.prePaint();
        
        for(Sprite s: sprites){
            s.draw(scrn);
        }
        for(Sprite s: cars){
            s.draw(scrn);
        }
        yo.draw(scrn);
        alfa.draw("Score:"+score, 1, scrn.getAlto()-alfa.getAlto(), scrn);
        scrn.paint(panel.getGraphics());
        return;
    }
    public void addCar(){
        sprites.add(new Car("res/car", 2));
    }
    public void key(int k){
        if(k == 68){//D
            //yo.moveX(1);
        }
        if(k == 87){//W
            if(!yo.isSaltando()){
                yo.initSaltar();
            }
        }
        if(k == 65){//A
            //yo.moveX(-1);
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
        return Principal.ANCHO;
    }
    public int getAlto(){
        return Principal.ALTO;
    }
}
