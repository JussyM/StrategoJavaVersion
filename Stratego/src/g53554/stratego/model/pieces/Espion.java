package g53554.stratego.model.pieces;

import g53554.stratego.model.Piece;
import g53554.stratego.model.PlayerColor;

/**
 *
 * @author jussy-lili
 */
public class Espion extends Piece {

    /**
     * Constructor of espion
     * @param rank
     * @param color
     */

    public Espion(int rank, PlayerColor color) {
        super(rank, color);
    }

    /**
     *new constructor 
     * @param rank
     * @param color
     * @param nbSteps
     */

    public Espion(int rank, PlayerColor color, int nbSteps) {
        super(rank, color, 1);
        
                
    }

}
