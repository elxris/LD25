package me.elxris.ld25.motor;

import java.awt.Color;

import me.elxris.ld25.art.Alfabet;
import me.elxris.ld25.art.Stage;
import me.elxris.ld25.art.yo.Dinosaurio;
import me.elxris.ld25.art.yo.Goat;
import me.elxris.ld25.art.yo.YoRobot;
import me.elxris.ld25.art.yo.Yo;

public class Game {
    private Yo yo[] = new Yo[3];
    private int yoC = 0;
    private Alfabet alfa;
    private Panel panel;
    private Screen scrn;
    private int score = 0;
    private int estado = 0;
    private int vida = 3;
    private Stage[] stages = new Stage[3];
    private Sonido sonido;
    private boolean changed;
       
    public Game(Panel pan, Sonido sonido){
        panel = pan;
        setSonido(sonido);
        
        String s[] = {"/res/art/nuves.s", "/res/art/edificios.s", "/res/art/calle.s", "/res/art/carro.s"};
        stages[0] = new Stage(s);
        int[] coloresRandom = {3, 4, 5, 6, 7};
        stages[0].setRandom(coloresRandom);
        String s2[] = {"/res/art/nuves.s", "/res/art/bosque.s", "/res/art/grass.s", "/res/art/conejo.s"};
        stages[1] = new Stage(s2);
        stages[1].setCback(new Color(206, 236, 239));//Azul
        int[] coloresRandom2 = {1, 5, 6};
        stages[1].setRandom(coloresRandom2);
        String s3[] = {"/res/art/nuves.s", "/res/art/volcano.s", "/res/art/grassgoat.s", "/res/art/smallgoat.s"};
        stages[2] = new Stage(s3);
        stages[2].setCback(new Color(206, 236, 239));
        int[] coloresRandom3 = {2, 6, 7};
        stages[2].setRandom(coloresRandom3);
        
        scrn = new Screen(getAncho(), getAlto());
        alfa = new Alfabet();
        // Añade el dinosaurio.
        Dinosaurio dino = new Dinosaurio(getScrn().getAncho(), 2);
        dino.setSonido(getSonido());
        setNewYo(dino);
        // Añade el robot.
        YoRobot robot = new YoRobot(getScrn().getAncho(), 2);
        robot.setSonido(getSonido());
        setNewYo(robot);
        // Añade la cabra.
        Goat goat = new Goat(getScrn().getAncho(), 2);
        goat.setSonido(getSonido());
        setNewYo(goat);
    }
    public void paint(){
        scrn.prePaint(getStage().getCback()); //Pinta con el color de fondo del stage.
        getStage().pintar(this);
        getYo().draw(scrn);
        alfa.draw("Score:"+score, 1, scrn.getAlto()-alfa.getAlto(), scrn, 1);
        alfa.draw(getVidaString(), scrn.getAncho()-20, scrn.getAlto()-alfa.getAlto(), scrn, 2);
        scrn.paint(panel.getGraphics());
        cambioStage();
        return;
    }
    public void paintScreen(int n){ //Cuando no está en focus.
        scrn.prePaint(Color.BLACK); //Pinta con el color de fondo del stage.
        if(n == 0){
            int i = 0;
            alfa.draw("R: reset", 2, 2+6*i++, scrn, 3);
            alfa.draw("Spacebar: smash", 2, 2+6*i++, scrn, 3);
            alfa.draw("PAUSED", 2, 2+6*i++, scrn, 3);
        }
        scrn.paint(panel.getGraphics());
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
    public void setNewYo(Yo yo){
        setYo(yo);
        addYoC(1);
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
    public void cambioStage(){
        if(getChanged()){
            setChanged(false);
            getStage().destroyCars();
            addYoC(1);
            addEstado(1);
            setVida(3);
        }
    }
    public void reset(){
        getStage().destroyCars();
        setYoC(0);
        setEstado(0);
        setVida(3);
        setScore(0);
    }
}
