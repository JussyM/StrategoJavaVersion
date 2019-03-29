package g53554.stratego.model;

/**
 * This class creat the position for the piece in the board
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
     * This method get the column
     *
     * @return column
     */
    public int getColumn() {
        return column;
    }

    /**
     * This method is the hashcode of position
     * @return hash
     */

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.row;
        hash = 61 * hash + this.column;
        return hash;
    }

    /**
     * Compare the attribut
     * @param obj
     * @return boolean
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
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
