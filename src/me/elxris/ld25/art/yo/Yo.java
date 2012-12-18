package me.elxris.ld25.art.yo;

import me.elxris.ld25.art.Sprite;
import me.elxris.ld25.motor.Screen;
import me.elxris.ld25.motor.Sonido;

public abstract class Yo extends Sprite{
    private int v, vC; 
    private int atacar;
    private Sonido sonido;
    
    public Yo(int x, int y, String src) {
        super(src);
        v = 4;
        atacar = 0;
        setX(x-getAncho());
        setY(y);
    }
    
    public void draw(Screen scrn){
        if(isAtacando()){
            atacar();
        }
        if((vC++)%v == 0 && !isAtacando()) //Si no está atacando cambia de estado.
            setEstado((getEstado()+1)%3);
        super.draw(scrn);
    }
    
    public abstract void atacar(); //El ataque dura 18 ticks
    public abstract void initAtacar();
    
    public void setAtacar(int saltar) {
        this.atacar = saltar;
    }
    public int getAtacar() {
        return atacar;
    }
    public void addAtacar(int saltar){
        setAtacar(getAtacar()+saltar);
    }
    
    public boolean isAtacando(){
        if(getAtacar() != 0){
            return true;
        }
        return false;
    }
    public boolean isSmashing(){
        if(getAtacar() == 17){
            return true;
        }
        return false;
    }
    
    public void setSonido(Sonido sonido) {
        this.sonido = sonido;
    }
    public Sonido getSonido() {
        return sonido;
    }
}
