package com.codurance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WorldShould {

    private World world;
    private Coordinates coordinates;

    @Test public void
    be_empty_when_created() {
        CellLocations cellLocations = new CellLocations();
        Population population = new Population();

        world = new World(cellLocations, population);
        assertThat(world.isEmpty(), is(true));
    }

    @Test public void
    create_living_cells() {
        CellLocations cellLocations = mock(CellLocations.class);
        Population population = new Population();

        world = new World(cellLocations, population);

        coordinates = new Coordinates(3,3);
        world.createLivingCell(coordinates);

        verify(cellLocations).add(coordinates);
        given(cellLocations.hasLivingCell(coordinates)).willReturn(true);

        assertThat(world.isEmpty(), is(false));
        assertThat(world.hasLivingCell(coordinates), is(true));
    }

    @Test public void
    regenerate_the_population() {
        CellLocations cellLocations = mock(CellLocations.class);
        Population population = mock(Population.class);

        given(population.isEmpty()).willReturn(true);

        world = new World(cellLocations, population);
        world.createLivingCell(coordinates);

        world.tick();

        assertThat(world.isEmpty(), is(true));
    }

}