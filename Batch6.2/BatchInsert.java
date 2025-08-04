import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class BatchInsert extends Application {

    private TextArea textArea = new TextArea();

    // Our simulated in-memory table
    private List<TempRecord> table = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        Button btBatch = new Button("Batch Update");
        Button btNonBatch = new Button("Non-Batch Update");

        HBox buttonBox = new HBox(10, btBatch, btNonBatch);
        buttonBox.setPadding(new Insets(10));

        VBox root = new VBox(10, textArea, buttonBox);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 450, 300);
        primaryStage.setTitle("Simulated Batch Update");
        primaryStage.setScene(scene);
        primaryStage.show();

        btBatch.setOnAction(e -> performBatchInsert());
        btNonBatch.setOnAction(e -> performNonBatchInsert());
    }

    private void performBatchInsert() {
        table.clear(); // Reset
        long start = System.currentTimeMillis();

        // Simulate preparing a batch
        List<TempRecord> batch = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            batch.add(new TempRecord(Math.random(), Math.random(), Math.random()));
        }

        // Simulate committing the batch
        table.addAll(batch);

        long end = System.currentTimeMillis();
        textArea.appendText("Batch update completed\n");
        textArea.appendText("The elapsed time is " + (end - start) + " ms\n");
    }

    private void performNonBatchInsert() {
        table.clear(); // Reset
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            table.add(new TempRecord(Math.random(), Math.random(), Math.random()));
        }

        long end = System.currentTimeMillis();
        textArea.appendText("Non-Batch update completed\n");
        textArea.appendText("The elapsed time is " + (end - start) + " ms\n");
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Simulated table row
    private static class TempRecord {
        double num1, num2, num3;

        TempRecord(double n1, double n2, double n3) {
            num1 = n1;
            num2 = n2;
            num3 = n3;
        }
    }
}