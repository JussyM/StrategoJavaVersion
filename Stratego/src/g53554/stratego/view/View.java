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

    private Color couleur = new Color();

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
        System.out.println(couleur.toCyan("******************************"));
        System.out.println(couleur.toBlue("*****Bienvenu au Stratego*****"));
        System.out.println(couleur.toCyan("******************************"));

    }

    /**
     * This method display a goodbye message to the user or the player
     */
    public void quit() {
        System.out.println("");
        System.out.println(couleur.toBlue("Bye Bye Thanks for Playing"));

    }

    /**
     * This method display an errors message gives in the parameter
     *
     * @param message
     */
    public void displayErrors(String message) {
        System.out.println(message);

    }

    /**
     * This method display some guide line that the user can encode
     */
    public void displayHelp() {
        System.out.println(couleur.toYellow("Usage :"));
        System.out.println("     " + couleur.toYellow("Taper ")
                + couleur.toRed("select <row,column>")
                + couleur.toYellow(" pour selectionner la pièce de la "
                        + "case mentionnée"));
        System.out.println("     " + couleur.toYellow("Taper ")
                + couleur.toRed("moves")
                + couleur.toYellow(" pour afficher la liste des déplacements"
                        + " possibles de la pièce séléctionnée"));
        System.out.println("     " + couleur.toYellow("Taper ")
                + couleur.toRed("apply <index> ")
                + couleur.toYellow("pour appliquer le déplacement d'indice "
                        + "donnée"));
        System.out.println(couleur.toYellow("     " + "Taper "
                + couleur.toRed("quit")
                + couleur.toYellow(" pour arrêter le jeu")));

    }

    /**
     * This method display all the move possible
     *
     * @param moves
     */
    public void displayMoves(List<Move> moves) {
        String namePiece = "";
        String[] name;
        name = namePiece();
        System.out.println(" " + moves.size()
                + couleur.toYellow(" Déplacement(s) possible(s)"));
        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i).getPiece().getRank() == 9
                    && moves.get(i).getPiece().getColor() == PlayerColor.RED) {
                namePiece = name[0];
            } else if (moves.get(i).getPiece().getRank() == 0
                    && moves.get(i).getPiece().getColor() == PlayerColor.RED) {
                namePiece = name[1];
            } else if (moves.get(i).getPiece().getRank() == 0
                    && moves.get(i).getPiece().getColor() == PlayerColor.BLUE) {
                namePiece = name[7];
            } else if (moves.get(i).getPiece().getRank() == 9
                    && moves.get(i).getPiece().getColor() == PlayerColor.BLUE) {
                namePiece = name[6];
            } else if (moves.get(i).getPiece().getRank() == 11
                    && moves.get(i).getPiece().getColor() == PlayerColor.BLUE) {
                namePiece = name[9];
            } else if (moves.get(i).getPiece().getRank() == 11
                    && moves.get(i).getPiece().getColor() == PlayerColor.RED) {
                namePiece = name[3];
            } else if (moves.get(i).getPiece().getRank() == 3
                    && moves.get(i).getPiece().getColor() == PlayerColor.BLUE) {
                namePiece = name[8];
            } else if (moves.get(i).getPiece().getRank() == 3
                    && moves.get(i).getPiece().getColor() == PlayerColor.RED) {
                namePiece = name[2];
            } else if (moves.get(i).getPiece().getRank() == 1
                    && moves.get(i).getPiece().getColor() == PlayerColor.RED) {
                namePiece = name[4];
            } else if (moves.get(i).getPiece().getRank() == 10
                    && moves.get(i).getPiece().getColor() == PlayerColor.RED) {
                namePiece = name[5];
            } else if (moves.get(i).getPiece().getRank() == 1
                    && moves.get(i).getPiece().getColor() == PlayerColor.BLUE) {
                namePiece = name[10];
            } else if (moves.get(i).getPiece().getRank() == 10
                    && moves.get(i).getPiece().getColor() == PlayerColor.BLUE) {
                namePiece = name[11];
            } else if (moves.get(i).getPiece().getRank() == 2
                    && moves.get(i).getPiece().getColor() == PlayerColor.BLUE) {
                namePiece = name[13];
            } else if (moves.get(i).getPiece().getRank() == 2
                    && moves.get(i).getPiece().getColor() == PlayerColor.RED) {
                namePiece = name[6];

            }

            System.out.println(i + "- " + namePiece + " peut se déplacer"
                    + " vers la ligne "
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
        System.out.println("");
        System.out.println("Veuillez entrez une commande: ");
        System.out.println("");
        return in.nextLine();
    }

    /**
     * This method display the game board for the user or player
     *
     * @param square
     * @param player
     */
    public void displayBoard(Square[][] square, Player player) {
        Board board = new Board();
        System.out.print("  " + "Col#|| ");
        for (int i = 0; i < board.getSquare()[0].length; i++) {
            System.out.printf(" [%02d]", i);
            if (i == square[0].length - 1) {
                System.out.println("");
                PrintEqualSign(square);
                displayPiece(square, player);

            }

        }

    }

    /**
     * This method display the piece inside the board with background colour
     * GE=Géneral, DR=Drapeau , DM=Demineur(Miner), BO=Bomb, ES=Espion(Spy), MA=
     * Maréchale
     *
     * @param square, player
     */
    private void displayPiece(Square[][] square, Player player) {
        Board board = new Board();
        for (int i = 0; i < board.getSquare().length; i++) {
            System.out.printf("  %nrow#%02d|| ", i);
            for (Square item : square[i]) {
                Piece piece = item.getPiece();
                if (piece == null && item.isLand()) {
                    System.out.print(" [" + couleur.WhiteBackground + "  "
                            + couleur.toDefault + "]");
                } else if (piece == null && !item.isLand()) {
                    System.out.print(" [" + couleur.BLUE_BACKGROUND + "  "
                            + couleur.toDefault + "]");
                } else {
                    HideCurrentPiece(piece, player);
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
            System.out.print("******");
            i++;

        }

    }

    /**
     * This method hide the current player piece
     *
     * @param player
     */
    private void HideCurrentPiece(Piece piece, Player player) {
        if (player.getColor() == PlayerColor.RED) {
            hideBluePiece(piece);
        } else {
            hideRedPiece(piece);

        }

    }

    /**
     * This method diplay to the user that the game is over
     *
     * @param Winner
     */
    public void displayOver(List<Player> Winner) {
        for (int i = 0; i < Winner.size(); i++) {
            if (null == Winner.get(i).getColor()) {
                System.out.println("Félicitation joueur bleu et rouge ");

            } else {
                switch (Winner.get(i).getColor()) {
                    case RED:
                        System.out.println("Félicitation joueur rouge vous avez "
                                + "gagné ");
                        break;
                    case BLUE:
                        System.out.println("Félicitation joueur bleu vous avez "
                                + "gagné ");
                        break;
                }
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
        String[] name;
        name = namePiece();
        if (piece.getRank() == 9 && piece.getColor() == PlayerColor.RED) {
            nomPiece = name[0];
        } else if (piece.getRank() == 0
                && piece.getColor() == PlayerColor.RED) {
            nomPiece = name[1];
        } else if (piece.getRank() == 0
                && piece.getColor() == PlayerColor.BLUE) {
            nomPiece = name[8];
        } else if (piece.getRank() == 9
                && piece.getColor() == PlayerColor.BLUE) {
            nomPiece = name[7];
        } else if (piece.getRank() == 1
                && piece.getColor() == PlayerColor.BLUE) {
            nomPiece = name[11];
        } else if (piece.getRank() == 10
                && piece.getColor() == PlayerColor.BLUE) {
            nomPiece = name[12];
        } else if (piece.getRank() == 11
                && piece.getColor() == PlayerColor.BLUE) {
            nomPiece = name[10];
        } else if (piece.getRank() == 3
                && piece.getColor() == PlayerColor.BLUE) {
            nomPiece = name[9];
        } else if (piece.getRank() == 1
                && piece.getColor() == PlayerColor.RED) {
            nomPiece = name[4];
        } else if (piece.getRank() == 10
                && piece.getColor() == PlayerColor.RED) {
            nomPiece = name[5];
        } else if (piece.getRank() == 11
                && piece.getColor() == PlayerColor.RED) {
            nomPiece = name[3];
        } else if (piece.getRank() == 3
                && piece.getColor() == PlayerColor.RED) {
            nomPiece = name[2];
        } else if (piece.getRank() == 2
                && piece.getColor() == PlayerColor.RED) {
            nomPiece = name[6];
        } else if (piece.getRank() == 2
                && piece.getColor() == PlayerColor.BLUE) {
            nomPiece = name[13];
        }
        System.out.println(nomPiece + " sélectionné");

    }

    /**
     * Display the current player
     *
     * @param player
     */
    public void displayCurrentPlayer(Player player) {
        System.out.println("");
        if (player.getColor() == PlayerColor.BLUE) {
            System.out.println("A votre tour joueur " + couleur.toBlue("BLUE"));
        } else {
            System.out.println("A votre tour joueur " + couleur.toRed("RED"));
        }

    }

    /**
     * This method hide the piece of the Blue player
     *
     * @param piece
     */
    private void hideBluePiece(Piece piece) {
        String[] name = namePiece2();
        if (piece.getColor() == PlayerColor.BLUE
                && piece.getRank() == 9) {
            System.out.print(" [" + couleur.WhiteBackground
                    + couleur.toBlue("**") + "]");
        } else if (piece.getColor() == PlayerColor.BLUE
                && piece.getRank() == 0) {
            System.out.print(" [" + couleur.WhiteBackground
                    + couleur.toBlue("**") + "]");
        } else if (piece.getColor() == PlayerColor.BLUE
                && piece.getRank() == 11) {
            System.out.print(" [" + couleur.WhiteBackground
                    + couleur.toBlue("**") + "]");
        } else if (piece.getColor() == PlayerColor.BLUE
                && piece.getRank() == 3) {
            System.out.print(" [" + couleur.WhiteBackground
                    + couleur.toBlue("**") + "]");
        } else if (piece.getColor() == PlayerColor.BLUE
                && piece.getRank() == 1) {
            System.out.print(" [" + couleur.WhiteBackground
                    + couleur.toBlue("**") + "]");
        } else if (piece.getColor() == PlayerColor.BLUE
                && piece.getRank() == 10) {
            System.out.print(" [" + couleur.WhiteBackground
                    + couleur.toBlue("**") + "]");
        } else if (piece.getColor() == PlayerColor.BLUE
                && piece.getRank() == 2) {
            System.out.print(" [" + couleur.WhiteBackground
                    + couleur.toBlue("**") + "]");
        } else {
            if (piece.getColor() == PlayerColor.RED && piece.getRank() == 9) {
                System.out.print(" [" + couleur.WhiteBackground
                        + couleur.toRed(name[0]) + "]");
            } else if (piece.getColor() == PlayerColor.RED
                    && piece.getRank() == 0) {
                System.out.print(" [" + couleur.WhiteBackground
                        + couleur.toRed(name[1]) + "]");
            } else if (piece.getColor() == PlayerColor.RED
                    && piece.getRank() == 11) {
                System.out.print(" [" + couleur.WhiteBackground
                        + couleur.toRed(name[3]) + "]");
            } else if (piece.getColor() == PlayerColor.RED
                    && piece.getRank() == 3) {
                System.out.print(" [" + couleur.WhiteBackground
                        + couleur.toRed(name[2]) + "]");
            } else if (piece.getColor() == PlayerColor.RED
                    && piece.getRank() == 10) {
                System.out.print(" [" + couleur.WhiteBackground
                        + couleur.toRed(name[5]) + "]");
            } else if (piece.getColor() == PlayerColor.RED
                    && piece.getRank() == 1) {
                System.out.print(" [" + couleur.WhiteBackground
                        + couleur.toRed(name[4]) + "]");
            } else if (piece.getColor() == PlayerColor.RED
                    && piece.getRank() == 2) {
                System.out.print(" [" + couleur.WhiteBackground
                        + couleur.toRed(name[6]) + "]");

            }
        }

    }

    /**
     * This method hide the piece of the RED player
     *
     * @param piece
     */
    private void hideRedPiece(Piece piece) {
        String[] name = namePiece2();
        if (piece.getColor() == PlayerColor.RED
                && piece.getRank() == 9) {
            System.out.print(" [" + couleur.WhiteBackground
                    + couleur.toRed("$$") + "]");
        } else if (piece.getColor() == PlayerColor.RED
                && piece.getRank() == 0) {
            System.out.print(" [" + couleur.WhiteBackground
                    + couleur.toRed("$$") + "]");
        } else if (piece.getColor() == PlayerColor.RED
                && piece.getRank() == 11) {
            System.out.print(" [" + couleur.WhiteBackground
                    + couleur.toRed("$$") + "]");
        } else if (piece.getColor() == PlayerColor.RED
                && piece.getRank() == 3) {
            System.out.print(" [" + couleur.WhiteBackground
                    + couleur.toRed("$$") + "]");
        } else if (piece.getColor() == PlayerColor.RED
                && piece.getRank() == 10) {
            System.out.print(" [" + couleur.WhiteBackground
                    + couleur.toRed("$$") + "]");
        } else if (piece.getColor() == PlayerColor.RED
                && piece.getRank() == 1) {
            System.out.print(" [" + couleur.WhiteBackground
                    + couleur.toRed("$$") + "]");
        } else if (piece.getColor() == PlayerColor.RED
                && piece.getRank() == 2) {
            System.out.print(" [" + couleur.WhiteBackground
                    + couleur.toRed("$$") + "]");

        } else {
            if (piece.getColor() == PlayerColor.BLUE
                    && piece.getRank() == 9) {
                System.out.print(" [" + couleur.WhiteBackground
                        + couleur.toBlue(name[0]) + "]");
            } else if (piece.getColor() == PlayerColor.BLUE
                    && piece.getRank() == 0) {
                System.out.print(" [" + couleur.WhiteBackground
                        + couleur.toBlue(name[1]) + "]");
            } else if (piece.getColor() == PlayerColor.BLUE
                    && piece.getRank() == 11) {
                System.out.print(" [" + couleur.WhiteBackground
                        + couleur.toBlue(name[3]) + "]");
            } else if (piece.getColor() == PlayerColor.BLUE
                    && piece.getRank() == 3) {
                System.out.print(" [" + couleur.WhiteBackground
                        + couleur.toBlue(name[2]) + "]");
            } else if (piece.getColor() == PlayerColor.BLUE
                    && piece.getRank() == 10) {
                System.out.print(" [" + couleur.WhiteBackground
                        + couleur.toBlue(name[5]) + "]");
            } else if (piece.getColor() == PlayerColor.BLUE
                    && piece.getRank() == 1) {
                System.out.print(" [" + couleur.WhiteBackground
                        + couleur.toBlue(name[4]) + "]");
            } else if (piece.getColor() == PlayerColor.BLUE
                    && piece.getRank() == 2) {
                System.out.print(" [" + couleur.WhiteBackground
                        + couleur.toBlue(name[6]) + "]");

            }
        }
    }

    /**
     * Method grouping piece name and it colors
     *
     * @return namepiece
     */
    private String[] namePiece() {
        String[] namePiece = {"General rouge",
            "Drapeau rouge",
            "Demineur rouge",
            "Bombe rouge",
            "Espion rouge",
            "Marechal rouge",
            "Eclaireur rouge",
            "General bleu",
            "Drapeau bleu",
            "Demineur bleu",
            "Bombe bleu",
            "Espion bleu",
            "Marechal bleu",
            "Eclaireur bleu"};

        return namePiece;
    }

    /**
     * Method grouping name piece abreviation
     *
     * @return namePiece
     */
    private String[] namePiece2() {
        String[] namePiece = {"GE", "DR", "DM", "BO", "ES", "MA", "EC"};
        return namePiece;
    }

}
