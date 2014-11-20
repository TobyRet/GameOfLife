package com.codurance;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WorldShould {

    private World world;

    @Before
    public void initialise() {
        world = new World();
    }
    
    @Test public void
    should_be_empty_when_initialised() {
        assertThat(world.getPopulation().size(), is(0));
    }

    @Test public void
    should_be_empty_when_regenerated_if_there_is_only_one_live_cell() {
        assertThat(, is());
    }
}