/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53554.FourInLine;

/**
 *
 * @author jussy
 */
public enum Disc {
    RED, YELLOW;

    /**
     * This method print the player representation
     *
     * @return player
     */
    @Override
    public String toString() {
        String player = "";
        for (Disc joueur : Disc.values()) {
            if (joueur == RED) {
                player = "X";
            } else {
                player = "O";

            }

        }
        return player;
    }

}
