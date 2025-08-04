import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleColorChange extends Application {

    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(100);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        // Mouse press -> change to black
        circle.setOnMousePressed((MouseEvent e) -> {
            circle.setFill(Color.BLACK);
        });

        // Mouse release -> change to white
        circle.setOnMouseReleased((MouseEvent e) -> {
            circle.setFill(Color.WHITE);
        });

        StackPane pane = new StackPane(circle);
        Scene scene = new Scene(pane, 300, 300);

        primaryStage.setTitle("Circle Color Change");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}