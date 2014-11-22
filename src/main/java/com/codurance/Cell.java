package com.codurance;

public class Cell {

    private String status;

    public Cell(String status) {
        this.status = status;
    }

    public void die() {
        status = "dead";
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
