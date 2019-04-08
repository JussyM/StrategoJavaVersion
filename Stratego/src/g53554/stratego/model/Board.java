package g53554.stratego.model;

/**
 * This class is the board of the game with an arrays of double dimension it
 * will help us to creat the board with all element include
 *
 * @author 53554
 */
public class Board {

    private final Square[][] squares;
    private final static int ROW=5;
    private final static int COLUMN=4;

    /**
     * This is constructor that build the board with no parameter with no
     * parameter And put the board to default setting
     */
    public Board() {
        squares = new Square[ROW][COLUMN];
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                squares[i][j] = new Square();

            }

        }
    }

    /**
     * This method get the square of the board
     *
     * @return square
     */
    public Square[][] getSquare() {
        return squares;
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
        if ((position.getRow() >= 0
                && position.getRow() < squares.length)
                && (position.getColumn() >= 0
                && position.getColumn() < squares[0].length)) {
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

        return squares[position.getRow()][position.getColumn()];

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
        this.squares[position.getRow()][position.getColumn()].put(piece);

    }

    /**
     * This method check if a square at the position given in parameter is free
     *
     * @param position
     * @return isFree
     */
    public boolean isFree(Position position) {
        if (isInside(position) == false) {
            throw new IllegalArgumentException("La position est hors du tableau");
        }

        return this.squares[position.getRow()][position.getColumn()].isFree();

    }

    /**
     * This method check if the color given in paramater is the same with the
     * one in the board
     *
     * @param position
     * @param color
     * @return isMyOwn
     */
    public boolean isMyOwn(Position position, PlayerColor color) {
        if (isInside(position) == false) {
            throw new IllegalArgumentException("La position est hors du tableau ");
        }

        return this.squares[position.getRow()][position.getColumn()].isMyOwn(color);
    }

    /**
     * This method return the piece at the postion given in the parameter
     *
     * @param position
     * @return piece
     */
    public Piece getPiece(Position position) {
        if (isInside(position) == false) {
            throw new IllegalArgumentException("La position est hors du tableau");
        }

        return squares[position.getRow()][position.getColumn()].getPiece();

    }

}
