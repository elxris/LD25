package me.elxris.ld25.art;

import me.elxris.ld25.motor.Screen;

public class Background extends Sprite {
    private int ancho;
    private int x, v, vC;
    private boolean overlap;
    
    public Background(String src, int v, boolean... bool){
        super(src);
        if(bool.length > 0){
            overlap = bool[0];
        }
        ancho = anchoBackground();
        x = 0;
        this.v = v;
        vC = 0;
    }
    
    public Background(String src, boolean... bool) {
        this(src, 1, bool);
    }
    
    public void draw(Screen scrn){
        if((vC++)%v == 0)
            x++;
        x = x%ancho;
        setEstado(0);
        for(int i = 0; i <= scrn.getAncho()+ancho; i+=ancho){
            setX(i+x-ancho);
            for(int e = 0; e < getEstadoLength(); e++){
                setEstado(e);
                super.draw(scrn);
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
