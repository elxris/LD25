package me.elxris.ld25.motor;

import java.awt.Color;
import java.awt.Graphics;

import me.elxris.ld25.art.Pix;

public class Screen {
    private Pix[][] pixels;
    private int ancho, alto;
    private int size = 5;
    private int sizeX = 5;
    private int sizeY = 4;
    private Color cback;
    
    public Screen(int an, int al) {
        ancho = an;
        alto = al;
        pixels = new Pix[getAncho()][getAlto()];
        for(int x = 0; x < getAncho(); x++){
            for(int y = 0; y < getAlto(); y++){
                pixels[x][y] = new Pix(X(x*5), Y(y*5));
            }
        }
    }
    public void setPixColor(int x, int y, Color c){
        if(isVisible(x, y)){
            pixels[x][y].setColor(c);
        }
    }
    public Color getPixColor(int x, int y){
        if(isVisible(x, y)){
            return pixels[x][y].getColor();
        }else{
            return Color.BLACK;
        }
    }
    public void prePaint(Color c){
        for(int x = 0; x < getAncho(); x++){
            for(int y = 0; y < getAlto(); y++){
                pixels[x][y].setColor(c);
            }
        }
    }
    public void paint(Graphics g){
        for(int x = 0; x < getAncho(); x++){
            for(int y = 0; y < getAlto(); y++){
                g.setColor(getPixColor(x, y));
                g.fillRect(X(x*getSize()), Y(y*getSize()), getSizeX(), getSizeY());
            }
        }
    }
    private boolean isVisible(int x, int y){
        if(x < 0){
            return false;
        }else if(x > getAncho()-1){
            return false;
        }
        if(y < 0){
            return false;
        }else if(y > getAlto()-1){
            return false;
        }
        return true;
    }
    public int getAncho(){
        return ancho/getSize();
    }
    public int getAlto(){
        return alto/getSize();
    }
    public int X(int x){
        return x;
    }
    public int Y(int y){
        return ((getAlto()*getSize())-y);
    }
    public int getSize(){
        return size;
    }
    public int getSizeX(){
        return sizeX;
    }
    public int getSizeY(){
        return sizeY;
    }
    public void setCback(Color cback) {
        this.cback = cback;
    }
    public Color getCback() {
        return cback;
    }
}
