package g53554.stratego.model;

/**
 *
 * @author jussy
 */
public class Move {

    private Piece piece;
    private Position start;
    private Position end;

    /**
     * This method construct the attribut
     *
     * @param piece
     * @param start
     * @param end
     */
    public Move(Piece piece, Position start, Position end) {
        if (piece == null || start == null || end == null) {
            throw new IllegalArgumentException("La pièce est null");

        }
        this.piece = piece;
        this.start = start;
        this.end = end;
    }

    /**
     * This method get the end position
     *
     * @return end
     */
    public Position getEnd() {
        return end;
    }

    /**
     * this method get the start position
     *
     * @return start
     */
    public Position getStart() {
        return start;
    }

    /**
     * This method get the piece
     *
     * @return piece
     */
    public Piece getPiece() {
        return piece;
    }

}
