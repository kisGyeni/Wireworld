package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.Serializable;

public class Cell extends Rectangle implements Serializable {

    private int xpos;
    private int ypos;
    public CellType nextStateType;
    static public CellType brush = CellType.WIRE;
    public static boolean cycleMode = false;

    public Cell(int i, int j) {
        super(i*15, j*15, 15, 15);
        xpos = i;
        ypos = j;
    }

    public static void makeToColor(CellType to) {
        brush = to;
    }

    public static Cell createCellAt(int i, int j) {
        Cell rect = new Cell(i, j);

        rect.setFill(Color.gray(0.1));
        rect.setStroke(Color.gray(0.15));
        rect.setStrokeWidth(1);

        rect.setOnMouseClicked(mouseEvent -> {
            if (!rect.cycleMode) {
                if (brush == CellType.WIRE)
                    rect.setFill(Color.GOLDENROD);
                else if (brush == CellType.HEAD)
                    rect.setFill(Color.NAVY);
                else if (brush == CellType.TAIL)
                    rect.setFill(Color.FIREBRICK);
                else if (brush == CellType.BLANK)
                    rect.setFill(Color.gray(0.1));
            }
            else {
                if (rect.getFill().equals(Color.gray(0.1)))
                    rect.setFill(Color.GOLDENROD);
                else if (rect.getFill().equals(Color.GOLDENROD))
                    rect.setFill(Color.FIREBRICK);
                else if (rect.getFill().equals(Color.FIREBRICK))
                    rect.setFill(Color.NAVY);
                else if (rect.getFill().equals(Color.NAVY))
                    rect.setFill(Color.gray(0.1));
            }
        });

        return rect;
    }
}
