package com.codurance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Population {

    private List<Cell> population = new ArrayList();

    public boolean isEmpty() {
        return population.size() == 0;
    }

    public void add(LivingCell livingCell) {
        population.add(livingCell);
    }

    public void regenerate() {
        Iterator<Cell> i = population.iterator();
        while(i.hasNext()) {
            Cell cell = i.next();
            if(!cell.canSurvive()) {
                i.remove();
            }
        }
    }
}

