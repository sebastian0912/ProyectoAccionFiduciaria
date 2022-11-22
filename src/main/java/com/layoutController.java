package com;

import java.io.FileNotFoundException;

import com.Model.Datos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class layoutController {

    FileChooser fileChooser = new FileChooser();
    ArrayList<Datos> datos = new ArrayList<Datos>();
    Datos dato = new Datos();

    @FXML
    private Button cargar;

    @FXML
    private Label contador;

    @FXML
    private Label proceso;

    @FXML
    void cargarArchivo(ActionEvent event) throws FileNotFoundException {
        // Escoger el archivo, cargarlo y mostrar su nombre en la consola
        String path = fileChooser.showOpenDialog(cargar.getScene().getWindow()).getAbsolutePath();
        String pathWithNameArchive;
        //quitar el nombre del archivo
        pathWithNameArchive = path.substring(0, path.lastIndexOf("\\"));       
        //Guarda los datos en un ArrayList
        SaveData(path);
        proceso.setText("Archivo Cargado");
        SeparateByQuater(datos, pathWithNameArchive);
    }

    public void SaveData(String path) {        
        // LEER ARCHIVO DE TEXTO y imprimir su contenido en la consola
        File archivo = new File(path);
        double cont = 0;      
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
                }                
                cont++;  
                contador.setText(String.valueOf(cont));
            }   
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
        }

    }

    public void SeparateByQuater( ArrayList<Datos> listaDeDatos, String path){
        ArrayList<ArrayList<Datos>> datos = new ArrayList<ArrayList<Datos>>();
        ArrayList<Datos> datos1 = new ArrayList<Datos>();
        ArrayList<Datos> datos2 = new ArrayList<Datos>();
        ArrayList<Datos> datos3 = new ArrayList<Datos>();
        ArrayList<Datos> datos4 = new ArrayList<Datos>();
        for (Datos dat: listaDeDatos){
            if (QuaterIndicator(dat.getFecha()) == 1){
                datos1.add(dat);
            }
            else if (QuaterIndicator(dat.getFecha()) == 2){
                datos2.add(dat);
            }
            else if (QuaterIndicator(dat.getFecha()) == 3){
                datos3.add(dat);
            }
            else if (QuaterIndicator(dat.getFecha()) == 4){
                datos4.add(dat);
            }            
        }
        datos.add(datos1);
        datos.add(datos2);
        datos.add(datos3);
        datos.add(datos4);

        GenerateFilesByQuarters(datos, path);
    }

    public void GenerateFilesByQuarters(ArrayList<ArrayList<Datos>> datos, String path){
        // Generar 4 archivos de texto con los datos de cada trimestre
        for (int i = 0; i < datos.size(); i++) {
            try {
                FileWriter fw = new FileWriter(path + "/Trimestre" + (i+1) + ".txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                for (int j = 0; j < datos.get(i).size(); j++) {
                    bw.write(datos.get(i).get(j).getFecha() + "\t");
                    bw.newLine();  
                }
                fw.close();
            } catch (Exception e) {
                System.out.println("Error al escribir el archivo");
            }
        }
    }    

    public int QuaterIndicator(String fecha){
        int quater = 0;
        String[] fechaSeparada = fecha.split("/");
        int mes = Integer.parseInt(fechaSeparada[1]);
        if (mes >= 1 && mes <= 3){
            quater = 1;
        }else if (mes >= 4 && mes <= 6){
            quater = 2;
        }else if (mes >= 7 && mes <= 9){
            quater = 3;
        }else if (mes >= 10 && mes <= 12){
            quater = 4;
        }
        return quater;
    }

}
