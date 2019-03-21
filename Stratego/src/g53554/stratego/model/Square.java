package g53554.stratego.model;

/**
 *
 * @author jussy
 */
public class Square {

    private Piece piece;

    /**
     * This method initialized the class square with default value
     */
    public Square() {
    }

    /**
     * This method get the piece
     *
     * @return piece
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     *This method put piece in the square 
     * @param piece
     */

    public void put(Piece piece) {
        this.piece = piece;
    }

}
