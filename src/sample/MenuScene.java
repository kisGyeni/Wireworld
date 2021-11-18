package sample;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MenuScene {
    private final GridPane root;
    MenuScene() {
        root = new GridPane();

        FormattableButton blank = new FormattableButton("New blank board", "black", 18);
        FormattableButton loadIn = new FormattableButton("Load existing board", "black", 18);
        blank.setMinWidth(200);
        loadIn.setMinWidth(200);
        root.add(blank, 0, 0);
        root.add(loadIn, 0, 1);
        root.setHgap(20);
        root.setAlignment(Pos.CENTER);

        blank.setOnMouseClicked(mouseEvent -> {
            InGameScene src = new InGameScene();
            blank.getScene().setRoot(src.getRootPane());
        });
        loadIn.setOnMouseClicked(mouseEvent -> {
            LoadScene src = new LoadScene();
            loadIn.getScene().setRoot(src.getRootPane());
        });
    }

    public Pane getRootPane() {
        return root ;
    }
}
