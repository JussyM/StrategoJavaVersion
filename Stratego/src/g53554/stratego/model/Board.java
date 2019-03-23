package g53554.stratego.model;

/**
 * This class is the board of the game with an arrays of double dimension
 * @author 53554
 */
public class Board {

    private Square[][] square;

    /**
     * This method build the board with a square of four column and 5 rows
     *
     * @param square
     */
    public Board(Square[][] square) {
        this.square = square;
        square = new Square[4][5];
    }

    /**
     * This also a build with no parameter
     */
    public Board() {
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
        boolean inside = true;
        for (int i = 0; i < square.length; i++) {
            if (position.getColumn() > square.length && position.getRow() > square[i].length) {
                inside = false;
            }

        }
        return inside;
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
                if (position.equals(i * j)) {
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
        if(isInside(position)==false){
            throw new IllegalArgumentException("La position est hors du tableau");
        }
        square[position.getColumn()][position.getRow()].put(piece);

    }

}
