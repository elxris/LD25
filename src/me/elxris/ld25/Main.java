package me.elxris.ld25;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JApplet;

public class Main extends JApplet implements Runnable, KeyListener, MouseMotionListener, MouseListener{
    public final static int TIME = 1000/30;
    private Thread tick = new Thread(this);
    private Boolean playing = false;
    public static final int ANCHO = 400;
    public static final int ALTO = 120;
    private static Panel panel = new Panel();
    private Game game;
    
    public Main(){
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        add(panel);
        game = new Game(panel);
    }
    
    public void pintar(){
        game.pintar();
    }

    @Override
    public void start() {
        this.resize(ANCHO, ALTO);
        play();
        tick.start();
    }
    
    @Override
    public void run() {
        try {
            while (playing){
                Thread.sleep(TIME);
                pintar();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void play(){
        playing = true;
    }
    
    public void stop(){
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
        panel.key(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        panel.keyR(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
}
