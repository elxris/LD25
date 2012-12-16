package me.elxris.art;

import java.awt.Color;
import java.awt.Graphics;

import me.elxris.ld25.Game;

public class Pix{
    private int x, y;
    private int size = 4;
    private static Graphics g;
    private Color c;
    
    public Pix(int x, int y){
        this(x, y, Color.BLACK);
    }
    public Pix(int x, int y, Color c, Graphics g){
        setX(x);
        setY(y);
        setColor(c);
        this.g = g;
    }
    
    public void draw(Graphics g){
        g.setColor(c);
        g.fillRect(getX(), getY(), size+1, -size);
    }
    
    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getY(){
        return y;
    }
    public void setColor(Color c){
        if(c != null){
            this.c = c;
        }
    }
    public Color getColor(){
        return c;
    }
    public void setSize(int s){
        size = s;
    }
    public int getSize(){
        return size;
    }
}
