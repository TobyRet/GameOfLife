package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class World {

    List<Position> livingCellPositions = new ArrayList<>();

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
}
