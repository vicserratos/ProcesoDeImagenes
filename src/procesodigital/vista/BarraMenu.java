package procesodigital.vista;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import procesodigital.controlador.ControladorContenedorImagen;
import procesodigital.controlador.barraHerramientas.ControladorBarraHerramientas;
import procesodigital.controlador.filtros.FiltroBrillo;
import procesodigital.controlador.filtros.FiltroEscalaDeGrises;
import procesodigital.controlador.filtros.FiltroMosaico;

public class BarraMenu extends MenuBar {

    private final Menu archivo, filtros, acerca;
    private final MenuItem grisPromedio, ojoPromedio, luma, desaturation, max, min, 
            grisRed, grisGreen, grisBlue, brillo, mosaico;
    private Slider sliderBrillo = new Slider(-127, 127, 0), sliderX = new Slider(1, 500, 25), sliderY = new Slider(1, 500, 25); 
 
    private Label labelValorBrillo, labelValorX, labelValorY;
    private FiltroBrillo fb;

    public BarraMenu(ContenedorImagen imgIzq, ContenedorImagen imgDer) {
        archivo = new Menu("Archivo");
        filtros = new Menu("Filtros - T1");
        acerca = new Menu("Acerca de");
        super.getMenus().addAll(filtros);
        grisPromedio = new MenuItem("1. Escala de Grises - Gris Promedio");
        ojoPromedio = new MenuItem("2. Escala de Grises - Ojo Promedio");
        luma = new MenuItem("3. Escala de Grises - Luma");
        desaturation = new MenuItem("4. Escala de Grises - Desaturation");
        max = new MenuItem("5. Escala de Grises - Max");
        min = new MenuItem("6. Escala de Grises - Min");
        grisRed = new MenuItem("7. Escala de Grises - Red");
        grisGreen = new MenuItem("8. Escala de Grises - Green");
        grisBlue = new MenuItem("9. Escala de Grises - Blue");
        brillo = new MenuItem("10. Brillo");
        mosaico = new MenuItem("11. Mosaico");
        
        filtros.getItems().addAll(grisPromedio, ojoPromedio, luma, desaturation, max, min,
                grisRed, grisGreen, grisBlue, brillo, mosaico);

        grisPromedio.setOnAction(v -> {
            BufferedImage img = FiltroEscalaDeGrises.getGrisPromedio(imgDer.getFile());
            ControladorContenedorImagen.setImagenDerecha(img);
        });

        ojoPromedio.setOnAction(v -> {
            BufferedImage img = FiltroEscalaDeGrises.getOjoPromedio(imgDer.getFile());
            ControladorContenedorImagen.setImagenDerecha(img);
        });

        luma.setOnAction(v -> {
            BufferedImage img = FiltroEscalaDeGrises.getLuma(imgDer.getFile());
            ControladorContenedorImagen.setImagenDerecha(img);
        });

        desaturation.setOnAction(v -> {
            BufferedImage img = FiltroEscalaDeGrises.getDesaturation(imgDer.getFile());
            ControladorContenedorImagen.setImagenDerecha(img);
        });
        
        max.setOnAction(v -> {
            BufferedImage img = FiltroEscalaDeGrises.getMax(imgDer.getFile());
            ControladorContenedorImagen.setImagenDerecha(img);
        });

        min.setOnAction(v -> {
            BufferedImage img = FiltroEscalaDeGrises.getMin(imgDer.getFile());
            ControladorContenedorImagen.setImagenDerecha(img);
        });

        grisRed.setOnAction(v -> {
            BufferedImage img = FiltroEscalaDeGrises.getGrisRed(imgDer.getFile());
            ControladorContenedorImagen.setImagenDerecha(img);
        });
        
        grisGreen.setOnAction(v -> {
            BufferedImage img = FiltroEscalaDeGrises.getGrisGreen(imgDer.getFile());
            ControladorContenedorImagen.setImagenDerecha(img);
        });
        
        grisBlue.setOnAction(v -> {
            BufferedImage img = FiltroEscalaDeGrises.getGrisBlue(imgDer.getFile());
            ControladorContenedorImagen.setImagenDerecha(img);
        });
        
        brillo.setOnAction(v -> {
            ControladorBarraHerramientas.clearChildren();
            HBox hbox = new HBox(5);
            Label etiqueta = new Label("Nivel de Brillo: ");
            labelValorBrillo = new Label(String.valueOf ((int) Math.round(sliderBrillo.getValue()) ));
            hbox.getChildren().addAll(etiqueta, sliderBrillo, labelValorBrillo);
            ControladorBarraHerramientas.addHBox(hbox);

            try {
                fb = new FiltroBrillo(imgDer.getFile());
            } catch (IOException ex) {
                Logger.getLogger(BarraMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        sliderBrillo.valueProperty().addListener((ObservableValue<? extends Number> ov, Number valorAntiguo, Number valorNuevo) -> {
            BufferedImage img = fb.getBrillo(valorNuevo.intValue());
            ControladorContenedorImagen.setImagenDerecha(img);
            labelValorBrillo.setText(String.valueOf(valorNuevo.intValue()));
        });
        
        mosaico.setOnAction(v -> {
            ControladorBarraHerramientas.clearChildren();
            HBox hboxX = new HBox(5);
            HBox hboxY = new HBox(5);
            Label etiquetaX = new Label("Tamaño en coordenada X: ");
            Label etiquetaY = new Label("Tamaño en coordenada Y: ");
            labelValorX = new Label(String.valueOf (Math.round(sliderX.getValue()) ));
            labelValorY = new Label(String.valueOf (Math.round(sliderY.getValue()) ));
            hboxX.getChildren().addAll(etiquetaX, sliderX, labelValorX);
            hboxY.getChildren().addAll(etiquetaY, sliderY, labelValorY);
            ControladorBarraHerramientas.addHBox(hboxX);
            ControladorBarraHerramientas.addHBox(hboxY);
        });
        
        sliderX.valueProperty().addListener((ObservableValue<? extends Number> ov, Number valorAntiguo, Number valorNuevo) -> {
            BufferedImage img = FiltroMosaico.getMosaico(imgDer.getFile(), (int) Math.round(sliderX.getValue()), (int) Math.round(sliderY.getValue()));
            ControladorContenedorImagen.setImagenDerecha(img);
            labelValorX.setText(String.valueOf(valorNuevo.intValue()));
        });
        
        sliderY.valueProperty().addListener((ObservableValue<? extends Number> ov, Number valorAntiguo, Number valorNuevo) -> {
            BufferedImage img = FiltroMosaico.getMosaico(imgDer.getFile(), (int) Math.round(sliderX.getValue()), (int) Math.round(sliderY.getValue()));
            ControladorContenedorImagen.setImagenDerecha(img);
            labelValorY.setText(String.valueOf(valorNuevo.intValue()));
        });
    }

}
