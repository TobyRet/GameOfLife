package com.codurance;

import org.junit.Before;
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
public class GridShould {

    @Mock Cell cell;
    private Grid grid;

    @Before
    public void initialise() {
        grid = new Grid();
    }

    @Test public void
    know_who_a_cells_row_neighbours_are_for_xcoord_equals_1() {
        List<Integer> rowNeighbours = new ArrayList<>();
        rowNeighbours.add(2);

        given(cell.getXCoordinate()).willReturn(1);

        assertThat(grid.getRowNeighbours(cell), is(rowNeighbours));
    }

    @Test public void
    know_who_a_cells_row_neighbours_are_for_xcoord_equals_2() {
        List<Integer> rowNeighbours = new ArrayList<>();
        rowNeighbours.add(1);
        rowNeighbours.add(3);

        given(cell.getXCoordinate()).willReturn(2);

        assertThat(grid.getRowNeighbours(cell), is(rowNeighbours));
    }

    @Test public void
    know_who_cells_row_neighbours_are_for_xcoord_equals_4() {
        List<Integer> rowNeighbours = new ArrayList<>();
        rowNeighbours.add(5);

        given(cell.getXCoordinate()).willReturn(4);

        assertThat(grid.getRowNeighbours(cell), is(rowNeighbours));
    }


}
