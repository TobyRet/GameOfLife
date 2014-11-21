package com.codurance;

import java.util.List;

public class World {

    private List<Cell> population;

    public World(List<Cell> initialPopulation) {
        this.population = initialPopulation;
    }

    public List<Cell> getPopulation() {
        return population;
    }

    public void tick() {
        if(population.size() == 1 || population.size() == 2) {
            for(Cell cell : population) {
                cell.dead();
            }
        }
    }
}