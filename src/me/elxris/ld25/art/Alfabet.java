package me.elxris.ld25.art;

import java.awt.Color;

import me.elxris.ld25.motor.Screen;

public class Alfabet extends Sprite{

    public Alfabet() {
        super("/res/alfabet");
    }
    
    public void draw(String str, int x, int y, Screen scrn){
        str = str.toUpperCase();
        int letter;
        int pos[] = {x, y};
        for(int i = 0; i < str.length(); i++){
            //System.out.print(str.charAt(i));
            letter = 0;
            if(str.charAt(i)=='A')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='B')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='C')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='D')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='E')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='F')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='G')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='H')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='I')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='J')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='K')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='L')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='M')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='N')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='O')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='P')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='Q')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='R')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='S')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='T')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='U')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='V')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='W')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='X')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='Y')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='Z')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='0')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='1')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='2')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='3')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='4')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='5')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='6')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='7')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='8')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)=='9')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)==' ')
                drawLetter(letter, pos, scrn);
            letter++;
            if(str.charAt(i)==':')
                drawLetter(letter, pos, scrn);
        }
        //System.out.println();
    }
    public void drawLetter(int lett, int[] pos, Screen scrn){
        setEstado(lett);
        //System.out.println(lett);
        setX(pos[0]);
        setY(pos[1]);
        setColor(0, new Color(251, 184, 41));
        draw(scrn);
        pos[0] += getAncho()+1;
    }

}
