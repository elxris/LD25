package me.elxris.ld25.art;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.elxris.ld25.motor.Game;

public class Stage {
    private List<Sprite> bcks = new ArrayList<Sprite>(); //Sprites de fondo
    private List<Car> cars = new ArrayList<Car>();
    private List<Car> tCars = new ArrayList<Car>();
    private int maxCar = 5;
    private int cuentaCar; //Tiempo que tiene para sacar otro auto.
    private String srcCar;
    private Color cback = Color.BLACK; //Color de Fondo
    
    public Stage(String src[]) {
        bcks.add(new Background(src[0], 3, true));//Nuves
        bcks.add(new Background(src[1], 2));//Fondo
        bcks.add(new Background(src[2]));// Suelo
        setSrcCar(src[3]);
    }
    public void pintar(Game g){
        for(Sprite s: bcks){
            s.draw(g.getScrn());
        }
        addCar();
        for(Car s: cars){
            if(g.getYo().isSmashing()){
                if(s.isForSmashing(g.getScrn())){
                    s.smash();
                    if(g.getYoC() == 0){
                        g.playSonido(2);
                    }else{
                        g.playSonido(1);
                    }
                    g.addScore(1);
                }
            }
            s.draw(g.getScrn());
            if(s.isTrash()){
                tCars.add(s);
            }else if(s.isOut()){
                g.addVida(-1);
            }
        }
        if(tCars.size() > 0){
            cleanCars();
        }
    }
    public void addCar(){
        addCuentaCar(-1);
        if(getCuentaCar() <= 0 && Car.getCountCars() < getMaxCar()){ 
            Random rndm = new Random();
            setCuentaCar(10+rndm.nextInt(30));
            cars.add(new Car(getSrcCar(), 2));
        }
    }
    public void cleanCars(){
        for(Car s: tCars){
            cars.remove(s);
        }
        tCars.clear();
    }
    public void destroyCars(){
        /*for(Car s: cars){
            s.smash();
            //s.setInvisible();
            //tCars.add(s);
        }
        //cleanCars();*/
        Car.resetCountCars();
        cars.clear();
    }
    public void setMaxCar(int maxCar) {
        this.maxCar = maxCar;
    }
    public int getMaxCar() {
        return maxCar;
    }
    public void setCuentaCar(int cuentaCar) {
        this.cuentaCar = cuentaCar;
    }
    public int getCuentaCar() {
        return cuentaCar;
    }
    public void addCuentaCar(int cuentaCar){
        setCuentaCar(getCuentaCar()+cuentaCar);
    }
    public void setSrcCar(String srcCar) {
        this.srcCar = srcCar;
    }
    public String getSrcCar() {
        return srcCar;
    }
    public Color getCback() {
        return cback;
    }
    public void setCback(Color cback) {
        this.cback = cback;
    }
}
