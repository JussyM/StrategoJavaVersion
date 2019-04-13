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
        System.out.println("");
        if (game.isOver() == false) {
            view.displayBoard(game.getBoard());
            System.out.println("");

        }
        if (view.askCommand().matches("select(.*)")) {
            game.select(selectValue(view.askCommand())[0], selectValue(view.askCommand())[1]);
            game.getSelected();

        }

        System.out.println("");
        while (!game.isOver() && !view.askCommand().equals("quit")) {
            view.askCommand();

        }
        view.quit();
        //view.displayOver();

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
    

}
