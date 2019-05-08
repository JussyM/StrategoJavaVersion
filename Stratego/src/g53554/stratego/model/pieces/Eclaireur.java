package g53554.stratego.model.pieces;

import g53554.stratego.model.Piece;
import g53554.stratego.model.PlayerColor;

/**
 * New Piece call Eclaireur
 *
 * @author jussy-lili
 */
public class Eclaireur extends Piece {

    public Eclaireur(int rank, PlayerColor color) {
        super(rank, color);
    }

    /**
     * Constructor with nbSteps
     *
     * @param color
     */
    public Eclaireur(PlayerColor color) {
        super(2, color, 2);
    }

}
