package g53554.stratego.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * This is the class that creat the player and all his option like the color of
 * the player and a list of piece
 *
 * @author jussy
 */
public class Player {

    private PlayerColor color;
    private List<Piece> pieces;

    /**
     * This method initialized the attribute of the class
     *
     * @param color
     *
     */
    public Player(PlayerColor color) {
        if (color == null) {
            throw new NullPointerException();
        }
        this.color = color;
        this.pieces = new ArrayList<>();
    }

    /**
     * This method is the hascode of the player
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.color);
        hash = 37 * hash + Objects.hashCode(this.pieces);
        return hash;
    }

    /**
     * This method also compare all the attribut
     *
     * @param obj
     * @return boolean
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
     * This method get the color for the player
     *
     * @return
     */
    public PlayerColor getColor() {
        return color;
    }

    /**
     * This method get a list of Piece for the player
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
        if (piece == null) {
            throw new IllegalArgumentException("la piece est null");
        }
        pieces.add(piece);
    }

    /**
     * This method remove the piece in parameter
     *
     * @param piece
     */
    public void remove(Piece piece) {
        if (piece != null) {
            pieces.remove(piece);

        }

    }

    /**
     * This method verified if the list of the player contain flag
     *
     * @return contain 
     */
    public boolean hasFlag() {
        boolean contain = false;
           if( getPieces().get(0).getRank()==0){
            contain = true;
        }
        return contain;

    }
}
