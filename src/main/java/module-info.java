module motelManagementSystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens motelManagementSystem to javafx.fxml;
    exports motelManagementSystem;
    exports motelManagementSystem.classes;
    exports motelManagementSystem.controller;
    opens motelManagementSystem.controller to javafx.fxml;
}