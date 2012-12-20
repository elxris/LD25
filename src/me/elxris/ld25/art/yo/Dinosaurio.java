package me.elxris.ld25.art.yo;

public class Dinosaurio extends Yo{
    

    public Dinosaurio(int x, int y) {
        super(x, y, "/res/art/dino.s");
    }
    
    @Override
    public void atacar() {
        if(isAtacando()){ //Si está atacando.
            addAtacar(1); //Añade estado de ataque.
            if(getAtacar() <= 10){
                moveY(1); //Salta
            }else{
                if(getAtacar() > 18){ //Deja de atacar
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
