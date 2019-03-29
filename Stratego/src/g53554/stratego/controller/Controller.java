package g53554.stratego.controller;

import g53554.stratego.model.Model;
import g53554.stratego.view.View;

/**
 * This class creat the dynamism of the game 
 * is where we put all the method usful to control and play the game 
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
        if(game==null || view==null){
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
        if(view.askCommand().equals("quit")){
            view.quit();
            System.out.println("");
            view.displayOver();
        }

    }

}
