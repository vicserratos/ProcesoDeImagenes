package procesodigital.vista.barraHerramientas;

import javafx.scene.layout.VBox;

public class BarraHerramientas extends VBox{

    private VisorRuta vr;
    
    public BarraHerramientas() {
        vr = new VisorRuta();       
        super.setSpacing(15);
        super.getChildren().add(vr);
    }

    public VisorRuta getVisorRuta(){
        return vr;
    }
    
}
