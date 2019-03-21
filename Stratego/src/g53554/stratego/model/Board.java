package g53554.stratego.model;

/**
 *
 * @author jussy
 */
public class Board {

    private Square[][] square;

    /**
     *
     * @param square
     */
    public Board(Square[][] square) {
        this.square = square;
    }

    
    /**
     *
     * @return
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
        boolean inside = false;
        for (int i = 0; i < this.square.length; i++) {
            for (int j = 0; j < this.square[i].length; j++) {
                if (position.equals(i * j)) {
                    inside = true;
                }

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
        Square square1 = new Square();
        for (int i = 0; i < this.square.length; i++) {
            for (int j = 0; j < this.square[i].length; j++) {
                if (position.equals(i * j)) {
                    square1 = this.square[i][j];
                } else if (!position.equals(i * j)) {
                    throw new IllegalArgumentException("La position est hors du tableau");

                }

            }

        }
        return square1;

    }

    /**
     * This method put a piece at the postion in parameter
     *
     * @param piece
     * @param position
     */
    public void put(Piece piece, Position position) {
        square[position.getColumn()][position.getRow()].put(piece);

    }

}
