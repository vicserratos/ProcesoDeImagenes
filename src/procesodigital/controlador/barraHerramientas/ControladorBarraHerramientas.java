package procesodigital.controlador.barraHerramientas;

import javafx.scene.layout.HBox;
import procesodigital.vista.barraHerramientas.BarraHerramientas;

public class ControladorBarraHerramientas {

    private static BarraHerramientas barraHerramientas;
    private static ControladorVisorRuta cvr;
    
    
    public ControladorBarraHerramientas(BarraHerramientas barraHerramientas) {
        this.barraHerramientas = barraHerramientas;
        cvr = new ControladorVisorRuta(barraHerramientas.getVisorRuta());        
    }
    
    public static void addHBox(HBox hbox){
        ControladorBarraHerramientas.barraHerramientas.getChildren().add(hbox);
    }
    
    public static void clearChildren(){
        ControladorBarraHerramientas.barraHerramientas.getChildren().remove(1,ControladorBarraHerramientas.barraHerramientas.getChildren().size());
    }
    
}
