package procesodigital.controlador.barraHerramientas;

import java.io.File;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import procesodigital.controlador.ControladorContenedorImagen;
import procesodigital.vista.barraHerramientas.VisorRuta;

public class ControladorVisorRuta {

    private VisorRuta vr;    
    
    public ControladorVisorRuta(VisorRuta vr) {
        this.vr = vr;
        vr.botonSelecciona.setOnAction(v->{
            accionBotonSelecciona();
        });
        
        vr.botonPredeterminado.setOnAction(v->{
            accionBotonPredeterminado();
        });
        
        vr.guardar.setOnAction(v -> {
            guardaImagen();
        });
    }
    
    private void accionBotonSelecciona(){
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        stage.setTitle("Selecciona una imagen");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Imagen files (*.png, *.jpg)", "*.png", "*.jpg" );
        fileChooser.getExtensionFilters().add(extFilter);
        File archivo =  fileChooser.showOpenDialog(stage);
        actualizaRuta(archivo.getAbsolutePath());
    }
    
    private void accionBotonPredeterminado(){
        ControladorContenedorImagen.setPredeterminado();
        vr.setAreaRuta("Predeterminado");        
    }
    
    private void actualizaRuta(String ruta){
        vr.setAreaRuta(ruta);
        ControladorContenedorImagen.setImagen(ruta);
    }
    
    private void guardaImagen(){
        ControladorContenedorImagen.guardarIMagen();
    }
    
}
