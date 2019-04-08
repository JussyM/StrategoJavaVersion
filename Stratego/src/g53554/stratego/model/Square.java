package g53554.stratego.model;

import java.util.Objects;

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
     *
     * @return
     */

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.piece);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */

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
        final Square other = (Square) obj;
        if (!Objects.equals(this.piece, other.piece)) {
            return false;
        }
        return true;
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
     * This method put piece in the square
     *
     * @param piece
     */
    public void put(Piece piece) {
        if (piece == null) {
            throw new NullPointerException();

        }
        if (this.piece != null) {
            throw new IllegalStateException();
        }
        this.piece = piece;
    }

    /**
     * This method check if a sqaure is free or not
     *
     * @return free
     */
    public boolean isFree() {
        boolean isFree = false;
        if (this.piece == null) {
            isFree = true;
        }

        return isFree;

    }

    /**
     * This method check if the color of the piece in parameter is the same with
     * the color in the square
     *
     * @param color
     * @return checkColor
     */
    public boolean isMyOwn(PlayerColor color) {
        boolean checkColor = false;
        if (this.piece.getColor() == color) {
            checkColor = true;
        } else if (this.piece.getColor() != color || isFree() == true) {
            checkColor = false;

        }
        return checkColor;
    }

}
