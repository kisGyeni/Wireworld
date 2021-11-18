package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.*;
import java.util.ArrayList;

public class SaveScene {
    private final GridPane root;
    SaveScene(ArrayList<ArrayList<Cell>> grid) {
        root = new GridPane();
        Label nameTxt = new Label("Filename: ");
        TextField name = new TextField();
        FormattableButton ldButton = new FormattableButton("Save", "black", 16);
        GridPane top = new GridPane();
        top.add(nameTxt, 0, 0);
        top.add(name, 1, 0);
        root.add(top, 0, 0);
        root.add(ldButton, 0, 1);
        top.setAlignment(Pos.CENTER);
        ldButton.setMinWidth(210);
        root.setAlignment(Pos.CENTER);

        ldButton.setOnMouseClicked(mouseEvent -> {
            //save

            FileWriter fw = null;
            try {
                fw = new FileWriter(name.getText() + ".txt");
            for (int i = 0; i < 80; i++) {  //80
                    for (int j = 0; j < 40; j++) { // 40

                        if (grid.get(j).get(i).getFill().equals(Color.GOLDENROD))
                            fw.write('w');
                        else if (grid.get(j).get(i).getFill().equals(Color.NAVY))
                            fw.write('h');
                        else if (grid.get(j).get(i).getFill().equals(Color.FIREBRICK))
                            fw.write('t');
                        else
                            fw.write('b');
                    }
                }
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //switch view
            MenuScene scr = new MenuScene();
            ldButton.getScene().setRoot(scr.getRootPane());
        });
    }
    public Pane getRootPane() {
        return root ;
    }
}
