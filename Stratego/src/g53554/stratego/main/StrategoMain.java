package g53554.stratego.main;

//import g53554.stratego.controller.Controller;
import g53554.stratego.model.Game;
import g53554.stratego.model.Player;
import g53554.stratego.model.Piece;
import g53554.stratego.model.PlayerColor;
//import g53554.stratego.model.Position;
//import g53554.stratego.model.Square;
import g53554.stratego.model.Board;
//import g53554.stratego.view.View;
//import static java.lang.System.in;
        

/**
 *
 * @author jussy
 */
public class StrategoMain {

    public static void main(String[] args) {
        Player opponent = new Player(PlayerColor.BLUE, new Piece(0, PlayerColor.BLUE));
        Player current = new Player(PlayerColor.RED, new Piece(0, PlayerColor.BLUE));
        Game stratego = new Game(new Board(), current, opponent);
       
       
        

    }

}
