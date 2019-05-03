package g53554.stratego.model.pieces;

import g53554.stratego.model.Piece;
import g53554.stratego.model.PlayerColor;

/**
 *
 * @author jussy-lili
 */
public class Maréchal extends Piece {

    /**
     *
     * @param rank
     * @param color
     */

    public Maréchal(int rank, PlayerColor color) {
        super(rank, color);
    }

    /**
     *
     * @param rank
     * @param color
     * @param nbSteps
     */

    public Maréchal(int rank, PlayerColor color, int nbSteps) {
        super(rank, color, 1);
    }

}
