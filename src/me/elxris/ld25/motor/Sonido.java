package me.elxris.ld25.motor;

import java.applet.AudioClip;

public class Sonido {
    private AudioClip[] ac;
    private int actual[];
    private int factor = 1; //El multiplicador de objetos de sonido.
    
    public Sonido(AudioClip... audioClips) {
        ac = audioClips;
        actual = new int[ac.length/getFactor()];
    }
    public AudioClip getAc(int n) {
        addActual(n, 1);
        return ac[n*getFactor()+getActual(n)];
    }
    public void reproducir(int n){
        getAc(n).play();
    }
    public void setActual(int n, int actual) {
        this.actual[n] = actual%getFactor();
    }
    public int getActual(int n) {
        return actual[n];
    }
    public void addActual(int n, int plus){
        setActual(n, getActual(n)+plus);
    }
    public int getFactor() {
        return factor;
    }
    public void setFactor(int factor) {
        this.factor = factor;
    }
}
