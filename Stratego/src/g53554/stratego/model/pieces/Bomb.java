package g53554.stratego.model.pieces;

import g53554.stratego.model.Piece;
import g53554.stratego.model.PlayerColor;

/**
 *
 * @author jussy-lili
 */
public class Bomb extends Piece {

    /**
     * constructor of Bomb
     *
     * @param rank
     * @param color
     */
    public Bomb(int rank, PlayerColor color) {
        super(rank, color);
    }

    /**
     * New constructor of Bomb
     * @param rank
     * @param color
     * @param nbSteps
     */

    public Bomb(int rank, PlayerColor color, int nbSteps) {
        super(rank, color, 0);
    }

}
