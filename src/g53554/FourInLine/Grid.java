package g53554.FourInLine;

/**
 *
 * @author jussy
 */
public class Grid {

    Grid[] columns = new Grid[7];

    public Grid() {
        for (int i = 0; i < columns.length; i++) {
            columns[i] = new Grid();

        }
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
