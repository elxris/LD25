package me.elxris.art;

import java.util.Random;

import me.elxris.ld25.Game;

public class Background extends Sprite {
    private int ancho;
    private int x, v, vC;
    private boolean overlap;
    
    public Background(Game g, String src, int v, boolean... bool){
        super(g, src);
        if(bool.length > 0){
            overlap = bool[0];
        }
        ancho = anchoBackground();
        x = 0;
        this.v = v;
        vC = 0;
        
    }
    
    public Background(Game g, String src, boolean... bool) {
        this(g, src, 1, bool);
    }
    
    public void draw(){
        if((vC++)%v == 0)
            x++;
        x = x%ancho;
        setEstado(0);
        for(int i = 0; i <= getGame().getAncho()+ancho; i+=ancho){
            setX(i+x-ancho);
            for(int e = 0; e < getEstadoLength(); e++){
                setEstado(e);
                super.draw();
                if(!overlap){
                    addX(getAncho());
                }
            }
        }
    }
    
    public int anchoBackground(){
        int sum = 0;
        for(int i = 0; i < getEstadoLength(); i++){
            setEstado(i);
            if(overlap){
                sum = Math.max(sum, getAncho());
            }else{
                sum += getAncho();
            }
        }
        return sum;
    }
}
