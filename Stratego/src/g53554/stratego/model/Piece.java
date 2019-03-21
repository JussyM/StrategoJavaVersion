package g53554.stratego.model;

/**
 *
 * @author jussy
 */
public class Piece {

    private int rank;
    private PlayerColor color;

    /**
     * This method initialized the attribut of the class Piece
     *
     * @param rank
     * @param color
     */
    public Piece(int rank, PlayerColor color) {
        if (rank < 0) {
            throw new IllegalArgumentException("Le rang est négatif");
        }
        this.rank = rank;
        this.color = color;
    }

    /**
     * This method get the value of color
     *
     * @return color
     */
    public PlayerColor getColor() {
        return color;
    }

    /**
     * This metho also get the value of rank
     *
     * @return rank
     */
    public int getRank() {
        return rank;
    }

}
