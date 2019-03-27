package g53554.stratego.main;

import g53554.stratego.controller.Controller;
import g53554.stratego.model.Board;
import g53554.stratego.model.Game;
import g53554.stratego.model.Model;
import g53554.stratego.view.View;
import java.util.Scanner;

/**
 *
 * @author jussy
 */
public class StrategoMain {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        View vue = new View(keyboard);
        Board board = new Board();
        Controller controller = new Controller(new Game(), vue);
        controller.initialized();
        controller.startGame();

    }

}
