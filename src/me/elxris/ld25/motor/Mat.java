package me.elxris.ld25.motor;

public class Mat {
    private final int NUM = 360;
    private final int MULTIPLE = 2;
    private final int NUMERO = NUM * MULTIPLE;
    private double[] sen, cos;
    
    public Mat(){
        sen = new double[NUMERO];
        cos = new double[NUMERO];
        fill();
    }
    
    public void fill(){
        for(int i = 0; i < NUMERO; i++){
            sen[i] = Math.sin(Math.toRadians(i/MULTIPLE));
            cos[i] = Math.cos(Math.toRadians(i/MULTIPLE));
        }
    }
    
    public double getSen(int e){
        return sen[(e*MULTIPLE)%NUMERO];
    }
    
    public double getSen(double e){
        return getSen((int)e);
    }
    
    public double getCos(int e){
        return cos[(e*MULTIPLE)%NUMERO];
    }
    
    public double getCos(double e){
        return getCos((int)e);
    }
}
