package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class CellLocations {
    private List<Coordinates> cellLocations = new ArrayList();

    public boolean hasLivingCell(Coordinates coordinates) {
        return true;
    }

    public void add(Coordinates coordinates) {
        cellLocations.add(coordinates);
    }
}
