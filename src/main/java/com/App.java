package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    
    @Override
    public void start( Stage stage) throws IOException {
        scene = new Scene(loadFXML("layout"), 640, 480);
        stage.setScene(scene);
        stage.setTitle("ACCIÓN FIDUCIARIA 1");
        stage.getIcons().add(new Image("src/main/resources/com/assets/228-2282843_iconos-png-icono-alternativas-png-transparent-png.png"));
        
        
        stage.show();
    }

    

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}