package procesodigital;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import procesodigital.controlador.ControladorContenedorImagen;
import procesodigital.controlador.barraHerramientas.ControladorBarraHerramientas;
import procesodigital.vista.barraHerramientas.BarraHerramientas;
import procesodigital.vista.BarraMenu;
import procesodigital.vista.ContenedorImagen;

public class ProcesoDigital extends Application {

    private GridPane root = new GridPane();
    private ContenedorImagen imgIzq;
    private ContenedorImagen imgDer;
    private BarraMenu menu;
    private BarraHerramientas barraHerramientas;
    private ControladorBarraHerramientas controladorBarraHerramientas;
    private ControladorContenedorImagen cci;
    
    public ProcesoDigital() {
        root = new GridPane();
        imgIzq = new ContenedorImagen();
        imgDer = new ContenedorImagen();
        menu = new BarraMenu(imgIzq, imgDer);
        barraHerramientas = new BarraHerramientas();
        controladorBarraHerramientas = new ControladorBarraHerramientas(barraHerramientas);
        cci = new ControladorContenedorImagen(imgIzq, imgDer);
    }

    @Override
    public void start(Stage primaryStage) {
        //root.setGridLinesVisible(true);
        //root.setStyle("-fx-border-color: blue;");
        root.setHgap(50);
        root.setVgap(50);
        root.add(menu, 0, 0, 25, 1);
        root.add(imgIzq, 1, 1, 11, 9);
        root.add(imgDer, 13, 1, 11, 9);
        root.add(barraHerramientas,1,10,22,1);
        Scene scene = new Scene(root, 1200, 640);
        primaryStage.setTitle("Proceso Digital de Imagenes ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
