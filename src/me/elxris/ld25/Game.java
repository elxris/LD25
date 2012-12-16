package me.elxris.ld25;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

import me.elxris.art.*;

public class Game {
    public Mat math;
    private Yo yo;
    private Alfabet alfa;
    private List<Sprite> sprites = new ArrayList<Sprite>();
    public Pix[][] pixels;
       
    public Game(){
        //math = new Mat();
        yo = new Yo(this);
        sprites.add(new Background(this, "res/background3", 3, true));
        sprites.add(new Background(this, "res/background2", 2));
        sprites.add(new Background(this, "res/background"));
        alfa = new Alfabet(this);
        pixels = new Pix[getAncho()][getAlto()];
        for(int x = 0; x < getAncho(); x++){
            for(int y = 0; y < getAlto(); y++){
                pixels[x][y] = new Pix(X(x*5), Y(y*5));
                pixels[x][y].draw();
            }
        }
    }
    
    public void paint(){
        /*for(int x = 0; x < getAncho(); x++){
            for(int y = 0; y < getAlto(); y++){
                pixels[x][y].setColor(Color.BLACK);
                pixels[x][y].draw();
            }
        }*/
        for(Sprite s: sprites){
            s.draw();
        }
        yo.draw();
        //alfa.draw("Hola", 10, 10);
        return;
    }
    
    public int X(int x){
        return x;
    }
    
    public int Y(int y){
        return (Main.ALTO-y);
    }
    
    private boolean isVisible(int x, int y){
        if(x < 0){
            return false;
        }else if(x > -1+getAncho()){
            return false;
        }
        if(y < 0){
            return false;
        }else if(y > -1+getAlto()){
            return false;
        }
        return true;
    }
    
    public void setPixColor(int x, int y, Color c){
        if(isVisible(x, y)){
            pixels[x][y].setColor(c);
            pixels[x][y].draw();
        }
    }
    
    public Color getPixColor(int x, int y){
        if(isVisible(x, y)){
            return pixels[x][y].getColor();
        }else{
            return Color.BLACK;
        }
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
        return Main.ANCHO/5;
    }
    public int getAlto(){
        return Main.ALTO/5;
    }
}
