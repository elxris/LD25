package me.elxris.ld25;

import java.awt.Color;
import javax.swing.JPanel;

public class Panel extends JPanel {
    public Panel(int w, int h) {
        this.setDoubleBuffered(true);
        this.setBackground(Color.BLACK);
        this.setSize(w, h);
    }
}
