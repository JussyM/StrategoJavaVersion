package g53554.stratego.model;
import g53554.stratego.model.pieces.Flag;
import g53554.stratego.model.pieces.General;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BoardTest {

    private final Square[][] defaultBoard = {
        {new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square()},
        {new Square(), new Square(), new Square(), new Square(), new Square()}};
    private final Square[][] newDefaultBoard = {
        {new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND),
            new Square(SquareType.LAND), new Square(SquareType.LAND)},
        {new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND),
            new Square(SquareType.LAND), new Square(SquareType.LAND)},
        {new Square(SquareType.WATER), new Square(SquareType.WATER), new Square(SquareType.WATER),
            new Square(SquareType.LAND), new Square(SquareType.LAND)},
        {new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND),
            new Square(SquareType.LAND), new Square(SquareType.LAND)},
        {new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND),
            new Square(SquareType.LAND), new Square(SquareType.LAND)},
        {new Square(SquareType.LAND), new Square(SquareType.LAND), new Square(SquareType.LAND),
            new Square(SquareType.LAND), new Square(SquareType.LAND)}};

    @Test
    public void testGetSquareWhenSquareIsFill() {
        System.out.println("testGetSquareWhenSquareIsFill");
        Position position = new Position(3, 2);
        Board instance = new Board();
        instance.put(new Piece(4, PlayerColor.BLUE), position);
        Square expResult = new Square();
        expResult.put(new Piece(4, PlayerColor.BLUE));
        Square result = instance.getSquare(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSquareWhenSquareIsEmpty() {
        System.out.println("testGetSquareWhenSquareIsEmpty");
        Position position = new Position(0, 1);
        Board instance = new Board();
        Square expResult = new Square();
        Square result = instance.getSquare(position);
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetSquareWhenPositionOutside() {
        System.out.println("testGetSquareWhenPositionOutside");
        Position position = new Position(-1, 2);
        Board instance = new Board();
        instance.getSquare(position);
    }

    @Test
    public void testGetSquaresWhenDefaultBoard() {
        System.out.println("testGetSquaresWhenDefaultBoard");
        Board instance = new Board();
        Square[][] expResult = defaultBoard;
        Square[][] result = instance.getSquare();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testGetSquaresWhen2PiecesAdded() {
        System.out.println("testGetSquaresWhen2PiecesAdded");
        Board instance = new Board();
        instance.put(new Piece(4, PlayerColor.RED), new Position(1, 2));
        instance.put(new Piece(1, PlayerColor.BLUE), new Position(4, 3));
        Square[][] expResult = defaultBoard;
        defaultBoard[1][2].put(new Piece(4, PlayerColor.RED));
        defaultBoard[4][3].put(new Piece(1, PlayerColor.BLUE));
        Square[][] result = instance.getSquare();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testPutOnePiece() {
        System.out.println("testPutOnePiece");
        Piece piece = new Piece(2, PlayerColor.BLUE);
        Position position = new Position(0, 0);
        Board instance = new Board();
        instance.put(piece, position);
        Square expResult = new Square();
        expResult.put(piece);
        Square result = instance.getSquare(position);
        assertEquals(expResult, result);
    }

    @Test(expected = NullPointerException.class)
    public void testPutWhenPieceIsNull() {
        System.out.println("testPutWhenPieceIsNull");
        Piece piece = null;
        Position position = new Position(2, 2);
        Board instance = new Board();
        instance.put(piece, position);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPuWhenPositionIsOutside() {
        System.out.println("testPuWhenPositionIsOutside");
        Piece piece = new Piece(1, PlayerColor.BLUE);
        Position position = new Position(6, 2);
        Board instance = new Board();
        instance.put(piece, position);
    }

    @Test
    public void testIsInsideWhenCornerUpLeft() {
        System.out.println("testIsInsideWhenCornerUpLeft");
        Position position = new Position(0, 0);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenCornerUpRight() {
        System.out.println("testIsInsideWhenCornerUpRight");
        Position position = new Position(0, 3);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenCornerDownleft() {
        System.out.println("testIsInsideWhenCornerDownleft");
        Position position = new Position(4, 0);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenCornerDownRight() {
        System.out.println("testIsInsideWhenCornerDownRight");
        Position position = new Position(4, 3);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenBoundaryUp() {
        System.out.println("testIsInsideWhenBoundaryUp");
        Position position = new Position(0, 1);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenBoundaryDown() {
        System.out.println("testIsInsideWhenBoundaryDown");
        Position position = new Position(4, 2);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenBoundaryLeft() {
        System.out.println("testIsInsideWhenBoundaryLeft");
        Position position = new Position(1, 0);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenBoundaryRight() {
        System.out.println("testIsInsideWhenBoundaryRight");
        Position position = new Position(3, 3);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenOutsideBoundaryUp() {
        System.out.println("testIsInsideWhenOutsideBoundaryUp");
        Position position = new Position(-1, 1);
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenOutsideBoundaryDown() {
        System.out.println("testIsInsideWhenOutsideBoundaryDown");
        Position position = new Position(6, 2);
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenOutsideBoundaryLeft() {
        System.out.println("testIsInsideWhenOutsideBoundaryLeft");
        Position position = new Position(1, -1);
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenOutsideBoundaryRight() {
        System.out.println("testIsInsideWhenOutsideBoundaryRight");
        Position position = new Position(4, 5);
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideWhenInside() {
        System.out.println("testIsInsideWhenInside");
        Position position = new Position(2, 1);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    @Test(expected = NullPointerException.class)
    public void testIsInsideWhenPositionIsNull() {
        System.out.println("testIsInsideWhenPositionIsNull");
        Board instance = new Board();
        instance.isInside(null);

    }

    @Test
    public void testIsFree() {
        System.out.println("TestWhenSquareIsFree");
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isFree(new Position(0, 0));
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNotFree() {
        System.out.println("TestWhenSquareIsNotFree");
        Game game = new Game();
        game.initialize();
        boolean expResult = false;
        this.defaultBoard[4][1].put(new Piece(0, PlayerColor.BLUE));
        boolean result = this.defaultBoard[4][1].isFree();
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenPositionIsOutside() {
        System.out.println("testWhenPositionIsOutside");
        Position position = new Position(6, 2);
        Board instance = new Board();
        instance.isFree(position);
    }

    @Test
    public void testIsMyOwn() {
        System.out.println("testWhenIsMyOwn");
        Board instance = new Board();
        instance.put(new Piece(0, PlayerColor.BLUE), new Position(0, 0));
        boolean expResult = true;
        boolean result = instance.isMyOwn(new Position(0, 0), PlayerColor.BLUE);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsNotMyOwn() {
        System.out.println("testWhenIsNotMyOwn");
        Board instance = new Board();
        instance.put(new Piece(0, PlayerColor.RED), new Position(0, 0));
        boolean expResult = false;
        boolean result = instance.isMyOwn(new Position(0, 0), PlayerColor.BLUE);
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void WhenPositionIsOutside() {
        System.out.println("WhenPositionIsOutside");
        Position position = new Position(6, 2);
        Board instance = new Board();
        instance.isMyOwn(position, PlayerColor.BLUE);
    }

    @Test
    public void testRemovePiece() {
        System.out.println("testRemovePiece");
        Game instance = new Game();
        instance.initialize();
        Piece expResult = null;
        this.defaultBoard[4][1].remove();
        Piece result = this.defaultBoard[4][1].getPiece();
        assertEquals(expResult, result);

    }

    @Test
    public void testListPosition() {
        System.out.println("testListPosition");
        Board board = new Board();
        board.put(new General(PlayerColor.RED), new Position(0, 1));
        board.put(new Flag(PlayerColor.RED), new Position(3, 2));
        defaultBoard[0][1].put(new Piece(0, PlayerColor.RED));
        defaultBoard[3][2].put(new Piece(0, PlayerColor.RED));
        List<Position> expResult = new ArrayList<>();
        expResult.add(new Position(0, 1));
        expResult.add(new Position(3, 2));
        Player player = new Player(PlayerColor.RED);
        List<Position> result = board.getTakenSquare(player);
        assertEquals(expResult.size(), result.size());

    }

    @Test
    public void testNewDefaultBoard() {
        System.out.println("testNewDefaultBoard");
        Board board = new Board();
        Square[][] expResult = newDefaultBoard;
        Square[][] result = board.getSquare();
        Assert.assertArrayEquals(expResult, result);
    }

}
