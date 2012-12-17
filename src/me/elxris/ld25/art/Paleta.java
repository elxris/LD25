package me.elxris.ld25.art;

import java.awt.Color;
import java.io.InputStream;
import java.util.Scanner;


public class Paleta {
    private Color[] colores;
    
    public Paleta(int[] rbga){
        init(rbga);
    }//Fin de Paleta
    
    public Paleta(String src){
        InputStream in = getClass().getResourceAsStream(src);
        Scanner entrada = new Scanner(in);
        int i;
        for(i = -1; entrada.hasNext(); i++){
            entrada.next();
        }
        int rbga[] = new int[i];
        in = getClass().getResourceAsStream(src);
        entrada = new Scanner(in);
        entrada.next();
        for(i = 0; entrada.hasNext(); i++){
            rbga[i] = entrada.nextInt();
            if(rbga[i] < 0){
                rbga[i] = 0;
            }else if(rbga[i] > 255){
                rbga[i] = 255;
            }
        }
        init(rbga);
        entrada.close();
    }
    
    private void init(int rbga[]){
        if(rbga.length%4 == 0){
            colores = new Color[rbga.length/4];
            for(int i = 0; i < rbga.length; i+=4){
                colores[i/4] = new Color(rbga[i], rbga[i+1], rbga[i+2], rbga[i+3]);
            }//Fin del for
        }else{
            System.out.println("Error al cargar la paleta, no corresponde el tamaño.");
        }//Fin del if
    }
    
    public Color color(int e){
        if(e-1 < 0){
            return null;
        }else{
            return colores[e-1];
        }
    }
    
    public void setColor(int e, Color c){
        if(e < colores.length){
            colores[e] = c;
        }
    }
    
    public Color color(Color c, int e){
        Color base = color(e);
        int red = colorSum(base.getRed(), c.getRed(), c.getAlpha());
        int green = colorSum(base.getGreen(), c.getGreen(), c.getAlpha());
        int blue = colorSum(base.getBlue(), c.getBlue(), c.getAlpha());
        Color color = new Color(red, green, blue, 0);
        return color;
    }
    
    public static int colorSum(int b, int c, int a){
        final int A = (1/255)*a;
        final int B = (1/255)*(255-a);
        int r = (c*A+b*B)/2;
        return r;
    }
}//Fin de la Clase Paleta
