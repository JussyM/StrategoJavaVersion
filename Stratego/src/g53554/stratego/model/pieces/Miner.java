package g53554.stratego.model.pieces;

import g53554.stratego.model.Piece;
import g53554.stratego.model.PlayerColor;

/**
 *
 * @author jussy-lili
 */
public class Miner extends Piece {

    /**
     * Constructor of Miner
     *
     * @param rank
     * @param color
     */
    public Miner(int rank, PlayerColor color) {
        super(rank, color);
    }

    /**
     * cherck if the Miner is Stronger 
     * @param other
     * @return boolean 
     */
    @Override
    public boolean isStronger(Piece other) {
        return super.isStronger(other)|| other.getRank()==11;
    }

}
