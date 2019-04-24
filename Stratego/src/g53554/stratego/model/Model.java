package g53554.stratego.model;

import java.util.List;

/**
 * This is the interface that game has to follow to build his method in his
 * class
 *
 * @author jussy
 */
public interface Model {

    /**
     * Initializes the stratego game with a default board.
     */
    void initialize();

    /**
     * Checks if a match can start.
     *
     * @throws IllegalStateException if no board is set.
     * @throws IllegalStateException if the board set is incomplete.
     */
    void start();

    /**
     * Declares if it's the end of the game.
     *
     * @return true if it's the end of the game.
     */
    boolean isOver();

    /**
     * Returns the board.
     *
     * @return the board.
     */
    Square[][] getBoard();

    /**
     * select the piece
     *
     * @param row
     * @param column
     */
    void select(int row, int column);

    /**
     * return the piece selected
     *
     * @return
     */
    Piece getSelected();

    /**
     * This method return a list of all the movment available
     *
     * @return list
     */
    List<Move> getMoves();

    /**
     * This method apply the moves of the player
     *
     * @param moves
     */
    void apply(Move moves);

    /**
     * This method return the current player
     * @return current player
     */
    Player getcurrent();

}
