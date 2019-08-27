/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53554.stratego.model;

import g53554.stratego.model.pieces.Bomb;
import g53554.stratego.model.pieces.Eclaireur;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author g53554
 */
public class StockTest {

    /**
     * Test of add method, of class Stock.
     */
    @Test(expected = NullPointerException.class)
    public void testAdd() {
        System.out.println("add");
        Piece piece = null;
        Stock instance = new Stock();
        instance.add(piece);

    }

    @Test
    public void testAddPiece() {
        System.out.println("TestAddPiece");
        Piece piece = new Bomb(PlayerColor.BLUE);
        Stock instance = new Stock();
        instance.add(piece);
        List<Piece> expResult = new ArrayList<>();
        expResult.add(piece);
        List<Piece> result = instance.actives;
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class Stock.
     */
    @Test(expected = NullPointerException.class)
    public void testRemove() {
        System.out.println("remove");
        Piece piece = null;
        Stock instance = new Stock();
        instance.remove(piece);

    }

    @Test(expected = NullPointerException.class)
    public void testRemoveWhenActiveListIsEmpty() {
        System.out.println("remove");
        Piece piece = new Bomb(PlayerColor.BLUE);
        Stock instance = new Stock();
        instance.remove(piece);

    }

    @Test
    public void testRemovePiece() {
        System.out.println("remove");
        Piece piece = new Eclaireur(PlayerColor.BLUE);
        Stock instance = new Stock();
        instance.actives.add(piece);
        instance.remove(piece);
        List<Piece> expResult = new ArrayList<>();
        expResult.add(piece);
        List<Piece> result = instance.inactives;
        assertEquals(expResult, result);

    }

    /**
     * Test of contain method, of class Stock.
     */
    @Test(expected = NullPointerException.class)
    public void testContain() {
        System.out.println("contain");
        Piece piece = null;
        Stock instance = new Stock();
        instance.contain(piece);
    }

    @Test
    public void testContainWhentrue() {
        System.out.println("testContainWhenTrue");
        Piece pice = new Bomb(PlayerColor.BLUE);
        Stock instance = new Stock();
        instance.add(pice);
        boolean expResult = true;
        boolean result = instance.contain(pice);
    }

    /**
     * Test of restore method, of class Stock.
     */
    @Test(expected = NullPointerException.class)
    public void testRestore() {
        System.out.println("restore");
        Piece piece = null;
        Stock instance = new Stock();
        instance.restore(piece);
        
    }
    @Test(expected = NullPointerException.class)
    public void testRestoreWhenPieceIsNotInInactiveList() {
        System.out.println("restore");
        Piece piece = new Bomb(PlayerColor.BLUE);
        Stock instance = new Stock();
        instance.restore(piece);
        
    }
    @Test
    public void testWhenPieceIsRestore(){
        System.out.println("testWhenPieceIsRestore");
        Piece piece = new Bomb(PlayerColor.BLUE);
        Stock instance = new Stock();
        instance.inactives.add(piece);
        int expResult = 1;
        instance.restore(piece);
        int result= instance.actives.size();
        assertEquals(expResult, result);
    }

}
