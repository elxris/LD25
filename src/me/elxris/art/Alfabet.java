package me.elxris.art;

import me.elxris.ld25.Game;

public class Alfabet extends Sprite{

    public Alfabet(Game g) {
        super(g, "res/alfabet");
    }
    
    public void draw(String str, int x, int y){
        str = str.toUpperCase();
        int letter;
        int pos[] = {x, y};
        for(int i = 0; i < str.length(); i++){
            //System.out.print(str.charAt(i));
            letter = 0;
            if(str.charAt(i)=='A')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='B')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='C')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='D')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='E')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='F')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='G')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='H')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='I')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='J')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='K')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='L')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='M')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='N')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='O')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='P')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='Q')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='R')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='S')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='T')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='U')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='V')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='W')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='X')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='Y')
                drawLetter(letter, pos);
            letter++;
            if(str.charAt(i)=='Z')
                drawLetter(letter, pos);
        }
        //System.out.println();
    }
    public void drawLetter(int lett, int[] pos){
        setEstado(lett);
        //System.out.println(lett);
        setX(pos[0]);
        setY(pos[1]);
        draw();
        pos[0] += getAncho()+1;
    }

}
