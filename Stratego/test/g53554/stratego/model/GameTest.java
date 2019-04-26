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
import g53554.stratego.model.pieces.Flag;
import  g53554.stratego.model.pieces.General;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;

public class GameTest {

    private final Square[][] defaultBoard = {
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square()}};

    @Before
    public void setUp() throws Exception {
        defaultBoard[0][1].put(new Flag(0, RED));
        defaultBoard[3][2].put(new General(9, RED));
        defaultBoard[4][2].put(new Flag(0, BLUE));
        defaultBoard[4][1].put(new General(9, BLUE));
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

//    @Test
//    public void testIsOverWhenGameBegin() {
//        System.out.println("testIsOverWhenGameBegin");
//        Game instance = new Game();
//        assertTrue(instance.isOver());
//    }

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
        instance.selected = new Position(3, 2);
        List<Move> listMove = new ArrayList<>();
        Move mov = new Move(instance.getSelected(), instance.selected, instance.selected.next(Direction.UP));
        Move mov0 = new Move(instance.getSelected(), instance.selected, instance.selected.next(Direction.DOWN));
        Move mov2 = new Move(instance.getSelected(), instance.selected, instance.selected.next(Direction.LEFT));
        Move mov3 = new Move(instance.getSelected(), instance.selected, instance.selected.next(Direction.RIGHT));
        listMove.add(mov0);
        listMove.add(mov);
        listMove.add(mov2);
        listMove.add(mov3);
        List<Move> expResult = listMove;
        List<Move> result = instance.getMoves();
        assertEquals(expResult.size(), result.size());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenPositionSelectedIsNull() {
        System.out.println("testWhenPositionSelectedIsNull");
        Game instance = new Game();
        instance.selected = null;
        instance.getMoves();

    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenApplyMoveIsNull() {
        System.out.println("testWhenApplyMoveIsNull");
        Game instance = new Game();
        instance.initialize();
        Move move = null;
        instance.apply(move);

    }

    @Test
    public void testWhenApplyTheSquareIsFree() {
        System.out.println("testWhenApplyTheSquareIsFree");
        Game instance = new Game();
        instance.initialize();
        instance.selected = new Position(4, 1);
        Move move = new Move(instance.getSelected(), instance.selected,
                instance.selected.next(Direction.UP));
        instance.apply(move);
        Piece result = new General(9, PlayerColor.BLUE);
        assertEquals(instance.board.getPiece(new Position(3, 1)), result);

    }

    @Test
    public void testWhenApplySquareIsNotFreeAndStronger() {
        System.out.println("testWhenApplyTheSquareIsNotFreeAndStronger");
        Game instance = new Game();
        instance.initialize();
        instance.selected = new Position(3, 2);
        Move move = new Move(instance.getSelected(), instance.selected,
                instance.selected.next(Direction.DOWN));
        instance.apply(move);
        Piece result = new General(9, PlayerColor.RED);
        assertEquals(instance.board.getPiece(new Position(4, 2)), result);

    }

    @Test
    public void testWhenAppltSquareIsNotFreeAndHaveSameRank() {
        System.out.println("testWhenAppltSquareIsNotFreeAndHaveSameRank");
        Game instance = new Game();
        instance.initialize();
        instance.selected = new Position(0, 1);
        Move move = new Move(instance.getSelected(), instance.selected,
                instance.selected.next(Direction.DOWN));
        instance.apply(move);
       
    }
    @Test
    public void testHasMove(){
        System.out.println("testHasMove");
    }
    @Test 
    public void testListWinner(){
        System.out.println("testListWinner");
        Game instance = new Game();
        instance.initialize();
        Player current = instance.current;
        Player oppenet = instance.opponent;
        boolean currentFlag = instance.current.hasFlag();
        boolean oppnentFlag = instance.opponent.hasFlag();
        currentFlag=false;
        oppnentFlag=false;
        List<Player> expResult = new ArrayList<>();
        expResult.add(oppenet);
        expResult.add(current);
        List<Player> result = instance.getWinner();
        result.add(oppenet);
        result.add(oppenet);
        
        assertEquals(expResult, result);
    }
}
