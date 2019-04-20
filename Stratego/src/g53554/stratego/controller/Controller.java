package g53554.stratego.controller;

import g53554.stratego.model.Game;
import g53554.stratego.model.Model;
import g53554.stratego.view.View;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class creat the dynamism of the game is where we put all the method
 * usful to control and play the game
 *
 * @author 53554
 */
public class Controller {

    private Model game;
    private View view;

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
        System.out.println("");
        if (game.isOver() == false) {
            view.displayBoard(game.getBoard());
            System.out.println("");

        }
        System.out.println("");
        while (!game.isOver() && !view.askCommand().equals("quit")) {
            gameCmde(view.askCommand());
        }

    }

    /**
     * This method will extract and return the value given by the player
     *
     * @param cmd
     * @return arrays
     */
    private int[] selectValue(String cmd) {
        ArrayList<Integer> list = new ArrayList<>();
        String[] splited = cmd.split("-");
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
    private void gameCmde(String cmde) {
        String endGamecmde = "quit";
        String piecePostionCmde = "select(.*)";
        String movePiece = "move";
        int row;
        int column;
        if (cmde.matches(endGamecmde)) {
            view.quit();
        } else if (cmde.matches(piecePostionCmde)) {
            row = selectValue(cmde)[0];
            column = selectValue(cmde)[1];
            game.select(row, column);
            System.out.println(game.getSelected() + "selectionné");

        } else if (cmde.matches(movePiece)) {
            view.displayMoves(game.getMoves());

        }

    }

}
