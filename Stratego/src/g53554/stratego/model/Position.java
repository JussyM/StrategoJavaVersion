package g53554.stratego.model;

/**
 *
 * @author jussy
 */
public class Position {

    private int row;
    private int column;

    /**
     * This method build the object postion with row and line in parameter
     *
     * @param row
     * @param column
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Tjis method get the column
     *
     * @return column
     */
    public int getColumn() {
        return column;
    }

    /**
     * This method get the row
     *
     * @return row
     */
    public int getRow() {
        return row;
    }

}
