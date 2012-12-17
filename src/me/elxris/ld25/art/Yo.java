package me.elxris.ld25.art;

import me.elxris.ld25.motor.Screen;

public class Yo extends Sprite{
    private int v, vC; 
    private int saltar;
    
    public Yo() {
        super("/res/sprite");
        v = 4;
        saltar = 0;
    }
    
    public void draw(Screen scrn){
        if(isSaltando()){
            saltar();
        }
        if((vC++)%v == 0)
            setEstado((getEstado()+1)%3);
        super.draw(scrn);
    }
    
    public void saltar(){
        if(isSaltando()){
            saltar++;
            if(saltar <= 10){
                moveY(1);
            }else{
                if(saltar > 18){
                    saltar = 0;
                }
                moveY(-1);
            }
        }else{
            saltar++;
        }
    }
    public void initSaltar(){
        saltar++;
    }
    public boolean isSaltando(){
        if(saltar != 0){
            return true;
        }
        return false;
    }
}
