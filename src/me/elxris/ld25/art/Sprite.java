package me.elxris.ld25.art;

import java.awt.Color;
import java.io.InputStream;
import java.util.Scanner;

import me.elxris.ld25.motor.Screen;

public abstract class Sprite {
    private Image[] imgs;
    private Paleta paleta;
    private int estado = 0;
    private int x, y;
    private int ticks;
    private int v; //Cuantos movimientos por tick.
    private int mx, my;
    
    public Sprite(String src){
        ticks = 0;
        v = 2;
        InputStream in = getClass().getResourceAsStream(src);
        System.out.println(src);
        Scanner entrada = new Scanner(in);
        entrada.next();
        imgs = new Image[entrada.nextInt()];
        for(int i = 0; i < imgs.length; i++){
            int alto, ancho;
            alto = entrada.nextInt();
            ancho = entrada.nextInt();
            int x, y;
            x = entrada.nextInt();
            y = entrada.nextInt();
            int[][] imagen = new int[alto][ancho];
            for(int al = alto-1; al >= 0; al--){
                for(int an = 0; an < ancho; an++){
                    imagen[al][an] = entrada.nextInt();
                }
            }
            imgs[i] = new Image(alto, ancho, x, y, imagen);
            
        }
        paleta = new Paleta(entrada.next());
        entrada.close();
    }
    private Image get(){
        return imgs[estado];
    }
    public Color getPixelColor(int x, int y){
        return paleta.color(get().getPixel(x, y));
    }
    public int getIntColor(int x, int y){
        return get().getPixel(x, y);
    }
    public void draw(Screen scrn){
        addX(mx);
        addY(my);
        stopMove();
        for(int x = 0; x < get().getAncho(); x++){
            for(int y = 0; y < get().getAlto(); y++){
                scrn.setPixColor(get().getX()+getX()+x, get().getY()+getY()+y, getPixelColor(x, y));
            }
        }
    }
    public int getAlto(){
        return get().getAlto();
    }
    public int getAncho(){
        return get().getAncho();
    }
    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return x;
    }
    public void addX(int n){
        setX(getX()+n);
    }
    public void setY(int y){
        this.y = y;
    }
    public int getY(){
        return y;
    }
    public void addY(int n){
        setY(getY()+n);
    }
    public void moveX(int x){
        mx=x;
    }
    public void moveY(int y){
        my=y;
    }
    public void stopMove(){
        mx = 0;
        my = 0;
    }
    public int getEstadoLength(){
        return imgs.length;
    }
    public void setEstado(int n){
        estado = n%imgs.length;
    }
    public int getEstado(){
        return estado;
    }
    public void addEstado(int n){
        setEstado(getEstado()+n);
    }
    public void setTicks(int n){
        ticks = n%v;
    }
    public int getTicks(){
        return ticks;
    }
    public void addTicks(int n){
        setTicks(getTicks()+n);
    }
    public void setColor(int e, Color c){
        paleta.setColor(e, c);
    }
}
