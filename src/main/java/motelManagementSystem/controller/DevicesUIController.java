package motelManagementSystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import motelManagementSystem.App;
import motelManagementSystem.classes.Room;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DevicesUIController implements Initializable {

    @FXML
    private AnchorPane mainWindow;
    @FXML
    private AnchorPane addAndEditWindow;
    @FXML
    private HBox addButtons;
    @FXML
    private HBox editButtons;
    @FXML
    private TableView<Room> table;
    @FXML
    private TableColumn<Room, String> numberColumn;
    @FXML
    private TableColumn<Room, String> nameColumn;
    @FXML
    private TableColumn<Room, Integer> moneyColumn;
    @FXML
    private TableColumn<Room, Integer> energyColumn;
    @FXML
    private TableColumn<Room, Integer> waterColumn;
    @FXML
    private TableColumn<Room, Integer> wifiColumn;
    @FXML
    private TableColumn<Room, Integer> extraColumn;
    @FXML
    private TableColumn<Room, Integer> totalColumn;
    @FXML
    private TableColumn<Room, String> statusColumn;
    @FXML
    private TableColumn<Room, Void> editColumn;
    @FXML
    private TextField numberTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField moneyTextField;
    @FXML
    private TextField energyTextField;
    @FXML
    private TextField waterTextField;
    @FXML
    private TextField wifiTextField;
    @FXML
    private TextField extraTextField;
    @FXML
    private TextField totalTextField;
    @FXML
    private TextField statusTextField;
    private ObservableList<Room> roomList;
    private Room room;

    public DevicesUIController() {
    }

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO Sửa lại sau khi có database: devicesList sẽ lấy danh sách phòng từ database
        roomList = FXCollections.observableArrayList(
                new Room("MIC", "MIC",22, 12, 3,3,3,3, "Micro")

        );
        numberColumn.setCellValueFactory(new PropertyValueFactory<Room, String>( "number"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Room, String>( "name"));
        moneyColumn.setCellValueFactory(new PropertyValueFactory<Room, Integer>( "money"));
        energyColumn.setCellValueFactory(new PropertyValueFactory<Room, Integer>( "energy"));
        waterColumn.setCellValueFactory(new PropertyValueFactory<Room, Integer>( "water"));
        wifiColumn.setCellValueFactory(new PropertyValueFactory<Room, Integer>( "wifi"));
        extraColumn.setCellValueFactory(new PropertyValueFactory<Room, Integer>( "extra"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<Room, Integer>( "total"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Room, String>( "status"));
        table.setItems(roomList);
        addButtonToTable();
    }

    //Thêm các nút edit vào các hàng
    private void addButtonToTable() {
        Callback<TableColumn<Room, Void>, TableCell<Room, Void>> cellFactory = new Callback<TableColumn<Room, Void>, TableCell<Room, Void>>() {
            @Override
            public TableCell<Room, Void> call(final TableColumn<Room, Void> devicesVoidTableColumn) {
                final TableCell<Room, Void> cell= new TableCell<Room, Void>() {
                    final Button btn = new Button("Edit");
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            //Chuyển sang giao diện giống add nhưng có sẵn thông tin của phòng cần sửa
                            btn.setOnAction(e -> {
                                TableRow<Room> row = getTableRow();
                                if (row != null) {
                                    room = row.getItem();
                                    openEditWindow();
                                }
                            });
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
        editColumn.setCellFactory(cellFactory);
    }

    //Mở của sổ để thêm phòng
    @FXML
    public void openAddWindow() {
        addAndEditWindow.setVisible(true);
        BoxBlur blur = new BoxBlur(5, 5, 3);
        mainWindow.setEffect(blur);
        addButtons.setVisible(true);
        editButtons.setVisible(false);
        numberTextField.setText(null);
        nameTextField.setText(null);
        moneyTextField.setText(null);
        energyTextField.setText(null);
        waterTextField.setText(null);
        wifiTextField.setText(null);
        extraTextField.setText(null);
        totalTextField.setText(null);
        statusTextField.setText(null);
    }

    //Mở của sổ chỉnh sửa phòng
    @FXML
    public void openEditWindow() {
        addAndEditWindow.setVisible(true);
        BoxBlur blur = new BoxBlur(5, 5, 3);
        mainWindow.setEffect(blur);
        addButtons.setVisible(false);
        editButtons.setVisible(true);
        numberTextField.setText(room.getNumber());
        nameTextField.setText(room.getName());
        moneyTextField.setText(String.valueOf(room.getMoney()));
        energyTextField.setText(String.valueOf(room.getEnergy()));
        waterTextField.setText(String.valueOf(room.getWater()));
        wifiTextField.setText(String.valueOf(room.getWifi()));
        extraTextField.setText(String.valueOf(room.getExtra()));
        totalTextField.setText(String.valueOf(room.getTotal()));
        statusTextField.setText(room.getStatus());
    }

    //Đóng Popup window
    @FXML
    public void closePopup() {
        addAndEditWindow.setVisible(false);
        mainWindow.setEffect(null);
    }

    //TODO Với các phần thêm, xóa, sửa thì phải cập nhật lên database
    public void addDevice (ActionEvent event) {
        Room newRoom = new Room();
        newRoom.setNumber(numberTextField.getText());
        newRoom.setName(nameTextField.getText());
        newRoom.setMoney(Integer.parseInt(moneyTextField.getText()));
        newRoom.setEnergy(Integer.parseInt(energyTextField.getText()));
        newRoom.setWater(Integer.parseInt(waterTextField.getText()));
        newRoom.setWifi(Integer.parseInt(wifiTextField.getText()));
        newRoom.setExtra(Integer.parseInt(extraTextField.getText()));
        newRoom.setTotal(Integer.parseInt(totalTextField.getText()));
        newRoom.setStatus(statusTextField.getText());
        roomList.add(newRoom);
        closePopup();
    }

    public void deleteDevice(ActionEvent event) {
        roomList.remove(room);
        closePopup();
    }

    //Lưu lại thay đổi thiết bị
    public void applyChanges (ActionEvent event) {
        Room updateRoom = new Room();
        updateRoom.setNumber(numberTextField.getText());
        updateRoom.setName(nameTextField.getText());
        updateRoom.setMoney(Integer.parseInt(moneyTextField.getText()));
        updateRoom.setEnergy(Integer.parseInt(energyTextField.getText()));
        updateRoom.setWater(Integer.parseInt(waterTextField.getText()));
        updateRoom.setWifi(Integer.parseInt(wifiTextField.getText()));
        updateRoom.setExtra(Integer.parseInt(extraTextField.getText()));
        updateRoom.setTotal(Integer.parseInt(totalTextField.getText()));
        updateRoom.setStatus(statusTextField.getText());
        int i = 0;
        if (roomList.get(i).equals(room))
            roomList.set(i, updateRoom);
        closePopup();
    }
}
