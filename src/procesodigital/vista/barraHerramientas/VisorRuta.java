package procesodigital.vista.barraHerramientas;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class VisorRuta extends HBox{

    private Label etiqueta;
    public Button botonSelecciona, botonPredeterminado, guardar;
    private TextField areaRuta;
    
   
    public VisorRuta() {
        super.setBackground(new Background(new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY, Insets.EMPTY)));
        etiqueta = new Label("Ruta Archivo:");
        botonSelecciona = new Button("Buscar Imagen");
        botonPredeterminado = new Button("Predeterminado");
        guardar = new Button("Guardar Imagen");
        areaRuta = new TextField();
        areaRuta.setMinWidth(500);
        areaRuta.setPromptText("Selecciona una Imagen");
        super.setSpacing(20);
        areaRuta.setDisable(true);
        super.getChildren().addAll(etiqueta, areaRuta, botonSelecciona, botonPredeterminado, guardar);   
        
    }
    
    public void setAreaRuta(String ruta){
        areaRuta.setText(ruta);
    }
    
    
}
