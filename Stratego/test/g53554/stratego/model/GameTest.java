package g53554.stratego.model;

import static g53554.stratego.model.PlayerColor.BLUE;
import static g53554.stratego.model.PlayerColor.RED;
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
        Position selectioner= new Position(3, 2);
        List<Move> listMove = new ArrayList<>();
        Move mov = new Move(instance.getSelected(), selectioner, selectioner.next(Direction.UP)); 
        Move mov1 = new Move(instance.getSelected(), selectioner, selectioner.next(Direction.DOWN));
        Move mov2 = new Move(instance.getSelected(), selectioner, selectioner.next(Direction.LEFT));
        Move mov3 = new Move(instance.getSelected(), selectioner, selectioner.next(Direction.RIGHT));
        listMove.add(mov);
        listMove.add(mov1);
        listMove.add(mov2);
        listMove.add(mov3);
        List<Move> expResult = listMove;
        List<Move> result = instance.getMoves();
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenPositionSelectedIsNull() {
        System.out.println("testWhenPositionSelectedIsNull");
        Game instance = new Game();
        instance.selected = null;
        instance.getMoves();

    }

}
