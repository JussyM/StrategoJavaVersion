package g53554.stratego.model;

/**
 * This class 
 * @author g53554
 */
public class Game implements Model {

    Board board;
    Player current;
    Player opponent;

    /**
     * This method build the game and his attribut
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

    public Game() {
        
    }

    /**
     * This method initialized the board of the game with default parameter
     */
    @Override
    public void initialize() {
        Board board = new Board();
        board.put(new Piece(0, PlayerColor.RED), new Position(0, 1));
        board.put(new Piece(0, PlayerColor.RED), new Position(3, 2));
        board.put(new Piece(0, PlayerColor.BLUE), new Position(4, 2));
        board.put(new Piece(9, PlayerColor.BLUE), new Position(4, 1));
        current.addPiece(new Piece(0, PlayerColor.BLUE));
        opponent.addPiece(new Piece(0, PlayerColor.RED));
    }

    /**
     * This method verifie if the game can start
     */
    @Override
    public void start() {
        if (board == null || isOver() == true) {
            throw new IllegalStateException();

        }

    }

    /**
     * Thos method return true of fals if the game is over
     *
     * @return over
     */
    @Override
    public boolean isOver() {
        boolean over = false;

        return over;
    }

    /**
     * This method return th board of the game
     *
     * @return board
     */

    @Override
    public Square[][] getBoard() {

        return board.getSquare();
    }

}
