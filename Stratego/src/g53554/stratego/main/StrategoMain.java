package g53554.stratego.main;

import g53554.stratego.controller.Controller;
import g53554.stratego.model.Game;
import g53554.stratego.model.Model;
import g53554.stratego.view.View;

/**
 * This is the main of the game where the game can be execute 
 * @author jussy
 */
public class StrategoMain {

    public static void main(String[] args) {
        View vue = new View();
        Model model= new Game();
        Controller controller = new Controller(model, vue);
        controller.initialized();
        controller.startGame();

    }

}
