package com.codurance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WorldShould {

    private World world;
    @Mock Cell cell;
    private List<Cell> initialPopulation;

    @Before
    public void initialise() {
    }

    @Test public void
    should_be_empty_when_initialised() {
        List<Cell> initialPopulation = new ArrayList<>();
        world = new World(initialPopulation);
        assertThat(world.getPopulation().size(), is(0));
    }

    @Test public void
    kill_cell_if_it_does_not_have_any_neighbours() {
        createCells(1);
        world = new World(initialPopulation);
        assertThat(world.getPopulation().size(), is(1));
        world.tick();
        verify(cell).dead();
    }

    @Test public void
    kill_cells_if_population_size_is_2() {
        createCells(2);
        world = new World(initialPopulation);
        assertThat(world.getPopulation().size(), is(2));
        world.tick();
        verify(cell,times(2)).dead();
    }

    private void createCells(int number) {

        initialPopulation = new ArrayList<>();
        for(int i=0; i<number; i++) {
            initialPopulation.add(cell);
        }
    }


}