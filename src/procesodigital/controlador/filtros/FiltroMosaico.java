package procesodigital.controlador.filtros;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author serrato
 */
public class FiltroMosaico {
    
    public static BufferedImage getMosaico(File file, int pixelesX, int pixelesY) {
        try{
            InputStream is = new FileInputStream(file);
            BufferedImage img = ImageIO.read(is);
            int alto = img.getHeight();
            int ancho = img.getWidth();
            int numMosaicosAlto = Math.round(alto / pixelesY);
            int numMosaicosAncho = Math.round(ancho / pixelesX);
            BufferedImage im = new BufferedImage(pixelesX * numMosaicosAncho, pixelesY * numMosaicosAlto, img.getType());
        
            for(int j = 1; j <= numMosaicosAlto; j ++){
                for(int i = 1; i <= numMosaicosAncho; i ++){
                    long acumuladoR = 0;
                    long acumuladoG = 0;
                    long acumuladoB = 0;
                    int inicioPixelY = (j != 1) ? pixelesY * (j-1) : 0;
                    int finPixelY = pixelesY * j;
                    int inicioPixelX = (i != 1) ? pixelesX * (i-1) : 0;
                    int finPixelX = pixelesX * i;
                    
                    for(int py = inicioPixelY ; py < finPixelY; py++){
                        //System.out.println("py = " + py);
                        for(int px = inicioPixelX; px < finPixelX; px++){
                            //System.out.println("px = " + px);   
                            Color pixel = new Color(img.getRGB(px, py));
                            acumuladoR += pixel.getRed();
                            acumuladoG += pixel.getGreen();
                            acumuladoB += pixel.getBlue();                            
                        }
                    }
                    //System.out.println("Fin Pixel: " + i + "," + j);
                    int newR = Math.round(acumuladoR / (pixelesX * pixelesY));
                    int newG = Math.round(acumuladoG / (pixelesX * pixelesY));
                    int newB = Math.round(acumuladoB / (pixelesX * pixelesY));
                    Color pixelPromedio = new Color(newR, newG, newB);

                    for(int py = inicioPixelY; py < finPixelY; py++){
                        for(int px = inicioPixelX; px < finPixelX; px++){
                            //System.out.println("Guardando pixel: " + px + "," + py + " : " + pixelPromedio.getRed() + "," + pixelPromedio.getGreen()+ "," + pixelPromedio.getBlue());
                            im.setRGB(px, py, pixelPromedio.getRGB());
                        }
                    }
                }
            }
            return im;      
        } catch (IOException ex) {
            System.out.println("Error en escala de grises");
            ex.printStackTrace();
            return null;
        }
    }
}
