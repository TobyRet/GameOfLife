package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class World {

    private List<Cell> population = new ArrayList<>();

    public static World empty() {
        return new World();
    }

    public boolean isEmpty() {
        return population.size() == 0;
    }
}
