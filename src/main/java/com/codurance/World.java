package com.codurance;

public class World {

    private Population population;
    private CellLocations cellLocations;

    public World(CellLocations cellLocations, Population population) {
        this.cellLocations = cellLocations;
        this.population = population;
    }

    public boolean isEmpty() {
        return population.isEmpty();
    }

    public void tick() {
        population.regenerate();
    }

    public void createLivingCell(Coordinates coordinates) {
        LivingCell livingCell = new LivingCell(coordinates);
        population.add(livingCell);
        cellLocations.add(coordinates);
    }

    public boolean hasLivingCell(Coordinates coordinates) {
        return cellLocations.hasLivingCell(coordinates);
    }
}
