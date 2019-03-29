package g53554.stratego.main;

import g53554.stratego.controller.Controller;
import g53554.stratego.model.Game;
import g53554.stratego.model.Model;
import g53554.stratego.view.View;
import java.util.Scanner;

/**
 * This is the main of the game where the game can be execute 
 * @author jussy
 */
public class StrategoMain {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        View vue = new View(keyboard);
        Model model= new Game();
        Controller controller = new Controller(model, vue);
        controller.initialized();
        controller.startGame();

    }

}
