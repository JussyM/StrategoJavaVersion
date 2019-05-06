package g53554.stratego.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is the board of the game with an arrays of double dimension it
 * will help us to creat the board with all element include
 *
 * @author 53554
 */
public class Board {

    private final Square[][] squares;
    private final static int ROW = 6;
    private final static int COLUMN = 5;

    /**
     * This is constructor that build the board with no parameter with no
     * parameter And put the board to default setting
     */
    public Board() {
        squares = new Square[ROW][COLUMN];
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (i == 2 && j == 1 && i == 2 && j == 2 && i == 2 && j == 3) {
                    squares[i][j] = new Square(SquareType.WATER);
                } else {
                    squares[i][j] = new Square(SquareType.LAND);
                }

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
        if (!isInside(position)) {
            throw new IllegalArgumentException("La position est hors du tableau");
        }

        return squares[position.getRow()][position.getColumn()].getPiece();

    }

    /**
     * This method remove a piece from the board
     *
     * @param position
     *
     */
    public void remove(Position position) {
        if (!isInside(position)) {
            throw new IllegalArgumentException("La position est hors du tableau");
        } else if (getPiece(position) != null) {
            this.getSquare(position).remove();

        }

    }

    /**
     * This method return a list of all the position occupied by a player
     *
     * @param player
     * @return listPosition
     */
    public List<Position> getTakenSquare(Player player) {
        List<Position> listPosition = new ArrayList<>();
        Position positionPlayer;
        for (int i = 0; i < this.squares.length; i++) {
            for (int j = 0; j < this.squares[i].length; j++) {
                positionPlayer = new Position(i, j);
                if (this.squares[i][j].getPiece() != null && this.isMyOwn(positionPlayer, player.getColor())) {

                    listPosition.add(positionPlayer);
                }

            }

        }

        return listPosition;

    }

}
