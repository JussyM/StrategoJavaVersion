package g53554.stratego.model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author jussy
 */
public class Player {

    private PlayerColor color;
    private Piece pieces;

    /**
     * This method initialized the attribute of the class
     *
     * @param color
     * @param pieces
     */
    public Player(PlayerColor color, Piece pieces) {
        this.color = color;
        this.pieces = pieces;
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
    public Piece getPieces() {
        return pieces;
    }

    /**
     * This method add a piece in a list for the player
     *
     * @param piece
     */
    public void addPiece(Piece piece) {
        List<Piece> listePiece = new ArrayList<Piece>();
        listePiece.add(piece);

    }

}
