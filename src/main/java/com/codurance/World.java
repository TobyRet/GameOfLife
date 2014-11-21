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
//        killCellsIfPopulationTooLow();
        killCellIfItDoesNotHaveLivingNeighbours();
    }

    private void killCellIfItDoesNotHaveLivingNeighbours() {
        for(Cell cell : population) {
            if(cell.notEmpty()) {
                if(!grid.checkCellHasLivingNeighbours(cell, population)){
                    cell.dead();
                }
            }
        }
    }

    private void killCellsIfPopulationTooLow() {
        if(population.size() == 1 || population.size() == 2) {
            for(Cell cell : population) {
                cell.dead();
            }
        }
    }
}