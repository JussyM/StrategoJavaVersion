package g53554.stratego.controller;
import g53554.stratego.model.Model;
import g53554.stratego.view.View;
import java.util.ArrayList;


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
        while (!game.isOver()) {
            view.displayBoard(game.getBoard());
            System.out.println("");
            view.displayCurrentPlayer(game.getcurrent());
            gameCmde();

        }
        System.out.println("");
        view.displayOver(game.getWinner());
        view.quit();
    }

    /**
     * This method will extract and return the value given by the player
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
        String cmde = view.askCommand();
        String endGamecmde = "quit";
        String piecePostionCmde = "select(.*)";
        String movePieceCmd = "move(.*)";
        String applyMoveCmd = "apply(.*)";
        int row;
        int column;
        int applyValue;
        if (cmde.matches(endGamecmde)) {
            view.quit();

        } else if (cmde.matches(piecePostionCmde)) {
            row = selectValue(cmde)[0];
            column = selectValue(cmde)[1];
            game.select(row, column);
            view.displaySelected(game.getSelected());
            view.displayBoard(game.getBoard());
            System.out.println("");
            gameCmde();

        } else if (cmde.matches(movePieceCmd)) {
            if (game.getSelected() == null) {
                try {
                    throw new IllegalArgumentException();
                } catch (IllegalArgumentException e) {
                    System.out.println("Aucune piece n'a été selectioner: ");

                }
            } else {
                view.displayMoves(game.getMoves());
                gameCmde();

            }
        } else if (cmde.matches(applyMoveCmd)) {
            applyValue = selectValue(cmde)[0];
            game.apply(game.getMoves().get(applyValue));

        }

    }

}
