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
public class MoveTest {

    @Test
    public void testGetEnd() {
        System.out.println("getEnd");
        Move instance = new Move(new Piece(0, PlayerColor.BLUE), new Position(0, 0), new Position(2, 1));
        Position expResult = new Position(2, 1);
        Position result = instance.getEnd();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetStart() {
        System.out.println("getStart");
        Move instance = new Move(new Piece(0, PlayerColor.BLUE), new Position(3, 0), new Position(2, 1));
        Position expResult = new Position(3, 0);
        Position result = instance.getStart();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetPiece() {
        System.out.println("getPiece");
        Move instance = new Move(new Piece(0, PlayerColor.BLUE), new Position(3, 0), new Position(2, 1));
        Piece expResult = new Piece(0, PlayerColor.BLUE);
        Piece result = instance.getPiece();
        assertEquals(expResult, result);

    }

}
