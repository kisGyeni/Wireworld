package sample;

import javafx.scene.control.Button;

public class FormattableButton extends Button {
    public FormattableButton(String text, String color, int fontSize) {
        this.setStyle("-fx-text-fill: " + color + "; -fx-font-size: " + fontSize);
        this.textProperty().set(text);
    }
}
