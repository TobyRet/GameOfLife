package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class World {

    private List<Position> livingCellPositions = new ArrayList<>();
    private Grid grid;

    public World(Grid grid) {
        this.grid = grid;
    }

    public boolean isEmpty() {
        return livingCellPositions.isEmpty();
    }

    public void setAlive(Position position) {
        livingCellPositions.add(position);
    }

    public boolean isAliveAt(Position position) {
        return livingCellPositions.stream()
                                        .anyMatch(livingCell -> livingCell.equals(position));
    }

    public void tick() {
        livingCellPositions = grid.getNextGeneration(livingCellPositions);
    }
}
