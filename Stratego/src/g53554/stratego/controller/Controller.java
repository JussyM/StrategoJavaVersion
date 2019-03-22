package g53554.stratego.controller;

import g53554.stratego.model.Model;
import g53554.stratego.view.View;

/**
 *
 * @author jussy
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

    }

}
