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

@RunWith(MockitoJUnitRunner.class)
public class WorldShould {

    private World world;
    @Mock Grid grid;
    @Mock Cell cell;
    @Mock LivingCells livingCells;

    @Test public void
    should_have_a_population_of_zero_if_initialised_with_one_living_cell() {
        List<Cell> livingCells = new ArrayList();
        livingCells.add(cell);

        List<Cell> nextGeneration = new ArrayList();

        world  = new World(livingCells, grid);

        given(grid.returnNextGeneration(livingCells)).willReturn(nextGeneration);

        world.tick();

        assertThat(world.getPopulation().isEmpty(), is(true));
    }
}