package com.codurance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class WorldShould {

    @Test public void
    world_should_be_empty_when_created() {
        World world = World.empty();
        assertThat(world.isEmpty(), is(true));
    }

}