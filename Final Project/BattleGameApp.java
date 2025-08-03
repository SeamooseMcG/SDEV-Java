import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Node;

public class BattleGameApp extends Application {

    private Player player;
    private Enemy enemy;
    private TextArea battleLog;
    private Label playerStatus;
    private Label enemyStatus;
    private Button attackBtn;
    private Button specialBtn;
    private Node playerShape;
    private Node enemyShape;

    @Override
    public void start(Stage primaryStage) {
        // Initialize characters
        player = new Player("Hero");

        int type = (int) (Math.random() * 3);
        enemy = switch (type) {
            case 0 -> new TriangleEnemy();
            case 1 -> new SquareEnemy();
            default -> new OctagonEnemy();
        };

        // Shape representations
        playerShape = new Circle(20, Color.DODGERBLUE);
        enemyShape = enemy.getVisual();

        // Status labels
        playerStatus = new Label(player.getStatus());
        enemyStatus = new Label(enemy.getStatus());

        // Battle log
        battleLog = new TextArea();
        battleLog.setEditable(false);
        battleLog.setWrapText(true);
        battleLog.setPrefHeight(200);

        // Buttons
        attackBtn = new Button("Attack");
        specialBtn = new Button("Special");

        attackBtn.setOnAction(e -> handlePlayerTurn(false));
        specialBtn.setOnAction(e -> handlePlayerTurn(true));

        // Layout
        HBox shapesBox = new HBox(40, playerShape, enemyShape);
        shapesBox.setStyle("-fx-alignment: center; -fx-padding: 10;");

        HBox statusBox = new HBox(40, playerStatus, enemyStatus);
        statusBox.setStyle("-fx-alignment: center;");

        HBox buttonBox = new HBox(10, attackBtn, specialBtn);
        buttonBox.setStyle("-fx-alignment: center;");

        VBox root = new VBox(10, shapesBox, statusBox, buttonBox, battleLog);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Scene setup
        Scene scene = new Scene(root, 450, 350);
        primaryStage.setTitle("Turn-Based Battle Game");
        primaryStage.setScene(scene);
        primaryStage.show();

        updateStatus(); // initial display
    }

    private void handlePlayerTurn(boolean useSpecial) {
        if (!player.isAlive() || !enemy.isAlive()) return;

        String playerAction = useSpecial ? player.specialMove(enemy) : player.attack(enemy);

        // Detect "blocked" special message
        if (playerAction.contains("can't use Special")) {
            showAlert("Invalid Action", playerAction);
            return; // Don't let the enemy attack if player's action was blocked
    }

        updateBattle(playerAction);

        if (!enemy.isAlive()) {
            updateBattle("You win!");
            disableButtons();
            updateStatus();
            return;
        }

        String enemyAction = enemy.takeTurn(player);
        updateBattle(enemyAction);

        if (!player.isAlive()) {
            updateBattle("You were defeated...");
            disableButtons();
        }

        updateStatus();
    }

    private void updateBattle(String message) {
        battleLog.appendText(message + "\n");
    }

    private void updateStatus() {
        playerStatus.setText(player.getStatus());
        enemyStatus.setText(enemy.getStatus());
    }

    private void disableButtons() {
        attackBtn.setDisable(true);
        specialBtn.setDisable(true);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void showAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();

    
}
}

