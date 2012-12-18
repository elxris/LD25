package me.elxris.ld25.motor;

import java.awt.Color;

import me.elxris.ld25.art.Alfabet;
import me.elxris.ld25.art.Stage;
import me.elxris.ld25.art.yo.Dinosaurio;
import me.elxris.ld25.art.yo.YoRobot;
import me.elxris.ld25.art.yo.Yo;

public class Game {
    private Yo yo[] = new Yo[2];
    private int yoC = 0;
    private Alfabet alfa;
    private Panel panel;
    private Screen scrn;
    private int score = 0;
    private int estado = 0;
    private int vida = 3;
    private Stage[] stages = new Stage[2];
    private Sonido sonido;
    private boolean changed;
       
    public Game(Panel pan, Sonido sonido){
        panel = pan;
        setSonido(sonido);
        
        String s[] = {"/res/background3", "/res/background2", "/res/background", "/res/car"};
        stages[0] = new Stage(s);
        String s2[] = {"/res/dayclouds", "/res/bosque", "/res/grass", "/res/conejo"};
        stages[1] = new Stage(s2);
        stages[1].setCback(new Color(206, 236, 239));
        
        scrn = new Screen(getAncho(), getAlto());
        alfa = new Alfabet();
        
        Dinosaurio dino = new Dinosaurio(getScrn().getAncho(), 2);
        dino.setSonido(getSonido());
        setYo(dino);
        addYoC(1);
        YoRobot robot = new YoRobot(getScrn().getAncho(), 2);
        robot.setSonido(getSonido());
        setYo(robot);
        addYoC(1);
    }
    public void paint(){
        scrn.prePaint(getStage().getCback());
        getStage().pintar(this);
        getYo().draw(scrn);
        alfa.draw("Score:"+score, 1, scrn.getAlto()-alfa.getAlto(), scrn, 1);
        alfa.draw(getVidaString(), scrn.getAncho()-20, scrn.getAlto()-alfa.getAlto(), scrn, 2);
        scrn.paint(panel.getGraphics());
        Change();
        return;
    }
    public void key(int k){
        if(k == 32){//W
            if(!getYo().isAtacando()){
                getYo().initAtacar();
            }
        }
    }
    public void keyR(int k){
        
    }
    public int getAncho(){
        return Principal.ANCHO;
    }
    public int getAlto(){
        return Principal.ALTO;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }
    public void addScore(int score){
        setScore(getScore()+score);
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public int getVida() {
        return vida;
    }
    public void addVida(int vida){
        setVida(getVida()+vida);
        if(getVida() <= 0){
            // TODO something
            setChanged(true);
        }
    }
    public String getVidaString(){
        String s = "";
        for(int i = getVida(); i > 0; i--){
            s += "_";
        }
        return s;
    }
    public void setEstado(int estado) {
        this.estado = estado%getStages().length;
    }
    public int getEstado() {
        return estado;
    }
    public void addEstado(int estado) {
        setEstado(getEstado()+estado);
    }
    public Stage getStage() {
        return stages[getEstado()];
    }
    public Stage[] getStages() {
        return stages;
    }
    public Screen getScrn() {
        return scrn;
    }
    public void setYoC(int yoC) {
        this.yoC = yoC%getYos().length;
    }
    public int getYoC() {
        return yoC;
    }
    public void addYoC(int yoC){
        setYoC(getYoC()+yoC);
    }
    public Yo[] getYos(){
        return yo;
    }
    public void setYo(Yo yo){
        this.yo[getYoC()] = yo;
    }
    public Yo getYo() {
        return yo[getYoC()];
    }
    public void setSonido(Sonido sonido) {
        
        this.sonido = sonido;
    }
    public Sonido getSonido() {
        return sonido;
    }
    public void playSonido(int n){
        getSonido().reproducir(n);
    }
    public void setChanged(boolean changed) {
        this.changed = changed;
    }
    public boolean getChanged(){
        return changed;
    }
    public void Change(){
        if(getChanged()){
            setChanged(false);
            getStage().destroyCars();
            addYoC(1);
            addEstado(1);
            setVida(3);
        }
    }
}
