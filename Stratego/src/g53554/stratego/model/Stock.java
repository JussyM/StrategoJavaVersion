/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53554.stratego.model;

import java.util.List;
import java.util.ArrayList;

/**
 * Manage the player piece
 *
 * @author g53554
 */
public class Stock {

    List<Piece> actives;
    List<Piece> inactives;

    /**
     * constructor of the class
     */
    public Stock() {
        this.actives = new ArrayList<>();
        this.inactives = new ArrayList<>();
    }

    /**
     * getter of active list
     *
     * @return actives
     */
    public List<Piece> getActives() {
        return actives;
    }

    /**
     * getter of inactive list
     *
     * @return inactive
     */
    public List<Piece> getInactives() {
        return inactives;
    }

    /**
     * Method that add the piece in parameter in the active list
     *
     * @param piece
     */
    public void add(Piece piece) {
        if (piece == null) {
            throw new NullPointerException("La piece en paramètre est null");
        }
        this.actives.add(piece);
    }

    /**
     * Method that remove the piece in parameter from the active list to the
     * inactive list
     *
     * @param piece
     */
    public void remove(Piece piece) {
        if (piece == null || !this.actives.contains(piece)) {
            throw new NullPointerException("La piece en paramètre est null ou "
                    + "n'est pas dans la liste des pieces actives");
        }

        this.actives.remove(piece);
        this.inactives.add(piece);
    }

    /**
     * return true if the piece in parameter is inside the actives list
     *
     * @param piece
     * @return
     */
    public boolean contain(Piece piece) {
        if (piece == null) {
            throw new NullPointerException("La piece en paramètre est null");

        }
        return this.actives.contains(piece);
    }

    /**
     * restore the piece in parameter
     *
     * @param piece
     */
    public void restore(Piece piece) {
        if (piece == null || !this.inactives.contains(piece)) {
            throw new NullPointerException("La piece en paramètre est null "
                    + "ou n'es pas dans la liste inactives");
        }
        this.inactives.remove(piece);
        this.actives.add(piece);

    }

}
