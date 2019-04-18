package g53554.stratego.view;

import g53554.stratego.model.Square;
import g53554.stratego.model.Board;
import java.util.Scanner;
import g53554.stratego.main.Color;
import g53554.stratego.model.Move;
import g53554.stratego.model.Piece;
import g53554.stratego.model.PlayerColor;
import java.util.List;

/**
 * This class interact with the player or the user by doing a display or asking
 * information from the keyboard
 *
 * @author 53554
 */
public class View {

    private Scanner in;

    /**
     * This method build the the class view and his attribut
     */
    public View() {
        in = new Scanner(System.in);
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
        System.out.println("Bye Bye Thanks for Playing");

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
        System.out.println("     " + couleur.toYellow("Taper ") + couleur.toRed("select <row,column>") + couleur.toYellow(" pour selectionner la pièce de la case mentionnée"));
        System.out.println("     " + couleur.toYellow("Taper ") + couleur.toRed("moves") + couleur.toYellow(" afficher la liste des déplacements possibles de la pièce séléctionnée"));
        System.out.println("     " + couleur.toYellow("Taper ") + couleur.toRed("apply <index> ") + couleur.toYellow("pour appliquer le déplacement d'indice donnée"));
        System.out.println(couleur.toYellow("     " + "Taper " + couleur.toRed("quit") + couleur.toYellow(" pour arrêter le jeu")));

    }

    /**
     * This method display all the move possible 
     * @param moves
     */

    public void displayMoves(List<Move> moves) { 
        for (int i = 0; i < moves.size(); i++) {
            System.out.println(moves.get(i).getPiece()+"peut se déplacer vers la ligne "+ moves.get(i).getEnd().getRow()+" et la colonne "+ moves.get(i).getEnd().getColumn());
            
        }

    }

    /**
     * This method ask for imput from the player and return an encode text
     *
     * @return cmde
     */
    public String askCommand() {
        System.out.println("Veuillez entrez une commande: ");
        String cmde = in.next();
        return cmde;
    }

    /**
     * This method display the game board for the user or player
     *
     * @param square
     */
    public void displayBoard(Square[][] square) {
        Board board = new Board();
        System.out.print("  " + "Col#|| ");
        for (int i = 0; i < board.getSquare()[0].length; i++) {
            System.out.printf(" |%02d|", i);
            if (i == square[0].length - 1) {
                System.out.println("");
                PrintEqualSign(square);
                for (int j = 0; j < board.getSquare().length; j++) {
                    System.out.printf("  %nrow#%02d|| ", j);
                    for (int k = 0; k < square[j].length; k++) {
                        Piece piece = square[j][k].getPiece();
                        displayPiece(piece);

                    }

                }

            }

        }

    }

    /**
     * This method display the piece inside the board with background colour
     *
     * @param piece
     */
    private void displayPiece(Piece piece) {
        Color couleur = new Color();
        if (piece == null) {
            System.out.print(" |" + "\u001b[46m" + "  " + "\u001b[0m" + "|");
        } else if (piece.getColor() == PlayerColor.BLUE) {
            System.out.print(" |" + "\u001b[46m" + couleur.toBlue("PE") + "|");

        } else {
            System.out.print(" |" + "\u001b[46m" + couleur.toRed("PE") + "|");

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
            System.out.print("======");
            i++;

        }

    }

    /**
     * This method diplay to the user that the game is over
     */
    public void displayOver() {

        System.out.println("Le jeux est terminer");

    }

    /**
     * This method display the piece selected by the player
     *
     * @param piece
     */
    public void displaySelected(Piece piece) {
        System.out.println(piece.getRank() + "selected");

    }

}
