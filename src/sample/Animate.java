package sample;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Animate extends Thread {

    public void run() {
        while(true) {
            nextState(InGameScene.grid);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void nextState(ArrayList<ArrayList<Cell>> grid) {

        int rows = grid.size();
        for (int i = 0; i < rows; i++) {
            int cols = grid.get(i).size();
            for (int j = 0; j < cols; j++) {

                if (grid.get(i).get(j).getFill().equals(Color.gray(0.1)))
                    grid.get(i).get(j).nextStateType = CellType.BLANK;

                else if (grid.get(i).get(j).getFill().equals(Color.NAVY))
                    grid.get(i).get(j).nextStateType = CellType.TAIL;

                else if (grid.get(i).get(j).getFill().equals(Color.FIREBRICK))
                    grid.get(i).get(j).nextStateType = CellType.WIRE;

                else if (grid.get(i).get(j).getFill().equals(Color.GOLDENROD) && (nearbyElectronHeads(grid, i, j) == 1 || nearbyElectronHeads(grid, i , j) == 2 ))
                    grid.get(i).get(j).nextStateType = CellType.HEAD;

                else if (grid.get(i).get(j).getFill().equals(Color.GOLDENROD))
                    grid.get(i).get(j).nextStateType = CellType.WIRE;

            }
        }

        for (int i = 0; i < rows; i++) {
            int cols = grid.get(i).size();
            for (int j = 0; j < cols; j++) {

                if(grid.get(i).get(j).nextStateType == CellType.BLANK)
                    grid.get(i).get(j).setFill(Color.gray(0.1));

                if(grid.get(i).get(j).nextStateType == CellType.TAIL)
                    grid.get(i).get(j).setFill(Color.FIREBRICK);

                if(grid.get(i).get(j).nextStateType == CellType.WIRE)
                    grid.get(i).get(j).setFill(Color.GOLDENROD);

                if(grid.get(i).get(j).nextStateType == CellType.HEAD)
                    grid.get(i).get(j).setFill(Color.NAVY);

            }
        }

    }

    private static int nearbyElectronHeads(ArrayList<ArrayList<Cell>> grid, int currentI, int currentJ) {
        int ctr = 0;
        if (currentI >= 1 && currentJ >= 1 && grid.get(currentI-1).get(currentJ-1).getFill().equals(Color.NAVY)) ctr++;
        if (currentI >= 1 && grid.get(currentI-1).get(currentJ).getFill().equals(Color.NAVY)) ctr++;
        if (currentI >= 1 && currentJ < 79 && grid.get(currentI-1).get(currentJ+1).getFill().equals(Color.NAVY)) ctr++;
        if (currentJ >= 1 && grid.get(currentI).get(currentJ-1).getFill().equals(Color.NAVY)) ctr++;
        if (currentJ < 79 && grid.get(currentI).get(currentJ+1).getFill().equals(Color.NAVY)) ctr++;
        if (currentI < 39 && currentJ >= 1 && grid.get(currentI+1).get(currentJ-1).getFill().equals(Color.NAVY)) ctr++;
        if (currentI < 39 && grid.get(currentI+1).get(currentJ).getFill().equals(Color.NAVY)) ctr++;
        if (currentI < 39 && currentJ < 79 && grid.get(currentI+1).get(currentJ+1).getFill().equals(Color.NAVY)) ctr++;

        if(ctr != 0)System.out.println(ctr);
        return ctr;
    }
}
