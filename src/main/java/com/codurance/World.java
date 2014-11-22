package com.codurance;

import java.util.List;

public class World {

    private Grid grid;
    private List<Cell> population;

    public World(List<Cell> initialPopulation, Grid grid) {
        this.population = initialPopulation;
        this.grid = grid;
    }

    public List<Cell> getPopulation() {
        return population;
    }

    public void tick() {
        determineIfCellCanSurvuve();
    }

    private void determineIfCellCanSurvuve() {
        population.stream().filter(cell -> cell.isNotEmpty()).forEach(cell -> {
            if (!grid.checkCellCanSurvive(cell, population)) {
                cell.die();
            }
        });
    }
}