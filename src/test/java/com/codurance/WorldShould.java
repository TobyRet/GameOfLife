package com.codurance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class WorldShould {

    private World world;

    @Before
    public void initialise() {
        world = new World();
    }

    @Test public void
    be_empty_when_created() {
        assertThat(world.isEmpty(), is(true));
    }

    @Test public void
    not_be_empty_after_setting_a_cell_to_live() {
        world.setAlive(new Position(1,2));

        assertThat(world.isEmpty(), is(false));
    }

    @Test public void
    confirm_a_cell_is_living_after_making_it_alive() {
        Position livingPosition = new Position(2,3);
        Position anotherLivingPosition = new Position(2,4);
        Position nonLivingPosition = new Position(1,3);

        world.setAlive(livingPosition);
        world.setAlive(anotherLivingPosition);

        assertThat(world.isAliveAt(livingPosition), is(true));
        assertThat(world.isAliveAt(anotherLivingPosition), is(true));
        assertThat(world.isAliveAt(nonLivingPosition), is(false));
    }
}