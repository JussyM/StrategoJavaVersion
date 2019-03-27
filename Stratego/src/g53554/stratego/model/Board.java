package g53554.stratego.model;

import java.util.Arrays;

/**
 * This class is the board of the game with an arrays of double dimension
 *
 * @author 53554
 */
public class Board {

    private Square[][] square;

    /**
     * This also a build with no parameter
     */
    public Board() {
        square = new Square[5][4];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                square[i][j] = new Square();

            }

        }
    }

    /**
     * This method get the square
     *
     * @return square
     */
    public Square[][] getSquare() {
        return square;
    }

    /**
     * This method verified if position equals to a position in the square
     *
     * @param position
     * @return inside
     */
    public boolean isInside(Position position) {
        boolean isinside = false;
        if((position.getRow()>=0 && position.getRow()<square.length)&&( position.getColumn()>=0 && position.getColumn()<square[0].length)){
            isinside=true;
        }

        return isinside;
    }

    /**
     * This methode return the square at the position given in a parameter
     *
     * @param position
     * @return
     */
    public Square getSquare(Position position) {
        if (isInside(position) == false) {
            throw new IllegalArgumentException("La position est hors du tableau");
        }
        Square square = new Square();

        for (int i = 0; i < this.square.length; i++) {
            for (int j = 0; j < this.square[i].length; j++) {
                if (this.square[position.getRow()][position.getColumn()] == this.square[i][j]) {
                    square = this.square[i][j];

                }

            }

        }
        return square;

    }

    /**
     * This method put a piece at the postion in parameter
     *
     * @param piece
     * @param position
     */
    public void put(Piece piece, Position position) {
        if (isInside(position) == false) {
            throw new IllegalArgumentException("La position est hors du tableau");
        }
        this.square[position.getRow()][position.getColumn()].put(piece);

    }

}
