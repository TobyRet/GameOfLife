package com.codurance;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class PopulationShould {

    @Test public void
    regenerate_the_population() {
        Population population = new Population();
        LivingCell mockedCell = mock(LivingCell.class);

        given(mockedCell.canSurvive()).willReturn(false);
        population.add(mockedCell);
        population.regenerate();
        assertThat(population.isEmpty(), is(true));
    }
}
