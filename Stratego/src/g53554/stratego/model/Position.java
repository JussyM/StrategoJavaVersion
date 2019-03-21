package g53554.stratego.model;

/**
 *
 * @author jussy
 */
public class Position {

    private int row;
    private int column;

    /**
     *
     * @param row
     * @param column
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     *
     * @return
     */

    public int getColumn() {
        return column;
    }

    /**
     *
     * @return
     */

    public int getRow() {
        return row;
    }

}
