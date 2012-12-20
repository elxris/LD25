package me.elxris.ld25.art.yo;

public class Goat extends Yo{

    public Goat(int x, int y) {
        super(x, y, "/res/art/goat.s");
    }

    @Override
    public void atacar() {
        if(isAtacando()){
            addAtacar(1);
            if(getAtacar() <= 10){
                moveY(1);
            }else{
                if(getAtacar() > 18){
                    setAtacar(0);
                    setEstado(0);
                }
                moveY(-1);
            }
        }
    }

    @Override
    public void initAtacar() {
        getSonido().reproducir(4);
        addAtacar(1);
        setEstado(3);
    }

}
