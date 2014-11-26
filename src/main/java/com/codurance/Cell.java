package com.codurance;

import java.util.List;

public class Cell {

    private String status;

    public Cell(String status) {
        this.status = status;
    }

    public List<Cell> die() {
        status = "dead";
        return null;
    }

    public void live() {
        status = "alive";
    }

    public boolean isNotEmpty() {
        return status.equals("empty");
    }

    public boolean isAlive() {
        return status.equals("alive");
    }

    public boolean isDead() {
        return status.equals("dead");
    }

    public String getStatus() {
        return status;
    }
}
