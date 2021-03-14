package procesodigital.controlador.filtros;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class FiltroEscalaDeGrises {

    public static BufferedImage getGrisPromedio(File file) {
        try{
            InputStream is = new FileInputStream(file);
            BufferedImage img = ImageIO.read(is);
            int alto = img.getHeight();
            int ancho = img.getWidth();
            for (int j = 0; j < alto; j ++) {
                for (int i = 0; i < ancho; i ++) {
                    int pixel = img.getRGB(i, j);                
                    int a = (pixel >> 24) & 0xff;
                    int r = (pixel >> 16) & 0xff;
                    int g = (pixel >> 8) & 0xff;
                    int b = pixel & 0xff;
     
                    int avg = (r + g + b) / 3;                
                    pixel = (a << 24) | (avg << 16) | (avg << 8) | avg;
                    img.setRGB(i, j, pixel);
                }
            }       
            return img;        
        } catch (IOException ex) {
            System.out.println("Error en escala de grises");
            ex.printStackTrace();
            return null;
        }
    }

    public static BufferedImage getOjoPromedio(File file) {
        try{
            InputStream is = new FileInputStream(file);
            BufferedImage img = ImageIO.read(is);
            int alto = img.getHeight();
            int ancho = img.getWidth();
            for (int j = 0; j < alto; j ++) {
                for (int i = 0; i < ancho; i ++) {
                    Color pixel = new Color(img.getRGB(i, j));              
                    int r = pixel.getRed();
                    int g = pixel.getGreen();
                    int b = pixel.getBlue();
     
                    r = (int) (r * 0.3);
                    g = (int) (g * 0.59);
                    b = (int) (b * 0.11);
                    
                    int gris = r + g + b;
                    Color newPixel = new Color(gris, gris, gris);
                    img.setRGB(i, j, newPixel.getRGB());
                }
            }       
            return img;        
        } catch (IOException ex) {
            System.out.println("Error en escala de grises");
            ex.printStackTrace();
            return null;
        }
    }
    
        public static BufferedImage getLuma(File file) {
        try{
            InputStream is = new FileInputStream(file);
            BufferedImage img = ImageIO.read(is);
            int alto = img.getHeight();
            int ancho = img.getWidth();
            for (int j = 0; j < alto; j ++) {
                for (int i = 0; i < ancho; i ++) {
                    Color pixel = new Color(img.getRGB(i, j));              
                    int r = pixel.getRed();
                    int g = pixel.getGreen();
                    int b = pixel.getBlue();
     
                    r = (int) (r * 0.2126);
                    g = (int) (g * 0.7152);
                    b = (int) (b * 0.0722);
                    
                    int gris = r + g + b;
                    Color newPixel = new Color(gris, gris, gris);
                    img.setRGB(i, j, newPixel.getRGB());
                }
            }       
            return img;        
        } catch (IOException ex) {
            System.out.println("Error en escala de grises");
            ex.printStackTrace();
            return null;
        }
    }
    
    public static BufferedImage getDesaturation(File file) {
        try{
            InputStream is = new FileInputStream(file);
            BufferedImage img = ImageIO.read(is);
            int alto = img.getHeight();
            int ancho = img.getWidth();
            for (int j = 0; j < alto; j ++) {
                for (int i = 0; i < ancho; i ++) {
                    Color pixel = new Color(img.getRGB(i, j));              
                    int r = pixel.getRed();
                    int g = pixel.getGreen();
                    int b = pixel.getBlue();
                    
                    int gris = (int) ((getMax(r, g, b) + getMin(r, g, b)) / 2 );
                    
                    Color newPixel = new Color(gris, gris, gris);
                    img.setRGB(i, j, newPixel.getRGB());
                }
            }       
            return img;        
        } catch (IOException ex) {
            System.out.println("Error en escala de grises");
            ex.printStackTrace();
            return null;
        }
    }
    
    public static BufferedImage getMax(File file) {
        try{
            InputStream is = new FileInputStream(file);
            BufferedImage img = ImageIO.read(is);
            int alto = img.getHeight();
            int ancho = img.getWidth();
            for (int j = 0; j < alto; j ++) {
                for (int i = 0; i < ancho; i ++) {
                    Color pixel = new Color(img.getRGB(i, j));              
                    int r = pixel.getRed();
                    int g = pixel.getGreen();
                    int b = pixel.getBlue();
                    
                    int gris = getMax(r, g, b);
                    
                    Color newPixel = new Color(gris, gris, gris);
                    img.setRGB(i, j, newPixel.getRGB());
                }
            }       
            return img;        
        } catch (IOException ex) {
            System.out.println("Error en escala de grises");
            ex.printStackTrace();
            return null;
        }
    }
    
    public static BufferedImage getMin(File file) {
        try{
            InputStream is = new FileInputStream(file);
            BufferedImage img = ImageIO.read(is);
            int alto = img.getHeight();
            int ancho = img.getWidth();
            for (int j = 0; j < alto; j ++) {
                for (int i = 0; i < ancho; i ++) {
                    Color pixel = new Color(img.getRGB(i, j));              
                    int r = pixel.getRed();
                    int g = pixel.getGreen();
                    int b = pixel.getBlue();
                    
                    int gris = getMin(r, g, b);
                    
                    Color newPixel = new Color(gris, gris, gris);
                    img.setRGB(i, j, newPixel.getRGB());
                }
            }       
            return img;        
        } catch (IOException ex) {
            System.out.println("Error en escala de grises");
            ex.printStackTrace();
            return null;
        }
    }
    
    public static BufferedImage getGrisRed(File file) {
        try{
            InputStream is = new FileInputStream(file);
            BufferedImage img = ImageIO.read(is);
            int alto = img.getHeight();
            int ancho = img.getWidth();
            for (int j = 0; j < alto; j ++) {
                for (int i = 0; i < ancho; i ++) {
                    Color pixel = new Color(img.getRGB(i, j));              
                    int r = pixel.getRed();
                    
                    Color newPixel = new Color(r, r, r);
                    img.setRGB(i, j, newPixel.getRGB());
                }
            }       
            return img;        
        } catch (IOException ex) {
            System.out.println("Error en escala de grises");
            ex.printStackTrace();
            return null;
        }
    }
    
    public static BufferedImage getGrisGreen(File file) {
        try{
            InputStream is = new FileInputStream(file);
            BufferedImage img = ImageIO.read(is);
            int alto = img.getHeight();
            int ancho = img.getWidth();
            for (int j = 0; j < alto; j ++) {
                for (int i = 0; i < ancho; i ++) {
                    Color pixel = new Color(img.getRGB(i, j));              
                    int g = pixel.getGreen();
                    
                    Color newPixel = new Color(g, g, g);
                    img.setRGB(i, j, newPixel.getRGB());
                }
            }       
            return img;        
        } catch (IOException ex) {
            System.out.println("Error en escala de grises");
            ex.printStackTrace();
            return null;
        }
    }
    
    public static BufferedImage getGrisBlue(File file) {
        try{
            InputStream is = new FileInputStream(file);
            BufferedImage img = ImageIO.read(is);
            int alto = img.getHeight();
            int ancho = img.getWidth();
            for (int j = 0; j < alto; j ++) {
                for (int i = 0; i < ancho; i ++) {
                    Color pixel = new Color(img.getRGB(i, j));              
                    int b = pixel.getBlue();
                    
                    Color newPixel = new Color(b, b, b);
                    img.setRGB(i, j, newPixel.getRGB());
                }
            }       
            return img;        
        } catch (IOException ex) {
            System.out.println("Error en escala de grises");
            ex.printStackTrace();
            return null;
        }
    }
        
    private static int getMax(int r, int g, int b){
        return Math.max(r, Math.max(g, b));
    }
    
    private static int getMin(int r, int g, int b){
        return Math.min(r, Math.min(g, b));
    }
}
