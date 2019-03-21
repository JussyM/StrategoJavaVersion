package g53554.stratego.model;

/**
 *
 * @author jussy
 */
public interface Model {
    void initialize();
    void start();
    boolean isOver();
    Square[][] getBoard();
}
