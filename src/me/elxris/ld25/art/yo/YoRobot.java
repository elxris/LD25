package me.elxris.ld25.art.yo;

public class YoRobot extends Yo{
    
    public YoRobot(int x, int y) {
        super(x-3, y, "/res/robot");
    }

    @Override
    public void atacar() {
        if(isAtacando()){
            addAtacar(1);
            if(getAtacar() <= 10){
                //moveY(1);
            }else{
                if(getAtacar() > 18){
                    setAtacar(0);
                    setEstado(0);
                }
                //moveY(-1);
            }
        }else{
            addAtacar(1);
        }
    }

    @Override
    public void initAtacar() {
        getSonido().reproducir(0);
        addAtacar(1);
        setEstado(3);
    }
}
