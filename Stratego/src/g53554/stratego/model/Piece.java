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
    private int nbSteps=1;

    /**
     * This method initialized the attribut of the class Piece
     *
     * @param rank
     * @param color
     */
    public Piece(int rank, PlayerColor color) {
        if (rank < 0) {
            throw new IllegalArgumentException("Le rang est négatif");
        } else {
            this.rank = rank;
            this.color = color;
        }
    }

    /**
     * New constructor of piece
     *
     * @param rank
     * @param color
     * @param nbSteps
     */
    public Piece(int rank, PlayerColor color, int nbSteps) {
        if (nbSteps < 0) {
            throw new IllegalArgumentException("la case est négatif");
        }
        this.rank = rank;
        this.color = color;
        this.nbSteps = nbSteps;
       

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
     * This method also get the value of rank
     *
     * @return rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * getter for nbrSteps
     *
     * @return nbSteps
     */
    public int getNbSteps() {
        return nbSteps;
    }

    /**
     * Verifie if the rank in parameter is lower
     *
     * @param other
     * @return strong
     */
    public boolean isStronger(Piece other) {
        return rank > other.getRank();

    }

    /**
     * Verifie if the rank is parameter is the same thing with the attribut
     *
     * @param other
     * @return sameRank
     */
    public boolean hasSameRank(Piece other) {
        return rank == other.getRank();
    }

    /**
     * this method check if a piece can cross a square
     *
     * @param square
     * @return boolean
     */
    public boolean canCross(Square square) {
        return square.isLand();

    }

}
