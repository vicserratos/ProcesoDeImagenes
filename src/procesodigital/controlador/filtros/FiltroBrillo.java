package procesodigital.controlador.filtros;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author serrato
 */
public class FiltroBrillo {
    
    private BufferedImage imagen;
    private int alto;
    private int ancho;
    
    public FiltroBrillo(File file) throws FileNotFoundException, IOException{
            InputStream streamImagen = new FileInputStream(file);     
            this.imagen = ImageIO.read(streamImagen);
            this.alto = imagen.getHeight();
            this.ancho = imagen.getWidth();
    }
    
    public BufferedImage getBrillo(int constante) {
            BufferedImage img = new BufferedImage(ancho, alto, imagen.getType());
            for (int j = 0; j < alto; j ++) {
                for (int i = 0; i < ancho; i ++) {
                    Color pixel = new Color(imagen.getRGB(i, j));
                    int r = pixel.getRed() + constante;
                    int g = pixel.getGreen() + constante;
                    int b = pixel.getBlue() + constante;
                    
                    r = (r < 0) ? 0 : r;
                    r = (r > 255) ? 255 : r;
                    g = (g < 0) ? 0 : g;
                    g = (g > 255) ? 255 : g;
                    b = (b < 0) ? 0 : b;
                    b = (b > 255) ? 255 : b;
                    
                    Color newPixel = new Color(r, g, b);
                    img.setRGB(i, j, newPixel.getRGB());
                }
            }
            return img;
    }
}
