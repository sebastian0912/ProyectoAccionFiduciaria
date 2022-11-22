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
        // quitar el nombre del archivo
        pathWithNameArchive = path.substring(0, path.lastIndexOf("\\"));
        // Guarda los datos en un ArrayList
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
                    // crear un objeto de tipo Datos y almacenarlo en el arraylist datos con las 26
                    // variables
                    datos.add(new Datos(
                            datosLinea[0], Long.valueOf(datosLinea[1]), Long.valueOf(datosLinea[2]),
                            Long.valueOf(datosLinea[3]), Long.valueOf(datosLinea[4]), Long.valueOf(datosLinea[5]),
                            Long.valueOf(datosLinea[6]), Long.valueOf(datosLinea[7]), datosLinea[8], datosLinea[9],
                            datosLinea[10], datosLinea[11], datosLinea[12], datosLinea[13], datosLinea[14],
                            datosLinea[15], Long.valueOf(datosLinea[16]), Integer.valueOf(datosLinea[17]),
                            datosLinea[18], Double.valueOf(datosLinea[19].replace(",", ".")),
                            Double.valueOf(datosLinea[20].replace(",", ".")),
                            Long.valueOf(datosLinea[21].replace(",", ".")), datosLinea[22], datosLinea[23],
                            datosLinea[24], datosLinea[25]));
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

    public void SeparateByQuater(ArrayList<Datos> listaDeDatos, String path) {
        ArrayList<ArrayList<Datos>> datos = new ArrayList<ArrayList<Datos>>();
        ArrayList<Datos> datos1 = new ArrayList<Datos>();
        ArrayList<Datos> datos2 = new ArrayList<Datos>();
        ArrayList<Datos> datos3 = new ArrayList<Datos>();
        ArrayList<Datos> datos4 = new ArrayList<Datos>();
        for (Datos dat : listaDeDatos) {
            if (QuaterIndicator(dat.getFecha()) == 1) {
                datos1.add(dat);
            } else if (QuaterIndicator(dat.getFecha()) == 2) {
                datos2.add(dat);
            } else if (QuaterIndicator(dat.getFecha()) == 3) {
                datos3.add(dat);
            } else if (QuaterIndicator(dat.getFecha()) == 4) {
                datos4.add(dat);
            }
        }
        datos.add(datos1);
        datos.add(datos2);
        datos.add(datos3);
        datos.add(datos4);

        GenerateFilesByQuarters(datos, path);
    }

    public void GenerateFilesByQuarters(ArrayList<ArrayList<Datos>> datos, String path) {
        // Generar 4 archivos de texto con los datos de cada trimestre
        System.out.println(datos.get(0).size());
        System.out.println(datos.get(1).size());
        System.out.println(datos.get(2).size());
        System.out.println(datos.get(3).size());

        for (int i = 0; i < datos.size(); i++) {
            try {
                FileWriter fw = new FileWriter(path + "/Trimestre" + (i + 1) + ".txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                for (Datos dat : datos.get(i)) {
                    bw.write(dat.getFecha() + "\t" + dat.getCuenta_Contable() + "\t"
                            + dat.getCod_1() + "\t" + dat.getCod_2() + "\t" + dat.getCod_4() + "\t"
                            + dat.getCod_6() + "\t" + dat.getCod_8() + "\t" + dat.getCod_11() + "\t"
                            + dat.getNombre_Cuenta() + "\t" + dat.getCuenta_1() + "\t" + dat.getCuenta_2() + "\t"
                            + dat.getCuenta_4() + "\t" + dat.getCuenta_6() + "\t" + dat.getCuenta_8() + "\t"
                            + dat.getCuenta_11() + "\t" + dat.getFecha_Combrobante() + "\t"
                            + dat.getNumero_Comprobante() + "\t"
                            + dat.getTipo_Comprobante() + "\t" + dat.getNombre_Comprobante() + "\t" + dat.getDebito()
                            + "\t"
                            + dat.getCredito() + "\t" + dat.getNIT_Tercero() + "\t" + dat.getNombre_Comun() + "\t"
                            + dat.getTipo_Persona() + "\t"
                            + dat.getDescripcion() + "\t" + dat.getUsuario());
                    bw.newLine();
                }
                bw.close();
                fw.close();
            } catch (Exception e) {
                System.out.println("Error al escribir el archivo");
            }
        }
    }

    public int QuaterIndicator(String fecha) {
        int quater = 0;
        String[] fechaSeparada = fecha.split("/");
        // los meses son 01 02 03 04 05 06 07 08 09 10 11 12
        if (Integer.valueOf(fechaSeparada[1]) >= 1 && Integer.valueOf(fechaSeparada[1]) <= 3) {
            quater = 1;
        } else if (Integer.valueOf(fechaSeparada[1]) >= 4 && Integer.valueOf(fechaSeparada[1]) <= 6) {
            quater = 2;
        } else if (Integer.valueOf(fechaSeparada[1]) >= 7 && Integer.valueOf(fechaSeparada[1]) <= 9) {
            quater = 3;
        } else if (Integer.valueOf(fechaSeparada[1]) >= 10 && Integer.valueOf(fechaSeparada[1]) <= 12) {
            quater = 4;
        }

        return quater;
    }

}
