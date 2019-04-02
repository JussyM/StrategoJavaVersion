package g53554.stratego.model;

/**
 * This class is the board of the game with an arrays of double dimension it
 * will help us to creat the board with all element include
 *
 * @author 53554
 */
public class Board {

    private Square[][] square;

    /**
     * This is constructor that build the board with no parameter with no
     * parameter And put the board to default setting
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
     * This method get the square of the board
     *
     * @return square
     */
    public Square[][] getSquare() {
        return square;
    }

    /**
     * This method verified if position give in parameter is inside the square
     * if it will return a boolean
     *
     * @param position
     * @return inside
     */
    public boolean isInside(Position position) {
        boolean isinside = false;
        if ((position.getRow() >= 0 && position.getRow() < square.length) && (position.getColumn() >= 0 && position.getColumn() < square[0].length)) {
            isinside = true;
        }

        return isinside;
    }

    /**
     * This methode return the square at the position given in a parameter and
     * display an exeption if the postion is out of the board
     *
     * @param position
     * @return square
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
     * This method put a piece at the postion in parameter and also display an
     * expetion if the position is out of the board
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

    /**
     * This method check if a square at the position given in parameter is free
     * @param position
     * @return isFree
     */

    public boolean isFree(Position position) {
        if (isInside(position) == false) {
            throw new IllegalArgumentException("La position est hors du tableau");
        }

        return this.square[position.getRow()][position.getColumn()].isFree();

    }

}
