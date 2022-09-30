module com.example.proyecto2 {
    requires javafx.controls;
    requires javafx.fxml;


    //opens com.example.proyecto2 to javafx.fxml;
    //exports com.example.proyecto2;
    exports umg.edu;
    opens umg.edu to javafx.fxml;
    exports umg.edu.controller;
    opens umg.edu.controller to javafx.fxml;
}