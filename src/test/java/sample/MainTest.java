package sample;

import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void test() {
        Moves moves = new Moves();
        moves.point(8, 8);
        assertFalse(moves.emptyPoint(8, 8)); // Появилась ли фишка на пересечении(8,8)
    }

    @Test
    public void test2() {
        Moves moves = new Moves();
        moves.point(8,8);
        moves.point(9,9);
        moves.point(10,10);
        moves.point(7,7);
        moves.point(6,6);
        moves.winGame(9,9);
        assertTrue(moves.isVictory()); // Победа по диагонали
    }

    @Test
    public void test3() {
        Moves moves = new Moves();
        moves.point(4,2);
        moves.changePlayer();
        moves.point(5,8);
        moves.point(5,9);
        moves.point(5,10);
        moves.point(5,7);
        moves.point(5,6);
        moves.winGame(5,7);
        assertTrue(moves.isVictory()); // Победа по вертикали
    }

    @Test
    public void test4() {
        Moves moves = new Moves();
        moves.point(4,2);
        moves.changePlayer();
        moves.point(5,8);
        moves.point(5,9);
        moves.point(5,10);
        moves.point(5,7);
        moves.changePlayer();
        moves.point(5,6);
        moves.winGame(5,7);
        assertFalse(moves.isVictory()); // Пять фишек в ряд, но не одного цвета
    }
}