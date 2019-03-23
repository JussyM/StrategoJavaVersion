package g53554.stratego.view;

import g53554.stratego.model.Square;
import g53554.stratego.model.Board;
import java.util.Scanner;

/**
 *This class interact with the player or the user by doing a display 
 * or asking information from the keyboard
 * @author 53554
 */
public class View {

    Scanner in;

    /**
     * This method build the the class view and his attribut
     *
     * @param in
     */
    public View(Scanner in) {
        this.in = in;
    }

    /**
     * This method display a welcome message for the user or the player
     */
    public void initialize() {
        System.out.println("******************************");
        System.out.println("*****Bienvenu au Stratego*****");
        System.out.println("******************************");

    }

    /**
     * This method display a goodbye message to the user or the player
     */
    public void quit() {
        System.out.println("Bye Bye");

    }

    /**
     * This method display an errors message gives in the parameter
     *
     * @param message
     */
    public void displayErrors(String message) {

    }

    /**
     * This method display some guide line that the user can encode
     */
    public void displayHelp() {
        System.out.println("Usage :");
        System.out.println("     " + "Taper quit pour arrêter le jeu");

    }

    /**
     * This method ask for imput from the player and return an encode text
     *
     * @return
     */
    public String askCommand() {
        Scanner keyboard = this.in;
        System.out.println("Veuillez entrez une commande");
        String cmde = keyboard.next();

        return cmde;
    }

    /**
     * This method display the game board for the user or player
     *
     * @param square
     */
    public void displayBoard(Square[][] square) {
        Board board = new Board(square);
        board.getSquare();

    }

    /**
     * This method diplay to the user that the game is over
     */
    public void displayOver() {
        System.out.println("Le jeux est terminer");

    }

}
