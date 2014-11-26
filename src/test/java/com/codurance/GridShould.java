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
    private List<Integer> rowNeighbours;
    private List<Integer> columnNeighbours;

    @Before
    public void initialise() {
        grid = new Grid();
        rowNeighbours = new ArrayList<>();
        columnNeighbours = new ArrayList<>();
    }

    @Test public void
    know_who_a_cells_row_neighbours_are_for_xcoord_equals_1() {
        rowNeighbours.add(2);

        given(cell.getXCoordinate()).willReturn(1);

        assertThat(grid.getRowNeighbours(cell), is(rowNeighbours));
    }

    @Test public void
    know_who_a_cells_row_neighbours_are_for_xcoord_equals_2() {
        rowNeighbours.add(1);
        rowNeighbours.add(3);

        given(cell.getXCoordinate()).willReturn(2);

        assertThat(grid.getRowNeighbours(cell), is(rowNeighbours));
    }

    @Test public void
    know_who_cells_row_neighbours_are_for_xcoord_equals_4() {
        rowNeighbours.add(5);

        given(cell.getXCoordinate()).willReturn(4);

        assertThat(grid.getRowNeighbours(cell), is(rowNeighbours));
    }

    @Test public void
    knows_who_a_cells_column_neighbours_are_for_y_coord_equals_1() {
        assertThat(, is());
    }


}
