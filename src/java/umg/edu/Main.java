package umg.edu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;
//Cristian Alejandro Melgar Ordoñez 7690 21 8342
//
//
public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600.0, 400.0);
        stage.setTitle("Cuestionario");
        stage.setScene(scene);
        stage.show();
    }   

    public static void main(String[] args) {
        launch(args);
    }
}