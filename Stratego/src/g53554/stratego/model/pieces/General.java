package g53554.stratego.model.pieces;

import g53554.stratego.model.Piece;
import g53554.stratego.model.PlayerColor;

/**
 *
 * @author jussy-win10
 */
public class General extends Piece {

    /**
     * Constructor of General
     * @param rank
     * @param color
     */

    public General(int rank, PlayerColor color) {
        super(rank, color);
    }

    public General(int rank, PlayerColor color, int nbSteps) {
        super(rank, color, 0);
    }
    

}
