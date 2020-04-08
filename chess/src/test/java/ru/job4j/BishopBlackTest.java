package ru.job4j;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest {

    @Test
    public void positionTest() {
        Cell position = Cell.B1;
        BishopBlack bishop = new BishopBlack(position);
        Cell rsl = bishop.position();
        Assert.assertEquals(position, rsl);
    }

    @Test
    public void copyTest() {
        Cell destPosition = A3;
        Cell sourcePosition = C1;
        BishopBlack bishop = new BishopBlack(sourcePosition);
        Figure figure = bishop.copy(destPosition);
        Cell rsl = figure.position();
        Assert.assertEquals(destPosition, rsl);
    }

    @Test
    public void wayTest() {
        Cell destPosition = G5;
        Cell sourcePosition = C1;
        BishopBlack bishop = new BishopBlack(sourcePosition);
        Cell[] rsl = bishop.way(sourcePosition, destPosition);
        Cell[] expected = {D2, E3, F4, G5};
        for (int i = 0; i < rsl.length; i++) {
            Assert.assertEquals(expected[i], rsl[i]);
        }
    }

    @Test
    public void diagonalTestTrue() {
        Cell destPosition = A6;
        Cell sourcePosition = F1;
        BishopBlack bishop = new BishopBlack(sourcePosition);
        boolean rsl = bishop.isDiagonal(sourcePosition, destPosition);
        Assert.assertTrue(rsl);
    }

    @Test
    public void diagonalTestFalse() {
        Cell destPosition = G5;
        Cell sourcePosition = F2;
        BishopBlack bishop = new BishopBlack(sourcePosition);
        boolean rsl = bishop.isDiagonal(sourcePosition, destPosition);
        Assert.assertFalse(rsl);
    }
}
