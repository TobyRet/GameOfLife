package com.codurance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class WorldShould {

    private World world;
    private Coordinates mockedCoordinateObject;

    @Before
    public void initialise() {
        world = World.empty();
    }

    @Test public void
    be_empty_when_created() {
        assertThat(world.isEmpty(), is(true));
    }

    @Test public void
    be_empty_in_next_generation() {
        world.tick();
        assertThat(world.isEmpty(), is(true));
    }

    @Test public void
    can_create_living_cells() {
        mockedCoordinateObject = mock(Coordinates.class);
        CellLocations cellLocations = mock(CellLocations.class);

        given(cellLocations.hasLivingCell(mockedCoordinateObject)).willReturn(true);

        World world = new World(cellLocations);

        world.createLivingCell(mockedCoordinateObject);

        assertThat(world.isEmpty(), is(false));
        assertThat(world.hasLivingCell(mockedCoordinateObject), is(true));
    }

    

}