package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class World {

    private List<Cell> population = new ArrayList<>();
    private CellLocations cellLocations;

    public static World empty() {
        CellLocations cellLocations = new CellLocations();
        return new World(cellLocations);
    }

    public World(CellLocations cellLocations) {
        this.cellLocations = cellLocations;
    }

    public boolean isEmpty() {
        return population.size() == 0;
    }

    public void tick() {

    }

    public void createLivingCell(Coordinates coordinates) {
        LivingCell livingCell = new LivingCell(coordinates);
        population.add(livingCell);
    }

    public boolean hasLivingCell(Coordinates coordinates) {
        return cellLocations.hasLivingCell(coordinates);
    }
}
