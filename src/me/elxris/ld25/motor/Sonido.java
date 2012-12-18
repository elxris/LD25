package me.elxris.ld25.motor;

import java.applet.AudioClip;

public class Sonido {
    private AudioClip[] ac;
    public Sonido(AudioClip...audioClips) {
        ac = audioClips;
    }
    public AudioClip getAc(int n) {
        return ac[n];
    }
    public void reproducir(int n){
        getAc(n).play();
    }
}
