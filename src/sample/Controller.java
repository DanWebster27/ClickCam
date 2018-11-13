package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static com.jogamp.opengl.GLProfile.GL2;

public class Controller {

    @FXML
    Slider sliderG;
    @FXML
    Button ausf;
    @FXML
    Button zur;
    @FXML
    CheckBox cRecht;

    //Hier sind Instanzvariablen 
    private static double größe = 0;
    private static int auswahl = 0;

    public static int getAuswahl() {
        return auswahl;
    }

    public static void setAuswahl(int auswahl) {
        Controller.auswahl = auswahl;
    }

    public static double getGröße() {
        return größe;
    }

    public static void setGröße(double größe) {
        Controller.größe = größe;
    }



    public void ausführen(javafx.event.ActionEvent event) throws IOException {
        new ShapesMainWindow();
    }

    public void zurück(javafx.event.ActionEvent event) throws IOException {


    }

    public void initialize() {

        cRecht.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    Controller.setAuswahl(1);
                } else {
                    Controller.setAuswahl(0);
                }
            }
        });



        sliderG.setMin(0.0);
        sliderG.setMax(1.0);
        sliderG.setValue(0.5);
        sliderG.setShowTickMarks(true);
        sliderG.setShowTickLabels(true);
        sliderG.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                Controller.setGröße(newValue.doubleValue());
            }
        });



    }




}

