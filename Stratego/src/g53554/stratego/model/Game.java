package g53554.stratego.model;

/**
 *
 * @author jussy
 */
public class Game implements Model {

    Board board;
    Player current;
    Player opponent;

    /**
     *
     * @param board
     * @param current
     * @param opponent
     */

    public Game(Board board, Player current, Player opponent) {
        this.board = board;
        this.current = current;
        this.opponent = opponent;
    }
    /**
     * 
     */

   
    @Override
    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isOver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Square[][] getBoard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
