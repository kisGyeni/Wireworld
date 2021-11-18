package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    private final GridPane root = new GridPane();

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(root, 1240, 660, Color.LIGHTGRAY);

        primaryStage.setTitle("Wireworld");
        primaryStage.setScene(scene);
        primaryStage.show();

        MenuScene menu = new MenuScene();
        primaryStage.getScene().setRoot(menu.getRootPane());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
