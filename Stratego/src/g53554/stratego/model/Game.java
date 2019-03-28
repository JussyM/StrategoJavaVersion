package g53554.stratego.model;

import java.util.Objects;

/**
 * This class
 *
 * @author g53554
 */
public class Game implements Model {

    Board board;
    Player current;
    Player opponent;

    public Game() {
        this.current = new Player(PlayerColor.RED);
        this.opponent = new Player(PlayerColor.BLUE);

    }

    /**
     * This method initialized the board of the game with default parameter
     */
    @Override
    public void initialize() {
        board = new Board();
        this.current = new Player(PlayerColor.RED);
        this.opponent = new Player(PlayerColor.BLUE);
        board.put(new Piece(0, PlayerColor.RED), new Position(0, 1));
        board.put(new Piece(9, PlayerColor.RED), new Position(3, 2));
        board.put(new Piece(0, PlayerColor.BLUE), new Position(4, 2));
        board.put(new Piece(9, PlayerColor.BLUE), new Position(4, 1));
        current.addPiece(new Piece(0, PlayerColor.RED));
        opponent.addPiece(new Piece(0, PlayerColor.BLUE));
        current.addPiece(new Piece(9, PlayerColor.RED));
       opponent.addPiece(new Piece(9, PlayerColor.BLUE));

    }

    /**
     * This method verifie if the game can start
     */
    @Override
    public void start() {
        if (board == null || isOver() == true) {
            throw new IllegalStateException(" ");

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
        return this.board.getSquare();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.board);
        hash = 89 * hash + Objects.hashCode(this.current);
        hash = 89 * hash + Objects.hashCode(this.opponent);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (!Objects.equals(this.board, other.board)) {
            return false;
        }
        if (!Objects.equals(this.current, other.current)) {
            return false;
        }
        if (!Objects.equals(this.opponent, other.opponent)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "board=" + board + ", current=" + current + ", opponent=" + opponent + '}';
    }

}
