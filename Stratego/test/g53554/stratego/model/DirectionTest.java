/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53554.stratego.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jussy
 */
public class DirectionTest {

    @Test
    public void testValues() {
        System.out.println("values");
        Direction[] expResult = Direction.values();
        Direction[] result = Direction.values();
        assertArrayEquals(expResult, result);

    }

    @Test
    public void testGetRow() {
        System.out.println("getRow");
        Direction instance = Direction.DOWN;
        int expResult = 1;
        int result = instance.getRow();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        Direction instance = Direction.DOWN;
        int expResult = 0;
        int result = instance.getColumn();
        assertEquals(expResult, result);

    }

}
