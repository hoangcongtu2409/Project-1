module motelManagementSystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.naming;
    requires java.desktop;
    requires com.microsoft.sqlserver.jdbc;

    opens motelManagementSystem to javafx.fxml;
    exports motelManagementSystem;
    exports motelManagementSystem.classes;
    exports motelManagementSystem.controller;
    opens motelManagementSystem.controller to javafx.fxml;
    exports motelManagementSystem.constant;
    opens motelManagementSystem.constant to javafx.fxml;
    exports motelManagementSystem.model;
    opens motelManagementSystem.model to javafx.fxml;
    exports motelManagementSystem.dbcontext;
    opens motelManagementSystem.dbcontext to javafx.fxml;
}