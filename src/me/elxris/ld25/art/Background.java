package me.elxris.ld25.art;

import java.util.Random;

import me.elxris.ld25.motor.Screen;

public class Background extends Sprite {
    private int pX, v, vC;
    private int[] mapa;
    private int cordenada;
    
    public Background(String src, int v){
        super(src);
        anchoBackground();
        pX = -getAncho();
        this.v = v;
        vC = 0;
    }
    public Background(String src){
        this(src, 1);
    }
    public void draw(Screen scrn){
        if(mapa == null){
            mapa = generarFondo(scrn.getAncho());
        }
        draw2(scrn);
    }
    
    public int anchoBackground(){
        int sum = 0;
        for(int i = 0; i < getLength(); i++){
            setEstado(i);
            sum += getAncho();
        }
        return sum;
    }
    
    public int[] generarFondo(int anchoScreen){
        int sumaAnchoFondos = 0;
        int numFondos = getLength();
        Random rndm = new Random();
        String fondos = "";
        for(; sumaAnchoFondos < anchoScreen*5; sumaAnchoFondos += getAncho()){
            addEstado(rndm.nextInt(numFondos));
            fondos += getEstado()+" ";
        }
        String fondosArray[] = fondos.split(" ");
        int[] result = new int[fondosArray.length];
        int i = 0;
        for(String s: fondosArray){
            result[i++] = Integer.parseInt(s);
        }
        return result;
    }
    public void draw2(Screen scrn){
        move();
        //Dibujar en patnalla.
        int cord = 0;
        for(int i = getPX(); i <= scrn.getAncho(); i+=getAncho()){
            setEstado(getMapa(getCordenada(cord++)));
            setX(i);
            super.draw(scrn);
        }
    }
    public void setPX(int pX){
        this.pX = pX;
    }
    public int getPX(){
        return pX;
    }
    public void addPX(int n){
        setPX(getPX()+n);
    }
    public void addPX(){
        addPX(1);
    }
    public void move(){
        if((vC++)%v == 0){
            addPX();
            if(getPX() >= 0){
                addCordenada();
                setPX(-getAncho(getMapa(getCordenada())));
            }
        }
    }
    public void setCordenada(int cordenada) {
        if(cordenada < 0){
            cordenada = getMapa().length-1;
        }
        this.cordenada = (cordenada)%getMapa().length;
    }
    public int getCordenada(int n){
        return cordenada+n;
    }
    public int getCordenada(){
        return getCordenada(0);
    }
    public void addCordenada(int n){
        setCordenada(getCordenada()+n);
    }
    public void addCordenada(){
        addCordenada(-1);
    }
    public int[] getMapa(){
        return mapa;
    }
    public int getMapa(int n){
        return mapa[n%getMapa().length];
    }
    public void reset(){
        int[] m = null;
        mapa = m;
    }
}
