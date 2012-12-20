package me.elxris.ld25.motor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JApplet;

public class Principal extends JApplet implements Runnable, KeyListener, MouseMotionListener, MouseListener{
    public final static int TIME = 1000/120;
    private Thread tick = new Thread(this);
    private Boolean playing = false;
    public static final int ANCHO = 400;
    public static final int ALTO = 120;
    private static Panel panel = new Panel();
    private Game game;
    //private static int estado = 0;
    private boolean pulsado;
    private Sonido audio;
    
    @Override
    public void init() {
        super.init();
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setFocusable(true);
        add(panel);
        audio = new Sonido(getAudioClip(getCodeBase(), "res/sounds/Aplasta.wav"), getAudioClip(getCodeBase(), "res/sounds/Conejo.wav"),
                getAudioClip(getCodeBase(), "res/sounds/Explo.wav"), getAudioClip(getCodeBase(), "res/sounds/Heli.wav"),
                getAudioClip(getCodeBase(), "res/sounds/Salta.wav"));
        game = new Game(panel, audio);
        setPlay();
        tick.start();
    }
    @Override
    public void start() {
        this.resize(ANCHO, ALTO);
    }
    @Override
    public void stop() {
        setPausa();
    }
    public void pintar(){
        game.paint();
    }
    @Override
    public void run() {
        try {
            while (playing){
                Thread.sleep(TIME);
                if(!hasFocus()){
                    game.paintScreen(0);
                }else{
                    pintar();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void setPlay(){
        playing = true;
    }
    
    public void setPausa(){
        playing = false;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if(!pulsado){
            game.key(e.getKeyCode());
            pulsado = true;
        }
        if(e.getKeyChar() == 'r'){
            game.reset();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        game.keyR(e.getKeyCode());
        pulsado = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}
