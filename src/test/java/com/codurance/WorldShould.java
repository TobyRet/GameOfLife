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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WorldShould {

    private World world;
    private List<Cell> initialPopulation;
    @Mock Grid grid;
    @Mock Cell cell;

    @Test public void
    should_be_empty_when_initialised() {
        List<Cell> initialPopulation = new ArrayList<>();
        world = new World(initialPopulation, grid);
        assertThat(world.getPopulation().size(), is(0));
    }


    @Test public void
    kill_cell_if_initial_population_size_is_1() {
        createCells(1);
        world = new World(initialPopulation, grid);
        given(cell.notEmpty()).willReturn(true);
        given(grid.checkCellHasLivingNeighbours(cell, world.getPopulation())).willReturn(false);
        world.tick();
        verify(cell,times(1)).dead();
    }

    @Test public void
    cell_lives_to_next_generation_if_it_has_two_living_neighbours() {
        createCells(4);
        world = new World(initialPopulation, grid);
        given(cell.notEmpty()).willReturn(true, true, true, false);
        given(grid.checkCellHasLivingNeighbours(cell, world.getPopulation())).willReturn(true, true, true);
        world.tick();
        assertThat(world.getPopulation(), is(initialPopulation));
    }

    @Test public void
    cell_does_not_live_to_the_next_generation_if_it_does_not_have_two_living_neighbours() {
        createCells(9);
        world = new World(initialPopulation, grid);
        given(cell.notEmpty()).willReturn(true, true, true, false, false, false, false, false, false);
        given(grid.checkCellHasLivingNeighbours(cell, world.getPopulation())).willReturn(false, false, false);
        world.tick();
        verify(cell, times(3)).dead();
    }

    private void createCells(int number) {

        initialPopulation = new ArrayList<>();
        for(int i=0; i<number; i++) {
            initialPopulation.add(cell);
        }
    }

}