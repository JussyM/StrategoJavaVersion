package g53554.stratego.view;

import g53554.stratego.model.Square;
import g53554.stratego.model.Board;
import java.util.Scanner;
import g53554.stratego.main.Color;
import g53554.stratego.model.Move;
import g53554.stratego.model.Piece;
import g53554.stratego.model.Player;
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
        System.out.println("     " + couleur.toYellow("Taper ") + couleur.toRed("moves") + couleur.toYellow(" pour afficher la liste des déplacements possibles de la pièce séléctionnée"));
        System.out.println("     " + couleur.toYellow("Taper ") + couleur.toRed("apply <index> ") + couleur.toYellow("pour appliquer le déplacement d'indice donnée"));
        System.out.println(couleur.toYellow("     " + "Taper " + couleur.toRed("quit") + couleur.toYellow(" pour arrêter le jeu")));

    }

    /**
     * This method display all the move possible
     *
     * @param moves
     */
    public void displayMoves(List<Move> moves) {
        Color couleur = new Color();
        String namePiece = "";
        System.out.println(" " + moves.size() + couleur.toYellow(" Déplacement possible"));
        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i).getPiece().getRank() == 9
                    && moves.get(i).getPiece().getColor() == PlayerColor.RED) {
                namePiece = "Géneral rouge";
            } else if (moves.get(i).getPiece().getRank() == 0
                    && moves.get(i).getPiece().getColor() == PlayerColor.RED) {
                namePiece = "Drapeau Rouge";
            }else if(moves.get(i).getPiece().getRank() == 0
                    && moves.get(i).getPiece().getColor() == PlayerColor.BLUE){
                namePiece="Drapeau bleu";
            }else if(moves.get(i).getPiece().getRank() == 9
                    && moves.get(i).getPiece().getColor() == PlayerColor.BLUE){
                namePiece= "Géneral bleu";
                        

            }

            System.out.println(i + " -" + namePiece + " peut se déplacer vers la ligne "
                    + moves.get(i).getEnd().getRow()
                    + " et la colonne " + moves.get(i).getEnd().getColumn());

        }

    }

    /**
     * This method ask for imput from the player and return an encode text
     *
     * @return cmde
     */
    public String askCommand() {
        System.out.println("Veuillez entrez une commande: ");
        String cmde = in.nextLine();
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
            System.out.printf(" [%02d]", i);
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
            System.out.print(" [" + "\u001b[46m" + "  " + "\u001b[0m" + "]");
        } else if (piece.getColor() == PlayerColor.BLUE && piece.getRank() == 9) {
            System.out.print(" [" + "\u001b[46m" + couleur.toBlue("GE") + "]");
        } else if (piece.getColor() == PlayerColor.BLUE && piece.getRank() == 0) {
            System.out.print(" [" + "\u001b[46m" + couleur.toBlue("DR") + "]");

        } else if (piece.getColor() == PlayerColor.RED && piece.getRank() == 9) {
            System.out.print(" [" + "\u001b[46m" + couleur.toRed("GE") + "]");
        } else if (piece.getColor() == PlayerColor.RED && piece.getRank() == 0) {
            System.out.print(" [" + "\u001b[46m" + couleur.toRed("DR") + "]");

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
     *
     * @param Winner
     */
    public void displayOver(List<Player> Winner) {
        for (int i = 0; i < Winner.size(); i++) {
            if (Winner.get(i).getColor() == PlayerColor.RED) {
            System.out.println("Félicitation joueur rouge ");
        } else if (Winner.get(i).getColor() == PlayerColor.BLUE) {
            System.out.println("Félicitation joueur bleu " );
        } else {
            System.out.println("Félicitation joueur bleu et rouge " );
            
        }
        

        }

    }

    /**
     * This method display the piece selected by the player
     *
     * @param piece
     */
    public void displaySelected(Piece piece) {
        String nomPiece = "";
        if (piece.getRank() == 9 && piece.getColor() == PlayerColor.RED) {
            nomPiece = "Géneral rouge";
        } else if (piece.getRank() == 0 && piece.getColor() == PlayerColor.RED) {
            nomPiece = "Drapeau rouge";
        } else if (piece.getRank() == 0 && piece.getColor() == PlayerColor.BLUE) {
            nomPiece = "Drapeau bleu";
        } else if (piece.getRank() == 9 && piece.getColor() == PlayerColor.BLUE) {
            nomPiece = "Géneral bleu";
        }
        System.out.println(nomPiece + " sélectionné");

    }

    /**
     * Display the current player
     *
     * @param player
     */
    public void displayCurrentPlayer(Player player) {
        System.out.println("A votre tour joueur " + player.getColor());

    }

}
