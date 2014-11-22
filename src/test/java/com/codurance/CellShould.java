package com.codurance;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CellShould {

    private Cell cell;

    @Test public void
    be_initialised_with_a_status() {
        cell = new Cell("alive");
        assertThat(cell.getStatus(),is("alive"));

        cell = new Cell("dead");
        assertThat(cell.getStatus(),is("dead"));

        cell = new Cell("empty");
        assertThat(cell.getStatus(),is("empty"));
    }

    @Test public void
    change_status_to_dead() {
        cell = new Cell("alive");
        cell.die();
        assertThat(cell.getStatus(),is("dead"));
    }

    @Test public void
    change_status_to_alive() {
        cell = new Cell("alive");
        cell.live();
        assertThat(cell.getStatus(),is("alive"));
    }

    @Test public void
    know_if_it_is_empty() {
        cell = new Cell("alive");
        assertFalse(cell.isNotEmpty());

        cell = new Cell("empty");
        assertTrue(cell.isNotEmpty());
    }

    @Test public void
    know_if_it_is_alive() {
        cell = new Cell("empty");
        assertFalse(cell.isAlive());

        cell = new Cell("alive");
        assertTrue(cell.isAlive());
    }

    @Test public void
    know_if_it_is_dead() {
        cell = new Cell("empty");
        assertFalse(cell.isDead());

        cell = new Cell("alive");
        assertTrue(cell.isAlive());
    }

}
