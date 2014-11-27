package com.codurance;

public class LivingCell implements Cell {
    private final Coordinates coordinates;

    public LivingCell(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }
}
