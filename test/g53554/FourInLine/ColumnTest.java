/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53554.FourInLine;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

/**
 *
 * @author jussy
 */
public class ColumnTest {

    /**
     * Test of isFull method, of class Column.
     */
    @Test
    public void testIsFull() {
        System.out.println("isFull");
        List<Disc> discs = new ArrayList<>();
        discs.add(Disc.RED);
        discs.add(Disc.RED);
        discs.add(Disc.RED);
        discs.add(Disc.RED);
        discs.add(Disc.RED);
        discs.add(Disc.RED);
        Column instance = new Column(discs);
        instance.HEIGHT = 6;
        boolean expResult = true;
        boolean result = instance.isFull();
        assertEquals(expResult, result);
    }

    /**
     * Test of drop method, of class Column.
     */
    @Test
    public void testDrop() {
        System.out.println("drop");
        Disc disc = Disc.RED;
        List<Disc> discs = new ArrayList<>();
        Column instance = new Column(discs);

        instance.drop(disc);

    }

    /**
     * Test of get method, of class Column.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int i = 0;
        List<Disc> discs = new ArrayList<>();
        discs.add(Disc.RED);
        discs.add(Disc.YELLOW);
        Column instance = new Column(discs);
        Disc expResult = Disc.RED;
        Disc result = instance.get(i);
        assertEquals(expResult, result);

    }

    /**
     * Test of isWinning method, of class Column.
     */
    @Test
    public void testIsWinning() {
        System.out.println("isWinning");
        List<Disc> discs = new ArrayList<>();
        discs.add(Disc.RED);
        discs.add(Disc.RED);
        discs.add(Disc.RED);
        discs.add(Disc.RED);
        Column instance = new Column(discs);
        boolean expResult = true;
        boolean result = instance.isWinning();
        assertEquals(expResult, result);

    }
}
