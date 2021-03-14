package procesodigital.vista;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class ContenedorImagen extends StackPane {

    private File file;
    private final double ancho, alto;
    private final String rutaPredeterminada;
    private int anchoImagen;
    private int altoImagen;
    private BufferedImage bufferDerecho;

    public ContenedorImagen() {
        this.rutaPredeterminada = "img/imagen.jpg";
        this.bufferDerecho = null;
        this.ancho = 500;
        this.alto = 400;
        super.setWidth(500);
        super.setHeight(400);
        super.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY, Insets.EMPTY)));
        this.file = new File(rutaPredeterminada);
        setImagen(this.file);
    }
    
    public File getFile(){
        return this.file;
    }
    
    public String getRutaPredeterminada(){
        return this.rutaPredeterminada;
    }
    
    public void setImagen(File archivoImagen){
        this.file = archivoImagen;
        InputStream isImagen = null;
        ImageView imagenVista;
        Image imagen;        
        try {
            isImagen = new FileInputStream(archivoImagen);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        imagen = new Image(isImagen);
        imagenVista = new ImageView(imagen);
        imagenVista.setFitHeight(alto);
        imagenVista.setFitWidth(ancho);
        imagenVista.setPreserveRatio(true);
        super.getChildren().clear();
        super.getChildren().add(imagenVista);
        this.bufferDerecho = null;
        //altoImagen = (int)Math.round(imagen.getHeight());
        //anchoImagen = (int)Math.round(imagen.getWidth());
    }
    
    public void setImagen(BufferedImage bufferImagen){
        this.bufferDerecho = bufferImagen;
        ImageView imagenVista;
        Image imagen;
        
        imagen = SwingFXUtils.toFXImage(bufferDerecho, null);
        imagenVista = new ImageView(imagen);
        imagenVista.setFitHeight(alto);
        imagenVista.setFitWidth(ancho);
        imagenVista.setPreserveRatio(true);
        super.getChildren().clear();
        super.getChildren().add(imagenVista);
    }
    
    public int getAnchoImagen(){
        return this.anchoImagen;        
    }
    
    public int getAltoImagen(){
        return this.altoImagen;        
    }

    public BufferedImage getBufferDerecho(){
        return this.bufferDerecho;
    }
    
}
