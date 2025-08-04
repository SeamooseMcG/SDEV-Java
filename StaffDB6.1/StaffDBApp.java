import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class StaffDBApp extends Application {

    private TextField tfId = new TextField();
    private TextField tfLastName = new TextField();
    private TextField tfFirstName = new TextField();
    private TextField tfMi = new TextField();
    private TextField tfAddress = new TextField();
    private TextField tfCity = new TextField();
    private TextField tfState = new TextField();
    private TextField tfTelephone = new TextField();
    private TextField tfEmail = new TextField();
    private Label lblStatus = new Label();

    // Simulated database
    private Map<String, Staff> db = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setHgap(5);
        pane.setVgap(5);

        pane.add(new Label("ID"), 0, 0);            pane.add(tfId, 1, 0);
        pane.add(new Label("Last Name"), 0, 1);     pane.add(tfLastName, 1, 1);
        pane.add(new Label("First Name"), 2, 1);    pane.add(tfFirstName, 3, 1);
        pane.add(new Label("MI"), 4, 1);            pane.add(tfMi, 5, 1);
        pane.add(new Label("Address"), 0, 2);       pane.add(tfAddress, 1, 2, 5, 1);
        pane.add(new Label("City"), 0, 3);          pane.add(tfCity, 1, 3);
        pane.add(new Label("State"), 2, 3);         pane.add(tfState, 3, 3);
        pane.add(new Label("Telephone"), 0, 4);     pane.add(tfTelephone, 1, 4);
        pane.add(new Label("Email"), 2, 4);         pane.add(tfEmail, 3, 4, 3, 1);

        HBox buttons = new HBox(10);
        Button btView = new Button("View");
        Button btInsert = new Button("Insert");
        Button btUpdate = new Button("Update");
        Button btClear = new Button("Clear");
        buttons.getChildren().addAll(btView, btInsert, btUpdate, btClear);
        buttons.setPadding(new Insets(10, 0, 0, 0));

        VBox root = new VBox(10, pane, buttons, lblStatus);
        Scene scene = new Scene(root, 620, 280);
        primaryStage.setTitle("Simulated Staff DB");
        primaryStage.setScene(scene);
        primaryStage.show();

        btView.setOnAction(e -> viewRecord());
        btInsert.setOnAction(e -> insertRecord());
        btUpdate.setOnAction(e -> updateRecord());
        btClear.setOnAction(e -> clearFields());
    }

    private void viewRecord() {
        String id = tfId.getText().trim();
        Staff staff = db.get(id);
        if (staff != null) {
            tfLastName.setText(staff.lastName);
            tfFirstName.setText(staff.firstName);
            tfMi.setText(staff.mi);
            tfAddress.setText(staff.address);
            tfCity.setText(staff.city);
            tfState.setText(staff.state);
            tfTelephone.setText(staff.telephone);
            tfEmail.setText(staff.email);
            lblStatus.setText("Record found.");
        } else {
            lblStatus.setText("Record not found.");
        }
    }

    private void insertRecord() {
        String id = tfId.getText().trim();
        if (db.containsKey(id)) {
            lblStatus.setText("ID already exists.");
        } else {
            Staff staff = collectStaffFromFields();
            db.put(id, staff);
            lblStatus.setText("Record inserted.");
        }
    }

    private void updateRecord() {
        String id = tfId.getText().trim();
        if (db.containsKey(id)) {
            db.put(id, collectStaffFromFields());
            lblStatus.setText("Record updated.");
        } else {
            lblStatus.setText("ID not found.");
        }
    }

    private void clearFields() {
        tfId.clear();
        tfLastName.clear();
        tfFirstName.clear();
        tfMi.clear();
        tfAddress.clear();
        tfCity.clear();
        tfState.clear();
        tfTelephone.clear();
        tfEmail.clear();
        lblStatus.setText("");
    }

    private Staff collectStaffFromFields() {
        return new Staff(
            tfLastName.getText().trim(),
            tfFirstName.getText().trim(),
            tfMi.getText().trim(),
            tfAddress.getText().trim(),
            tfCity.getText().trim(),
            tfState.getText().trim(),
            tfTelephone.getText().trim(),
            tfEmail.getText().trim()
        );
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Inner class to simulate a record
    private static class Staff {
        String lastName, firstName, mi, address, city, state, telephone, email;

        Staff(String ln, String fn, String mi, String addr, String city,
              String state, String phone, String email) {
            this.lastName = ln;
            this.firstName = fn;
            this.mi = mi;
            this.address = addr;
            this.city = city;
            this.state = state;
            this.telephone = phone;
            this.email = email;
        }
    }
}