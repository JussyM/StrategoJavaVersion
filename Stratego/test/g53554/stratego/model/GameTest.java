package g53554.stratego.model;

import static g53554.stratego.model.PlayerColor.BLUE;
import static g53554.stratego.model.PlayerColor.RED;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private final Square[][] defaultBoard = {
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()}};

    @Before
    public void setUp() throws Exception {
        defaultBoard[0][1].put(new Piece(0, RED));
        defaultBoard[3][2].put(new Piece(9, RED));
        defaultBoard[4][2].put(new Piece(0, BLUE));
        defaultBoard[4][1].put(new Piece(9, BLUE));
    }

    @Test
    public void testInitialize() {
        System.out.println("initialize");
        Game instance = new Game();
        instance.initialize();
        Square[][] result = instance.getBoard();
        assertArrayEquals(defaultBoard, result);
    }

    @Test(expected = IllegalStateException.class)
    public void testStartWhenNoBoard() {
        System.out.println("testStartWhenNoBoard");
        Game instance = new Game();
        instance.start();
    }

    @Test
    public void testStartWhenInsitializeDone() {
        System.out.println("testStartWhenInsitializeDone");
        Game instance = new Game();
        instance.initialize();
        instance.start();
        assertFalse(instance.isOver());
    }

    @Test
    public void testIsOverWhenGameBegin() {
        System.out.println("testIsOverWhenGameBegin");
        Game instance = new Game();
        assertFalse(instance.isOver());
    }

    @Test
    public void testGetBoardWhenGameBegin() {
        System.out.println("testGetBoardWhenGameBegin");
        Game instance = new Game();
        instance.initialize();
        Square[][] expResult = defaultBoard;
        Square[][] result = instance.getBoard();
        assertArrayEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSelectWhenIsOutOfTheBoard() {
        System.out.println("testSelectWhenIsOutOfTheBoard");
        int row = 6;
        int column = 4;
        Game instance = new Game();
        instance.initialize();
        instance.select(row, column);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSelectWhenSquareIsNull() {
        System.out.println("testSelectWhenSquareIsNull");
        int row = 0;
        int column = 0;
        Game instance = new Game();
        instance.initialize();
        instance.select(row, column);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSelectWhenSquareIsToken() {
        System.out.println("testSelectWhenSquareIsToken");
        int row = 4;
        int column = 1;
        Game instance = new Game();
        instance.initialize();
        instance.select(row, column);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetSelecedtestWhenThePositionIsOutOfTheBoard() {
        System.out.println("testGetSelectedWhenThePositionIsOutOfTheBoard");
        Game instance = new Game();
        instance.initialize();
        instance.select(6, 2);
        instance.getSelected();

    }

    @Test
    public void testGetSelectedReturnPiece() {
        System.out.println("testGetSelectedReturnPiece");
        Game instance = new Game();
        instance.initialize();
        Piece expResult = instance.board.getPiece(new Position(4, 1));
        instance.selected = new Position(4, 1);
        Piece Result = instance.getSelected();
        assertEquals(expResult, Result);

    }

    @Test
    public void testGetMoves() {
        System.out.println("getMoves");
        Game instance = new Game();
        instance.initialize();
        instance.selected = new Position(4, 1);
        Move dep = new Move(new Piece(0, BLUE), instance.selected, instance.selected.next(Direction.LEFT));
        List<Move> listMove = new ArrayList<>();
        listMove.add(dep);
        List<Move> expResult = listMove;
        List<Move> result = instance.getMoves();
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenDirectionIsNotAvailable() {
        System.out.println("testWhenDirectionIsNotAvailable");
        Game instance = new Game();
        instance.getMoves();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenPositionSelectedIsNull() {
        System.out.println("testWhenPositionSelectedIsNull");
        Game instance = new Game();    
        instance.selected = null;
        instance.getMoves();

    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenTheNextPositionIsNotAvailaible() {
        System.out.println("testWhenTheNextPositionIsNotAvailaible");
        Game instance = new Game();
        instance.initialize();
        instance.selected = new Position(5, 6);
        instance.selected.next(Direction.DOWN);
        instance.getMoves();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenTheNextPostionIsFree() {
        System.out.println("testWhenTheNextPostionIsFree");
        Game instance = new Game();
        instance.initialize();
        instance.board.isFree(instance.selected = new Position(0, 0));
        instance.getMoves();
    }

}
