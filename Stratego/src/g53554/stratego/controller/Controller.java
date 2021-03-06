package g53554.stratego.controller;

import g53554.stratego.main.Color;
import g53554.stratego.model.Model;
import g53554.stratego.view.View;
import java.util.ArrayList;

/**
 * This class creat the dynamism of the game is where we put all the method
 * useful to control and play the game
 *
 * @author 53554
 */
public class Controller {

    private Model game;
    private View view;
    private String cmd;

    /**
     * This method initialized the attribute declared
     *
     * @param game
     * @param view
     */
    public Controller(Model game, View view) {
        if (game == null || view == null) {
            throw new IllegalArgumentException("Le jeu n'est pas initialiser");
        }
        this.game = game;
        this.view = view;
    }

    /**
     * This method initialized the game
     */
    public void initialized() {
        game.initialize();
        view.initialize();

    }

    /**
     * This method enable to begin the game
     */
    public void startGame() {
        game.start();
        view.displayHelp();
        do {
            view.displayBoard(game.getBoard(), game.getcurrent());
            System.out.println("");
            view.displayCurrentPlayer(game.getcurrent());
            gameCmde();
        } while (!game.isOver() && !quit());
        if (game.isOver()) {
            view.displayBoard(game.getBoard(), game.getcurrent());
            System.out.println("");
            view.displayOver(game.getWinner());
        }

    }

    /**
     * This method will extract the integer from a String and return the value
     * given by the player
     *
     * @param cmd
     * @return arrays
     */
    private int[] selectValue(String cmd) {
        ArrayList<Integer> list = new ArrayList<>();
        String[] splited = cmd.split(" ");
        for (String current : splited) {
            try {
                int parsedInt = Integer.parseInt(current);
                list.add(parsedInt);
            } catch (NumberFormatException e) {
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;

    }

    /**
     * This method group all the command useful for the game and it respectives
     * roles
     *
     * @param cmde
     */
    private void gameCmde() {
        Color couleur = new Color();
        cmd = view.askCommand();
        String endGamecmde = "quit";
        String piecePostionCmde = "select\\s\\d\\s\\d";
        String movePieceCmd = "move(.*)";
        String applyMoveCmd = "apply\\s\\d";
        String showPieceLostCmd = "lost";
        String restoreCmd = "restore\\s\\d";
        int row;
        int column;
        int applyValue;
        if (cmd.matches(endGamecmde)) {
            view.quit();

        } else if (cmd.matches(piecePostionCmde)) {
            try {
                row = selectValue(cmd)[0];
                column = selectValue(cmd)[1];
                game.select(row, column);
                view.displaySelected(game.getSelected());
                view.displayBoard(game.getBoard(), game.getcurrent());
                System.out.println("");
                gameCmde();
            } catch (ArrayIndexOutOfBoundsException e) {
            } catch (IllegalArgumentException e) {

                view.displayErrors(couleur.toRed("commande imcomplete ou"
                        + " non valide ou la case réfère à un la case d'un "
                        + "joueur adverse"));
                System.out.println("");
                gameCmde();
            }

        } else if (cmd.matches(movePieceCmd)) {
            try {
                if (game.getSelected() == null);

            } catch (IllegalArgumentException e) {
                view.displayErrors(couleur.toRed("Aucune piece n'a été "
                        + "selectioner "));
                view.displayErrors(couleur.toRed("commande imcomplete"));
                view.displayErrors("Veuillez ressayé");
                System.out.println("");
                gameCmde();
            }
            view.displayMoves(game.getMoves());
            gameCmde();
        } else if (cmd.matches(applyMoveCmd)) {
            try {
                applyValue = selectValue(cmd)[0];
                game.apply(game.getMoves().get(applyValue));
            } catch (ArrayIndexOutOfBoundsException e) {
                view.displayErrors(couleur.toRed("commande imcomplete"));
                System.out.println("");
                gameCmde();

            }
        } else if (cmd.matches(showPieceLostCmd)) {
            view.lostPieceName(game.getLost());
        } else if (cmd.matches(restoreCmd)) {

        } else {
            view.displayErrors("La commande entrez n'est pas valable :(");
            view.displayErrors("Veuillez ressayé");
            System.out.println("");
            gameCmde();

        }
    }

    /**
     * Check if the the cmd is quit
     *
     */
    private boolean quit() {
        return cmd.equals("quit");
    }

//    private void confirmMoves() {
//
//    }
}
