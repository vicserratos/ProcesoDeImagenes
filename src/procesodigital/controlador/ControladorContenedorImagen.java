package procesodigital.controlador;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import procesodigital.controlador.barraHerramientas.ControladorBarraHerramientas;
import procesodigital.vista.ContenedorImagen;

public class ControladorContenedorImagen {

    private static ContenedorImagen imagenIzq, imagenDer;

    public ControladorContenedorImagen(ContenedorImagen imagenIzq, ContenedorImagen imagenDer) {
        ControladorContenedorImagen.imagenIzq = imagenIzq;
        ControladorContenedorImagen.imagenDer = imagenDer;
    }

    public static void setPredeterminado() {
        imagenIzq.setImagen(new File(imagenDer.getRutaPredeterminada()));
        imagenDer.setImagen(new File(imagenDer.getRutaPredeterminada()));
        ControladorBarraHerramientas.clearChildren();
    }

    public static void setImagen(String url) {
        imagenIzq.setImagen(new File(url));
        imagenDer.setImagen(new File(url));
        ControladorBarraHerramientas.clearChildren();
    }
    
    public static void setImagenDerecha(BufferedImage img) {
        imagenDer.setImagen(img);
    }

    public static void guardarIMagen(){
        try {
            BufferedImage buffer = imagenDer.getBufferDerecho();
            if(buffer == null){
                alertaVacio();
            } else {
                ImageIO.write(buffer, "png", getFileSalida());
            }
        } catch (IOException | java.lang.IllegalArgumentException ex) {
            System.out.println("Error de lectura archivo");
        }
    }
    
    private static void alertaVacio(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("No hay cambios");
        alert.setContentText("No se ha modificado la imagen");
        alert.showAndWait();
    }
    
    private static File getFileSalida(){
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Imagen files (*.png, *.jpg)", "*.png", "*.jpg" );
        fileChooser.setTitle("Guardar Archivo");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setInitialFileName(".png");
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            return file;
        }
        return null;
    }
}
