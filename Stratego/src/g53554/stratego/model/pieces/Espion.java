package g53554.stratego.model.pieces;

import g53554.stratego.model.Piece;
import g53554.stratego.model.PlayerColor;

/**
 *
 * @author jussy-lili
 */
public class Espion extends Piece {

    public Espion(int rank, PlayerColor color) {
        super(rank, color);
    }

    /**
     * new constructor
     *
     * @param color
     */
    public Espion(PlayerColor color) {
        super(1, color);

    }

}
