package com.codurance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyList;

@RunWith(MockitoJUnitRunner.class)
public class WorldShould {

    private World world;
    private List<Cell> initialPopulation;
    @Mock Grid grid;

    @Test public void
    should_be_empty_when_initialised() {
        List<Cell> initialPopulation = new ArrayList<>();
        world = new World(initialPopulation, grid);
        assertThat(world.getPopulation().size(), is(0));
    }

    @Test public void
    be_empty_if_initial_population_is_one_living_cell() {
        initialPopulation = new ArrayList<>();
        Cell livingCell = new Cell("alive");
        initialPopulation.add(livingCell);
        world = new World(initialPopulation, grid);

        given(grid.returnNextGeneration(initialPopulation)).willReturn(anyList());

        world.tick();

        assertThat(world.getPopulation().isEmpty(), is(true));
    }
}