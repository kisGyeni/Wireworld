package sample;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class InGameScene {
    private final GridPane root;
    public static ArrayList<ArrayList<Cell>> grid;
    private Thread animation;

    public InGameScene() {
        this(new ArrayList<>());
    }

    public InGameScene(ArrayList<ArrayList<Cell>> inputGrid) {
        grid = new ArrayList<>(inputGrid);
        root = new GridPane();


        Group area = new Group();
        GridPane buttons = new GridPane();
        GridPane brushes = new GridPane();

        root.add(area, 0, 0);
        root.add(buttons, 0, 1);
        root.add(brushes, 1, 0);

        FormattableButton nxt = new FormattableButton("Next", "black", 14);
        buttons.add(nxt, 0,0);

        nxt.setMinSize(100, 60);

        FormattableButton deElectrify = new FormattableButton("\uD83D\uDDF2 Clear\nelectricity", "goldenrod", 14);
        buttons.add(deElectrify, 1, 0);

        deElectrify.setMinSize(100, 60);

        GridPane pairButtons = new GridPane();
        buttons.add(pairButtons, 2, 0);
        pairButtons.setHgap(10);

        FormattableButton start = new FormattableButton("\u25B6 Start", "green", 14);
        pairButtons.add(start, 0, 0);
        start.setMinSize(100, 30);

        FormattableButton stop = new FormattableButton("￭ Stop", "firebrick", 14);
        pairButtons.add(stop, 0, 1);
        stop.setMinSize(100, 30);

        FormattableButton save = new FormattableButton("Save", "black", 14);
        pairButtons.add(save, 1, 0);
        save.setMinSize(100, 30);

        FormattableButton load = new FormattableButton("Load", "black", 14);
        pairButtons.add(load, 1, 1);
        load.setMinSize(100, 30);

        buttons.setHgap(10);
        buttons.setAlignment(Pos.CENTER);

        FormattableButton clear = new FormattableButton("Clear field", "black", 14);
        buttons.add(clear, 3, 0);
        clear.setMinSize(100, 60);

        FormattableButton yellowCell = new FormattableButton("\uD83C\uDFA8", "#E6C300", 16);
        FormattableButton blueCell = new FormattableButton("\uD83C\uDFA8", "#8080A8", 12);
        FormattableButton redCell = new FormattableButton("\uD83C\uDFA8", "#B27272", 12);
        FormattableButton blackCell = new FormattableButton("\uD83C\uDFA8", "#A9A9A9", 12);
        FormattableButton cycleCell = new FormattableButton("\u26D2", "seagreen", 16);

        yellowCell.setMinSize(40, 120);
        yellowCell.setMaxSize(40, 120);
        blackCell.setMinSize(40, 120);
        blackCell.setMaxSize(40, 120);
        blueCell.setMinSize(40, 120);
        blueCell.setMaxSize(40, 120);
        redCell.setMinSize(40, 120);
        redCell.setMaxSize(40, 120);
        cycleCell.setMinSize(40, 120);
        cycleCell.setMaxSize(40, 120);

        brushes.add(yellowCell, 0, 0);
        brushes.add(blueCell, 0, 1);
        brushes.add(redCell, 0, 2);
        brushes.add(blackCell, 0, 3);
        brushes.add(cycleCell, 0, 4);

        yellowCell.setOnMouseClicked(mouseEvent -> {
            Cell.cycleMode = false;
            cycleCell.setText("\u26D2");
            yellowCell.setStyle("-fx-text-fill: #E6C300; -fx-font-size: 16");
            blueCell.setStyle("-fx-text-fill: #8080A8; -fx-font-size: 12");
            redCell.setStyle("-fx-text-fill: #B27272; -fx-font-size: 12");
            blackCell.setStyle("-fx-text-fill: #A9A9A9; -fx-font-size: 12");
            Cell.makeToColor(CellType.WIRE);
        });
        blueCell.setOnMouseClicked(mouseEvent -> {
            Cell.cycleMode = false;
            cycleCell.setText("\u26D2");
            yellowCell.setStyle("-fx-text-fill: #B6B18B; -fx-font-size: 12");
            blueCell.setStyle("-fx-text-fill: blue; -fx-font-size: 16");
            redCell.setStyle("-fx-text-fill: #B27272; -fx-font-size: 12");
            blackCell.setStyle("-fx-text-fill: #A9A9A9; -fx-font-size: 12");
            Cell.makeToColor(CellType.HEAD);
        });
        redCell.setOnMouseClicked(mouseEvent -> {
            Cell.cycleMode = false;
            cycleCell.setText("\u26D2");
            yellowCell.setStyle("-fx-text-fill: #B6B18B; -fx-font-size: 12");
            blueCell.setStyle("-fx-text-fill: #8080A8; -fx-font-size: 12");
            redCell.setStyle("-fx-text-fill: firebrick; -fx-font-size: 16");
            blackCell.setStyle("-fx-text-fill: #A9A9A9; -fx-font-size: 12");
            Cell.makeToColor(CellType.TAIL);
        });
        blackCell.setOnMouseClicked(mouseEvent -> {
            Cell.cycleMode = false;
            cycleCell.setText("\u26D2");
            yellowCell.setStyle("-fx-text-fill: #B6B18B; -fx-font-size: 12");
            blueCell.setStyle("-fx-text-fill: #8080A8; -fx-font-size: 12");
            redCell.setStyle("-fx-text-fill: #B27272; -fx-font-size: 12");
            blackCell.setStyle("-fx-text-fill: black; -fx-font-size: 16");
            Cell.makeToColor(CellType.BLANK);
        });
        cycleCell.setOnMouseClicked(mouseEvent -> {
            Cell.cycleMode = !Cell.cycleMode;
            if (Cell.cycleMode) {
                cycleCell.setText("\u267C");
                yellowCell.setStyle("-fx-text-fill: #A9A9A9; -fx-font-size: 12");
                blueCell.setStyle("-fx-text-fill: #A9A9A9; -fx-font-size: 12");
                redCell.setStyle("-fx-text-fill: #A9A9A9; -fx-font-size: 12");
                blackCell.setStyle("-fx-text-fill: #A9A9A9; -fx-font-size: 12");
            }
            else {
                cycleCell.setText("\u26D2");
                yellowCell.setStyle("-fx-text-fill: gold; -fx-font-size: 16");
                blueCell.setStyle("-fx-text-fill: #8080A8; -fx-font-size: 14");
                redCell.setStyle("-fx-text-fill: #B27272; -fx-font-size: 14");
                blackCell.setStyle("-fx-text-fill: #A9A9A9; -fx-font-size: 14");
                Cell.makeToColor(CellType.WIRE);
            }
        });

        if(grid.isEmpty()) {
            for (int i = 0; i < 40; i++) {
                grid.add(new ArrayList<>());
            }

            for (int i = 0; i < 80; i++) {  //80
                for (int j = 0; j < 40; j++) { // 40
                    Cell rect = Cell.createCellAt(i, j);
                    grid.get(j).add(rect);
                }
            }
        }
        for (int i = 0; i < 80; i++) {  //80
            for (int j = 0; j < 40; j++) { // 40
                area.getChildren().add(grid.get(j).get(i));
            }
        }
        System.out.println(grid.get(0).get(0).getFill().equals(Color.GOLDENROD));
        nxt.setOnMouseClicked(mouseEvent -> {
            Animate.nextState(grid);
        });
        deElectrify.setOnMouseClicked(mouseEvent -> {
            clearElecticity(grid);
        });

        start.setOnMouseClicked(mouseEvent -> {
            initAnimation();
        });
        stop.setOnMouseClicked(mouseEvent -> {
            stopAnimation();
        });

        clear.setOnMouseClicked(mouseEvent -> {
            resetField(grid);
        });

        load.setOnMouseClicked(mouseEvent -> {
            stopAnimation();
            LoadScene ld = new LoadScene();
            load.getScene().setRoot(ld.getRootPane());
        });
        save.setOnMouseClicked(mouseEvent -> {
            stopAnimation();
            SaveScene sv = new SaveScene(grid);
            load.getScene().setRoot(sv.getRootPane());
        });
    }

    public Pane getRootPane() {
        return root ;
    }

    private void stopAnimation() {
        if(animation != null && animation.isAlive())
            animation.stop();
    }

    private void initAnimation() {
        animation = new Thread(new Animate());
        animation.start();
    }

    private void clearElecticity(ArrayList<ArrayList<Cell>> grid) {
        int rows = grid.size();
        for (int i = 0; i < rows; i++) {
            int cols = grid.get(i).size();
            for (int j = 0; j < cols; j++) {
                if (grid.get(i).get(j).getFill().equals(Color.FIREBRICK) || grid.get(i).get(j).getFill().equals(Color.NAVY))
                    grid.get(i).get(j).setFill(Color.GOLDENROD);
            }
        }
    }

    private void resetField(ArrayList<ArrayList<Cell>> grid) {
        int rows = grid.size();
        for (int i = 0; i < rows; i++) {
            int cols = grid.get(i).size();
            for (int j = 0; j < cols; j++) {
                grid.get(i).get(j).setFill(Color.gray(0.1));
            }
        }
    }
}
