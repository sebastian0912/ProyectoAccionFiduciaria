package com;

import java.io.FileNotFoundException;

import com.Model.Datos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class layoutController {

    FileChooser fileChooser = new FileChooser();
    ArrayList<Datos> datos = new ArrayList<Datos>();
    

    @FXML
    private Button cargar;

    @FXML
    private Label contador;

    @FXML
    private Label proceso;

    @FXML
    void cargarArchivo(ActionEvent event) throws FileNotFoundException {
        // Escoger el archivo, cargarlo y mostrar su nombre en la consola
        // System.out.println(fileChooser.showOpenDialog(cargar.getScene().getWindow()).getName());
        String path = fileChooser.showOpenDialog(cargar.getScene().getWindow()).getAbsolutePath();

        
        mostrarDatos(path);

    }


    @FXML
    void estadoProceso(MouseEvent event) {

    }

    public void mostrarDatos(String path) {
        // LEER ARCHIVO DE TEXTO y imprimir su contenido en la consola
        File archivo = new File(path);
        int cont = 0;
        // separar por tabulaciones y comas y almacenar en el arraylist datos
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                if (cont > 0) {
                    String[] datosLinea = linea.split("\t");
                    // crear un objeto de tipo Datos y almacenarlo en el arraylist datos con las 26 variables                                        
                    datos.add(new Datos(
                      datosLinea[0]
                    , Double.valueOf(datosLinea[1])
                    , Double.valueOf(datosLinea[2])
                    , Double.valueOf(datosLinea[3])
                    , Double.valueOf(datosLinea[4]) 
                    , Double.valueOf(datosLinea[5])
                    , Double.valueOf(datosLinea[6])
                    , Double.valueOf(datosLinea[7])
                    , datosLinea[8]
                    , datosLinea[9]
                    , datosLinea[10]
                    , datosLinea[11]
                    , datosLinea[12]
                    , datosLinea[13]
                    , datosLinea[14]
                    , datosLinea[15]
                    , Double.valueOf(datosLinea[16])
                    , Integer.valueOf(datosLinea[17])
                    , datosLinea[18]                    
                    , Double.valueOf(datosLinea[19].replace(",", "."))
                    , Double.valueOf(datosLinea[20].replace(",", "."))
                    , Double.valueOf(datosLinea[21].replace(",", "."))
                    , datosLinea[22]
                    , datosLinea[23]
                    , datosLinea[24]
                    , datosLinea[25]
                    ));                    
                       
                   // break;
                }
                cont++;
                //System.out.println(cont);
                contador.setText(String.valueOf(cont));
            }      
            
            
            // Imprimir el ultimo objeto del arraylist
            System.out.println(datos.get(datos.size()-1).getCuenta_11());
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
        }

    }

}
