package g53554.stratego.model.pieces;

import g53554.stratego.model.Piece;
import g53554.stratego.model.PlayerColor;

/**
 *
 * @author jussy-lili
 */
public class Miner extends Piece {

    public Miner(PlayerColor color) {
        super(3, color);
    }

    public Miner(int rank, PlayerColor color, int nbSteps) {
        super(rank, color, nbSteps);
    }

    /**
     * cherck if the Miner is Stronger
     *
     * @param other
     * @return boolean
     */
    @Override
    public boolean isStronger(Piece other) {
        return super.isStronger(other) || other.getRank() == 11;
    }

}
