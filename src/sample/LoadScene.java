package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.*;
import java.util.ArrayList;

public class LoadScene {

    private final GridPane root;
    LoadScene() {
        root = new GridPane();
        Label nameTxt = new Label("Filename: ");
        TextField name = new TextField();
        FormattableButton ldButton = new FormattableButton("Load", "black", 16);
        GridPane top = new GridPane();
        top.add(nameTxt, 0, 0);
        top.add(name, 1, 0);
        root.add(top, 0, 0);
        root.add(ldButton, 0, 1);
        top.setAlignment(Pos.CENTER);
        ldButton.setMinWidth(210);
        root.setAlignment(Pos.CENTER);

        ldButton.setOnMouseClicked(mouseEvent -> {
                ArrayList<ArrayList<Cell>> loaded = new ArrayList<>();
            try {

                FileReader fr = new FileReader(name.getText() + ".txt");

                for (int i = 0; i < 40; i++) {
                    loaded.add(new ArrayList<>());
                }

                int c;
                for (int i = 0; i < 80; i++) {  //80
                    for (int j = 0; j < 40; j++) { // 40
                        Cell rect = Cell.createCellAt(i, j);
                        loaded.get(j).add(rect);
                        c = fr.read();
                        if((char)c == 'w')
                            loaded.get(j).get(i).setFill(Color.GOLDENROD);
                        else if((char)c == 'h')
                            loaded.get(j).get(i).setFill(Color.NAVY);
                        else if((char)c == 't')
                            loaded.get(j).get(i).setFill(Color.FIREBRICK);
                    }
                }
                fr.close();

                InGameScene scr = new InGameScene(loaded);
                ldButton.getScene().setRoot(scr.getRootPane());

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    public Pane getRootPane() {
        return root ;
    }
}
