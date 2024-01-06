package motelManagementSystem.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import motelManagementSystem.App;

import java.io.IOException;

public class ManageUIController {
    @FXML
    private AnchorPane addProvisionPopup;
    @FXML
    public void switchToHome() throws IOException {
        App.setRoot("homeUI");
    }
    @FXML
    public void switchToManage() throws IOException {
        App.setRoot("manageUI");
    }
    @FXML
    public void switchToDevices() throws IOException {
        App.setRoot("devicesUI");
    }
    @FXML
    public void switchToClients() throws IOException {
        App.setRoot("clientsUI");
    }
    @FXML
    public void switchToProfile() throws IOException {
        App.setRoot("profileUI");
    }

    @FXML
    public void showMakeProvisionPopup()
    {
        addProvisionPopup.setVisible(true);
    }

    @FXML
    public void addProvision()
    {

    }

    @FXML
    public void closePopup()
    {

    }
}
