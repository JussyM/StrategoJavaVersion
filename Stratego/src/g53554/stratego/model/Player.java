package g53554.stratego.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author jussy
 */
public class Player {

     PlayerColor color;
     List<Piece> pieces;

    /**
     * This method initialized the attribute of the class
     *
     * @param color
     * @param pieces
     */
    public Player(PlayerColor color) {
        if(color==null){
            throw new NullPointerException();
        }
        this.color = color;
        this.pieces = new ArrayList<>();
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.color);
        hash = 37 * hash + Objects.hashCode(this.pieces);
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
        final Player other = (Player) obj;
        if (this.color != other.color) {
            return false;
        }
        if (!Objects.equals(this.pieces, other.pieces)) {
            return false;
        }
        return true;
    }

    /**
     * This method get the color
     *
     * @return
     */
    public PlayerColor getColor() {
        return color;
    }

    /**
     * This method get the Piece
     *
     * @return
     */
    public List<Piece> getPieces() {    
        return pieces;

    }

    /**
     * This method add a piece in a list for the player
     *
     * @param piece
     */
    public void addPiece(Piece piece) {
        pieces.add(piece);
    }
}
