package g53554.stratego.model;

import java.util.Objects;

/**
 * This class is the piece that will be use in the game principally on the board
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
        if (this.rank < 0) {
            throw new IllegalArgumentException("Le rang est négatif");
        }

        this.rank = rank;
        this.color = color;

    }

    /**
     * This method is the hashcode of the piece
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.rank;
        hash = 53 * hash + Objects.hashCode(this.color);
        return hash;
    }

    /**
     * This method compare the attribut of each piece
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
        final Piece other = (Piece) obj;
        if (this.rank != other.rank) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        return true;
    }

    /**
     * This method get the color
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
