/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g53554.stratego.model;

/**
 *
 * @author jussy
 */
public enum Direction {
    UP(-1,0) , DOWN(1,0), LEFT(0,-1), RIGHT(0,1);//DiaLEFT(-1,-1), DIARIGHT(1,1);

    private int row;
    private int column;

    /**
     * this method is the constructor of the direction
     *
     * @param row
     * @param column
     */
    private Direction(int row, int column) {
        this.row = row;
        this.column = column;

    }

    /**
     * this method get the row of the direction
     *
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * this method get the column of direction
     *
     * @return column
     */
    public int getColumn() {
        return column;
    }

}
