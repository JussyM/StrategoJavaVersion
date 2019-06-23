package g53554.stratego.model;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.piece);
        hash = 19 * hash + Objects.hashCode(this.start);
        hash = 19 * hash + Objects.hashCode(this.end);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Move other = (Move) obj;
        if (!Objects.equals(this.piece, other.piece)) {
            return false;
        }
        if (!Objects.equals(this.start, other.start)) {
            return false;
        }
        if (!Objects.equals(this.end, other.end)) {
            return false;
        }
        return true;
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
