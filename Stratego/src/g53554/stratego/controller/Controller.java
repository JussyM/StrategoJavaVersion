package g53554.stratego.controller;

import g53554.stratego.model.Model;
import g53554.stratego.view.View;

/**
 * This class creat the dynamism of the game 
 * is where we put all the method usful to control the game 
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
        //game.start();
        view.initialize();
        view.displayHelp();
        System.out.println("");
        if (game.isOver() == false) {
            view.displayBoard(game.getBoard());

        }
        System.out.println("");
        if(view.askCommand().equals("quit")){
            view.quit();
            //view.displayOver();
        }

    }

}
