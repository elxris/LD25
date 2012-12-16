package me.elxris.art;

public class Image {
    private int alto, ancho;
    private int x, y;
    private int[][] imagen;
    
    public Image(int alto, int ancho, int x, int y, int imagen[][]){
        setAlto(alto);
        setAncho(ancho);
        setX(x);
        setY(y);
        setImagen(imagen);
    }
    
    public int getPixel(int x, int y){
        return imagen[y][x];
    }
    
    public void setPixel(int x, int y, int v){
        imagen[y][x] = v;
    }
    
    protected void setImagen(int[][] imagen){
        this.imagen = imagen;
    }
    protected int[][] setImagen(){
        return imagen;
    }
    private void setAlto(int alto){
        this.alto = alto;
    }
    public int getAlto(){
        return alto;
    }
    private void setAncho(int ancho){
        this.ancho = ancho;
    }
    public int getAncho(){
        return ancho;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return x;
    }
    public void addX(int n){
        setX(getX()+n);
    }
    public void setY(int y){
        this.y = y;
    }
    public int getY(){
        return y;
    }
    public void addY(int n){
        setY(getY()+n);
    }
}
