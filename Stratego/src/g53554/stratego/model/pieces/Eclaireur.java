package g53554.stratego.model.pieces;

import g53554.stratego.model.Piece;
import g53554.stratego.model.PlayerColor;

/**
 * New Piece call Eclaireur
 * @author jussy-lili
 */
public class Eclaireur extends Piece {

    /**
     * Constructor without nbSteps
     * @param rank
     * @param color
     */

    public Eclaireur(int rank, PlayerColor color) {
        super(rank, color);
    }

    /**
     * Constructor with nbSteps
     * @param rank
     * @param color
     * @param nbSteps
     */

    public Eclaireur(int rank, PlayerColor color, int nbSteps) {
        super(rank, color, 2);
    }

}
