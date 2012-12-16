package me.elxris.ld25;

import me.elxris.art.Pix;

public class Screen {
    private Pix[][] pixels;
    private int ancho, alto;
    
    public Screen(int an, int al) {
        // TODO Auto-generated constructor stub
        pixels = new Pix[getAncho()][getAlto()];
        for(int x = 0; x < getAncho(); x++){
            for(int y = 0; y < getAlto(); y++){
                pixels[x][y] = new Pix(X(x*5), Y(y*5));
                pixels[x][y].draw();
            }
        }
    }
    public int getAncho(){
        return ancho;
    }
    public int getAlto(){
        
    }
}
