import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorSliderText extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Text to color
        Text text = new Text("Show Colors");
        text.setStyle("-fx-font-size: 24px;");

        // Sliders for Red, Green, Blue, and Opacity
        Slider redSlider = createSlider();
        Slider greenSlider = createSlider();
        Slider blueSlider = createSlider();
        Slider opacitySlider = createSlider();
        opacitySlider.setValue(100); // Fully opaque initially

        // Layout with labels
        GridPane sliders = new GridPane();
        sliders.setHgap(10);
        sliders.setVgap(10);
        sliders.setAlignment(Pos.CENTER);

        sliders.addRow(0, new Label("Red"), redSlider);
        sliders.addRow(1, new Label("Green"), greenSlider);
        sliders.addRow(2, new Label("Blue"), blueSlider);
        sliders.addRow(3, new Label("Opacity"), opacitySlider);

        // Update text fill when sliders change
        Runnable updateColor = () -> {
            double r = redSlider.getValue() / 100.0;
            double g = greenSlider.getValue() / 100.0;
            double b = blueSlider.getValue() / 100.0;
            double o = opacitySlider.getValue() / 100.0;
            text.setFill(new Color(r, g, b, o));
        };

        redSlider.valueProperty().addListener(e -> updateColor.run());
        greenSlider.valueProperty().addListener(e -> updateColor.run());
        blueSlider.valueProperty().addListener(e -> updateColor.run());
        opacitySlider.valueProperty().addListener(e -> updateColor.run());

        VBox root = new VBox(20, text, sliders);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 250);
        primaryStage.setTitle("Exercise16_17");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Helper to create a standard horizontal slider
    private Slider createSlider() {
        Slider slider = new Slider(0, 100, 0);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(25);
        slider.setMinorTickCount(5);
        slider.setBlockIncrement(1);
        slider.setPrefWidth(200);
        return slider;
    }

    public static void main(String[] args) {
        launch(args);
    }
}