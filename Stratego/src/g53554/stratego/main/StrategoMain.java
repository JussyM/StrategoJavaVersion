package g53554.stratego.main;

import g53554.stratego.controller.Controller;
//import g53554.stratego.model.Game;
import g53554.stratego.model.Player;
import g53554.stratego.model.Piece;
import g53554.stratego.model.PlayerColor;
//import g53554.stratego.model.Position;
import g53554.stratego.model.Square;
import g53554.stratego.model.Board;
import g53554.stratego.model.Game;
import g53554.stratego.view.View;
import java.util.Scanner;

/**
 *
 * @author jussy
 */
public class StrategoMain {

    public static void main(String[] args) {
        Player current = new Player(PlayerColor.BLUE, new Piece(0, PlayerColor.RED));
        Player opponent = new Player(PlayerColor.BLUE, new Piece(0, PlayerColor.BLUE));
        Scanner keyboard = new Scanner(System.in);
        View vue = new View(keyboard);
        Board board = new Board();
        Game stratego = new Game(board, current, opponent);
        Controller controller= new Controller(stratego, vue);
        controller.startGame();
        
        
        
        

    }

}
