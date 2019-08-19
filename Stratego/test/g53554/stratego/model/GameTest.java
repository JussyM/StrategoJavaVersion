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
import g53554.stratego.model.pieces.General;
import g53554.stratego.model.pieces.Bomb;
import g53554.stratego.model.pieces.Eclaireur;
import g53554.stratego.model.pieces.Spy;
import g53554.stratego.model.pieces.Maréchal;
import g53554.stratego.model.pieces.Miner;
import static org.junit.Assert.assertTrue;

public class GameTest {

    private final Square[][] newDefaultBoard = {
        {new Square(SquareType.LAND), new Square(SquareType.LAND), 
            new Square(SquareType.LAND),
            new Square(SquareType.LAND), new Square(SquareType.LAND)},
        {new Square(SquareType.LAND), new Square(SquareType.LAND), 
            new Square(SquareType.LAND),
            new Square(SquareType.LAND), new Square(SquareType.LAND)},
        {new Square(SquareType.WATER), new Square(SquareType.WATER), 
            new Square(SquareType.WATER),
            new Square(SquareType.LAND), new Square(SquareType.LAND)},
        {new Square(SquareType.LAND), new Square(SquareType.LAND), 
            new Square(SquareType.LAND),
            new Square(SquareType.LAND), new Square(SquareType.LAND)},
        {new Square(SquareType.LAND), new Square(SquareType.LAND), 
            new Square(SquareType.LAND),
            new Square(SquareType.LAND), new Square(SquareType.LAND)},
        {new Square(SquareType.LAND), new Square(SquareType.LAND),
            new Square(SquareType.LAND),
            new Square(SquareType.LAND), new Square(SquareType.LAND)}};

    @Before
    public void setUp() throws Exception {
        newDefaultBoard[0][1].put(new Flag(RED));
        newDefaultBoard[3][2].put(new General(RED));
        newDefaultBoard[4][2].put(new Flag(BLUE));
        newDefaultBoard[4][1].put(new General(BLUE));
        newDefaultBoard[1][0].put(new Bomb(RED));
        newDefaultBoard[1][2].put(new Miner(RED));
        newDefaultBoard[5][1].put(new Maréchal(RED));
        newDefaultBoard[0][0].put(new Spy(RED));
        newDefaultBoard[3][1].put(new Bomb(BLUE));
        newDefaultBoard[2][0].put(new Miner(BLUE));
        newDefaultBoard[2][4].put(new Maréchal(BLUE));
        newDefaultBoard[0][3].put(new Spy(BLUE));
        newDefaultBoard[0][2].put(new Eclaireur(BLUE));
        newDefaultBoard[0][4].put(new Eclaireur(RED));

    }

    @Test
    public void testInitialize() {
        System.out.println("initialize");
        Game instance = new Game();
        instance.initialize();
        Square[][] result = instance.getBoard();
        assertArrayEquals(newDefaultBoard, result);
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
        assertTrue(instance.isOver());
    }

    @Test
    public void testGetBoardWhenGameBegin() {
        System.out.println("testGetBoardWhenGameBegin");
        Game instance = new Game();
        instance.initialize();
        Square[][] expResult = newDefaultBoard;
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
        int row = 5;
        int column = 3;
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
        Piece expResult = newDefaultBoard[3][2].getPiece();
        instance.select(3, 2);
        Piece Result = instance.getSelected();
        assertEquals(expResult, Result);

    }

    @Test
    public void testGetMovesWhenNbStepIsZero() {
        System.out.println("testGetMovesWhenNbStepIsZero");
        Game instance = new Game();
        instance.initialize();
        instance.select(0, 1);
        List<Move> expResult = new ArrayList<>();
        List<Move> result = instance.getMoves();
        assertEquals(expResult.size(), result.size());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenPositionSelectedIsNull() {
        System.out.println("testWhenPositionSelectedIsNull");
        Game instance = new Game();
        instance.initialize();
        Position position = new Position(7, 5);
        instance.select(position.getRow(), position.getColumn());

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
        instance.select(0, 1);
        Position position = new Position(0, 1);
        Move move = new Move(instance.getSelected(), position,
                position.next(Direction.DOWN));
        Piece result = instance.getSelected();
        instance.apply(move);
        Piece expResult = new Flag(PlayerColor.RED);
        assertEquals(expResult, result);

    }

    @Test
    public void testWhenApplySquareIsNotFreeAndStronger() {
        System.out.println("testWhenApplyTheSquareIsNotFreeAndStronger");
        Game instance = new Game();
        instance.initialize();
        instance.select(3, 2);
        Position position = new Position(3, 2);
        Move move = new Move(instance.getSelected(), position,
                position.next(Direction.DOWN));
        Piece result = instance.getSelected();
        instance.apply(move);
        Piece expResult = new General(RED);
        assertEquals(expResult, result);

    }

    @Test
    public void testWhenAppltSquareIsNotFreeAndHaveSameRank() {
        System.out.println("testWhenAppltSquareIsNotFreeAndHaveSameRank");
        Game instance = new Game();
        instance.initialize();
        instance.select(0, 4);
        Position position = new Position(0, 4);
        Move move =new Move(
                instance.getSelected(), 
                position, 
                position.next(Direction.LEFT).next(Direction.LEFT));
        Piece expResult = null;
        instance.apply(move);
        Piece result = instance.getSelected();
        assertEquals(expResult, result);

    }

    @Test
    public void testHasMove() {
        System.out.println("testHasMove");
        Game instance = new Game();
        instance.initialize();
        assertTrue(instance.hasMoves(instance.getcurrent()));
    }

    @Test
    public void testListWinner() {
        System.out.println("testListWinner");
        Game instance = new Game();
        instance.initialize();
        List<Player> expResult = new ArrayList<>();
        expResult.add(instance.getWinner().get(0));
        expResult.add(instance.getWinner().get(1));
        List<Player> result = instance.getWinner();
        assertEquals(expResult, result);
    }

    @Test
    public void testMoveWhenNbPieceIsOne() {
        System.out.println("testMoveWhenNbPieceIsOne");
        Game instance = new Game();
        instance.initialize();
        instance.select(3, 2);
        Position position = new Position(3, 2);
        Move move1 = new Move(instance.getSelected(),
                position, position.next(Direction.DOWN));
        Move move2 = new Move(instance.getSelected(),
                position, position.next(Direction.LEFT));
        Move move3 = new Move(instance.getSelected(),
                position, position.next(Direction.RIGHT));
        List<Move> expResult = new ArrayList<>();
        expResult.add(move3);
        expResult.add(move2);
        expResult.add(move1);
        List<Move> result = instance.getMoves();
        assertEquals(expResult.size(), result.size());

    }

    @Test
    public void testMoveWhenNbPieceIsTwo() {
        System.out.println("testMoveWhenNbPieceIsTwo");
        Game instance = new Game();
        instance.initialize();
        instance.select(0, 4);
        Position position = new Position(0, 4);
        Move move1 = new Move(instance.getSelected(),
                position, position.next(Direction.DOWN));
        Move move2 = new Move(instance.getSelected(),
                position, position.next(Direction.LEFT));
        Move move3 = new Move(instance.getSelected(),
                position, position.next(Direction.LEFT).next(Direction.LEFT));
        Move move4 = new Move(instance.getSelected(),
                position, position.next(Direction.DOWN).next(Direction.DOWN));
        List<Move> expResult = new ArrayList<>();
        expResult.add(move3);
        expResult.add(move2);
        expResult.add(move1);
        expResult.add(move4);
        List<Move> result = instance.getMoves();
        assertEquals(expResult.size(), result.size());

    }

    @Test
    public void testWhenApplySquareIsNotFreeAndWeak() {
        System.out.println("testWhenApplyTheSquareIsNotFreeAndWeak");
        Game instance = new Game();
        instance.initialize();
        instance.select(0, 4);
        Position position = new Position(0, 4);
        Move move = new Move(instance.getSelected(), position,
                position.next(Direction.DOWN).next(Direction.DOWN));
        Piece result = new Maréchal(BLUE);
        instance.apply(move);
        Piece expResult = new Maréchal(BLUE);
        assertEquals(expResult, result);

    }
}
