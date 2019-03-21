package g53554.stratego.model;

/**
 *
 * @author jussy
 */
public class Game implements Model {

    Board board;
    Player current;
    Player opponent;

    /**
     *
     * @param board
     * @param current
     * @param opponent
     */
    public Game(Board board, Player current, Player opponent) {
        this.board = board;
        this.current = current;
        this.opponent = opponent;
    }

    /**
     * This method initialized the board of the game
     */
    @Override
    public void initialize() {
        Square[][] square = null;
        Board board = new Board(square);
        board.put(new Piece(0, PlayerColor.RED), new Position(0, 1));
        board.put(new Piece(0, PlayerColor.RED), new Position(3, 2));
        board.put(new Piece(0, PlayerColor.BLUE), new Position(4, 2));
        board.put(new Piece(9, PlayerColor.BLUE), new Position(4, 1));
    }

    @Override
    public void start() {
        

    }

    @Override
    public boolean isOver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Square[][] getBoard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
