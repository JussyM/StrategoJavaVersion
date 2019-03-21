package g53554.stratego.view;

import g53554.stratego.model.Square;
import java.util.Scanner;

/**
 *
 * @author jussy
 */
public class View {

    Scanner in;

    /**
     * This method initialize the attribute of the class
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
        System.out.println("Bienvenu au Stratego");

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

    }

    /**
     * This method ask for imput from the player and return an encode text
     *
     * @return
     */
    public String askCommand() {
        return null;
    }

    /**
     * This method display the game board for the user or player
     *
     * @param square
     */
    public void displayBoard(Square[][] square) {

    }

    /**
     *This method diplay to the user that the game is over
     */
    public void displayOver() {

    }

}
