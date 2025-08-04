import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DisplayFlags extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane
        GridPane pane = new GridPane();

        // Load image files from the project directory
        ImageView imageView1 = new ImageView(new Image("file:flag1.gif"));
        ImageView imageView2 = new ImageView(new Image("file:flag2.gif"));
        ImageView imageView3 = new ImageView(new Image("file:flag6.gif"));
        ImageView imageView4 = new ImageView(new Image("file:flag7.gif"));

        // Add them to the grid
        pane.add(imageView1, 0, 0);
        pane.add(imageView2, 1, 0);
        pane.add(imageView3, 0, 1);
        pane.add(imageView4, 1, 1);

        // Display the scene
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Display Flags");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}