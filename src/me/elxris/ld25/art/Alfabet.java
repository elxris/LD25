package me.elxris.ld25.art;

import java.awt.Color;

import me.elxris.ld25.motor.Screen;

public class Alfabet extends Sprite{

    public Alfabet() {
        super("/res/alfabet");
    }
    
    public void draw(String str, int x, int y, Screen scrn, Color color){
        str = str.toUpperCase();
        int pos[] = {x, y};
        char letters[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N'
                ,'O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9',' ',':','_'};
        for(int i = 0; i < str.length(); i++){
            for(int e = 0; e < letters.length; e++){
                if(str.charAt(i) == letters[e]){
                    drawLetter(e, pos, scrn, color);
                    break;
                }
            }
        }
    }
    public void draw(String str, int x, int y, Screen scrn){
        draw(str, x, y, scrn, getColor(1));
    }
    public void draw(String str, int x, int y, Screen scrn, int color){
        draw(str, x, y, scrn, getColor(color));
    }
    public void drawLetter(int lett, int[] pos, Screen scrn, Color color){
        setEstado(lett);
        //System.out.println(lett);
        setX(pos[0]);
        setY(pos[1]);
        //setColor(1, color);
        draw(scrn, color);
        pos[0] += getAncho()+1;
    }
}
