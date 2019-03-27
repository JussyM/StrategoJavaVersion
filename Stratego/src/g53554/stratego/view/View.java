package g53554.stratego.view;

import g53554.stratego.model.Square;
import g53554.stratego.model.Board;
import java.util.Scanner;
import g53554.stratego.main.Color;
import g53554.stratego.model.Piece;
import g53554.stratego.model.PlayerColor;

/**
 * This class interact with the player or the user by doing a display or asking
 * information from the keyboard
 *
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
        Color couleur = new Color();
        System.out.println(couleur.toCyan("******************************"));
        System.out.println(couleur.toBlue("*****Bienvenu au Stratego*****"));
        System.out.println(couleur.toCyan("******************************"));

    }

    /**
     * This method display a goodbye message to the user or the player
     */
    public void quit() {
        Color couleur = new Color();
        System.out.println(couleur.toRed("Bye Bye Thanks for Playing"));

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
        Color couleur = new Color();
        System.out.println(couleur.toYellow("Usage :"));
        System.out.println(couleur.toYellow("     " + "Taper " + couleur.toRed("quit") + couleur.toYellow(" pour arrêter le jeu")));

    }

    /**
     * This method ask for imput from the player and return an encode text
     *
     * @return
     */
    public String askCommand() {
        Scanner keyboard = this.in;
        System.out.println("Veuillez entrez une commande: ");
        String cmde = keyboard.next();

        return cmde;
    }

    /**
     * This method display the game board for the user or player
     *
     * @param square
     */
    public void displayBoard(Square[][] square) {
        Board board = new Board();
        System.out.print("  " + "Col#||");
        for (int i = 0; i < board.getSquare()[0].length; i++) {
            System.out.print(" |" + String.format("%02d", i) + " | ");
            if (i == square[0].length - 1) {
                System.out.println("");
                PrintEqualSign(square);
                System.out.println("");
                for (int j = 0; j < board.getSquare().length; j++) {
                    System.out.println("row#" + String.format("%02d", j) + "||" + PrintLine(square));

                }

            }

        }
    }

    private void displayPiece(Square square[][]) {
        Color couleur = new Color();
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                Piece piece = square[i][j].getPiece();
                if (piece.getColor() == PlayerColor.BLUE) {
                    System.out.print(couleur.toBlue("PE"));
                } else {
                    System.out.print(couleur.toRed("PE"));
                }

            }

        }

    }

    /**
     * This method expand the equal sign for the board
     *
     * @param tab
     */
    private void PrintEqualSign(Square tab[][]) {
        int i = 0;
        while (i < tab.length) {
            System.out.print("=======");
            i++;

        }

    }

    private String PrintLine(Square tab[][]) {
        String line = " |" + "   |" + "  |" + "   |" + "  |" + "   |" + "  |" + "   |";
        ;

        return line;

    }

    /**
     * This method diplay to the user that the game is over
     */
    public void displayOver() {

        System.out.println("Le jeux est terminer");

    }

}
