package me.elxris.ld25;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel {
    private Game game = new Game();
    public Panel() {
        this.setDoubleBuffered(true);
        this.setBackground(Color.BLACK);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.paint();
    }
    
    public void key(int c){
        game.key(c);
    }
    
    public void keyR(int c){
        game.key(c);
    }
}
