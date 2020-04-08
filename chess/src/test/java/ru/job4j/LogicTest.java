package ru.job4j;

import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LogicTest {

    @AfterClass
    public static void setup() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    public static void cleanup() {
        PrintStream def = System.out;
        System.setOut(def);
    }

    @Test
    public void addTest() {
        Logic logic = new Logic();
        Cell position = Cell.C1;
        BishopBlack bishopBlack = new BishopBlack(position);
        logic.add(bishopBlack);
        Assert.assertThat(logic.toString(), Matchers.containsString(bishopBlack.toString()));
    }

    @Test
    public void cleanTest() {
        Logic logic = new Logic();
        Cell position1 = Cell.C1;
        Cell position2 = Cell.C2;
        BishopBlack bishopBlack1 = new BishopBlack(position1);
        BishopBlack bishopBlack2 = new BishopBlack(position2);
        logic.add(bishopBlack1);
        logic.add(bishopBlack2);
        logic.clean();
        System.out.println(logic.toString());
        Assert.assertThat(logic.toString(), Matchers.containsString("Logic{figures=[null, null, null, null, null, null, null"));
    }

    @Test
    public void moveTestFalse() {
        Logic logic = new Logic();
        Cell position1 = Cell.C1;
        Cell position2 = Cell.G5;
        BishopBlack bishopBlack1 = new BishopBlack(position1);
        BishopBlack bishopBlack2 = new BishopBlack(position2);
        logic.add(bishopBlack1);
        logic.add(bishopBlack2);
        boolean rsl = logic.move(position1, position2);
        Assert.assertFalse(rsl);
    }

    @Test
    public void moveTestTrue() {
        Logic logic = new Logic();
        Cell position1 = Cell.C1;
        Cell position2 = Cell.G5;
        BishopBlack bishopBlack1 = new BishopBlack(position1);
        logic.add(bishopBlack1);
        boolean rsl = logic.move(position1, position2);
        Assert.assertTrue(rsl);
    }
}
