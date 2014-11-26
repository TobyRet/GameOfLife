package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private final int ROW_NUMBER_UPPER = 3;
    private final int ROW_NUMBER_LOWER = 1;
//    private final int COLUMN_MAX = 3;
//    private final int COLUMN_MIN = 1;

    public List<Cell> returnNextGeneration(List<Cell> livingCells) {
        return livingCells;
    }

    public List<Integer> getRowNeighbours(Cell cell) {
        Integer xCoordinate = cell.getXCoordinate();
        List<Integer> rowNeighbours = new ArrayList<>();

        calculateNeighbourLeft(xCoordinate, rowNeighbours);
        calculateNeighbourRight(xCoordinate, rowNeighbours);

        return rowNeighbours;
    }

    private void calculateNeighbourLeft(Integer xCoordinate, List<Integer> rowNeighbours) {
        if(xCoordinate > lowerRowPosition(xCoordinate)) {
            rowNeighbours.add(xCoordinate - 1);
        }
    }

    private void calculateNeighbourRight(Integer xCoordinate, List<Integer> rowNeighbours) {
        if(xCoordinate < upperRowPosition(xCoordinate)) {
            rowNeighbours.add(xCoordinate + 1);
        }
    }

    private int lowerRowPosition(Integer xCoordinate) {
        return (ROW_NUMBER_LOWER + ((xCoordinate / ROW_NUMBER_UPPER) * ROW_NUMBER_UPPER));
    }


    private int upperRowPosition(Integer xCoordinate) {
        return (ROW_NUMBER_UPPER + ((xCoordinate / ROW_NUMBER_UPPER) * ROW_NUMBER_UPPER));
    }
}
