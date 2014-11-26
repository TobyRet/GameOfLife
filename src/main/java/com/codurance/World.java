package com.codurance;

import java.util.List;

public class World {
    private final Grid grid;
    private List<Cell> population;

    public World(List<Cell> initialPopulation, Grid grid) {
        this.population = initialPopulation;
        this.grid = grid;
    }

    public void tick() {
        population = grid.returnNextGeneration(population);
    }

    public List<Cell> getPopulation() {
        return population;
    }
}
