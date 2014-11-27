package com.codurance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class WorldShould {

    private static final Position LIVING_POSITION = new Position(2, 3);
    private static final Position ANOTHER_LIVING_POSITION = new Position(2, 4);
    private static final Position NON_LIVING_CELL = new Position(1, 3);

    private static final Position ADJACENT_CELL_1 = LIVING_POSITION;
    private static final Position ADJACENT_CELL_2 = ANOTHER_LIVING_POSITION;
    private static final Position ADJACENT_CELL_3 = new Position(2,5);

    private World world;
    @Mock Grid grid;

    @Before
    public void initialise() {
        world = new World(grid);
    }

    @Test public void
    be_empty_when_created() {
        assertThat(world.isEmpty(), is(true));
    }

    @Test public void
    not_be_empty_after_setting_a_cell_to_live() {
        world.setAlive(LIVING_POSITION);

        assertThat(world.isEmpty(), is(false));
    }

    @Test public void
    confirm_a_cell_is_living_after_making_it_alive() {
        world.setAlive(LIVING_POSITION);
        world.setAlive(ANOTHER_LIVING_POSITION);

        assertThat(world.isAliveAt(LIVING_POSITION), is(true));
        assertThat(world.isAliveAt(ANOTHER_LIVING_POSITION), is(true));
        assertThat(world.isAliveAt(NON_LIVING_CELL), is(false));
    }

    @Test public void
    stay_empty_after_a_tick() {
        world.tick();

        assertThat(world.isEmpty(), is(true));
    }

    @Test public void
    be_empty_after_a_tick_with_one_living_cell() {
        world.setAlive(LIVING_POSITION);

        List<Position> nextGenerationCellPositions = new ArrayList();

        given(grid.getNextGeneration(Matchers.anyListOf(Position.class))).willReturn(nextGenerationCellPositions);

        world.tick();

        assertThat(world.isEmpty(), is(true));
        assertThat(world.isAliveAt(LIVING_POSITION), is(false));
    }

    @Test public void
    not_be_empty_after_a_tick_with_three_living_adjacent_cells() {
        world.setAlive(ADJACENT_CELL_1);
        world.setAlive(ADJACENT_CELL_2);
        world.setAlive(ADJACENT_CELL_3);

        List<Position> nextGenerationCellPositions = new ArrayList();
        nextGenerationCellPositions.add(new Position(1, 4));
        nextGenerationCellPositions.add(new Position(2, 4));
        nextGenerationCellPositions.add(new Position(3, 4));

        given(grid.getNextGeneration(Matchers.anyListOf(Position.class))).willReturn(nextGenerationCellPositions);

        world.tick();

        assertThat(world.isEmpty(), is(false));
        assertThat(world.isAliveAt(ADJACENT_CELL_1), is(false));
        assertThat(world.isAliveAt(ADJACENT_CELL_2), is(true));
        assertThat(world.isAliveAt(ADJACENT_CELL_3), is(false));
    }
}