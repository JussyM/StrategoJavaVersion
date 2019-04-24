package g53554.stratego.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class is specified in initializing the game option and verifie if the
 * game can start or not and also is the game is over
 *
 * @author g53554
 */
public class Game implements Model {

    Board board;
    Player current;
    Player opponent;
    Position selected;

    /**
     * This method is the constructor of the game with no parameter and
     * initialized the players
     */
    public Game() {
        this.current = new Player(PlayerColor.RED);
        this.opponent = new Player(PlayerColor.BLUE);

    }

    /**
     * This method initialized the board of the game with default parameter give
     * in
     */
    @Override
    public void initialize() {
        board = new Board();
        this.current = new Player(PlayerColor.RED);
        this.opponent = new Player(PlayerColor.BLUE);
        board.put(new Piece(0, PlayerColor.RED), new Position(0, 1));
        board.put(new Piece(9, PlayerColor.RED), new Position(3, 2));
        board.put(new Piece(0, PlayerColor.BLUE), new Position(4, 2));
        board.put(new Piece(9, PlayerColor.BLUE), new Position(4, 1));
        current.addPiece(new Piece(0, PlayerColor.RED));
        opponent.addPiece(new Piece(0, PlayerColor.BLUE));
        current.addPiece(new Piece(9, PlayerColor.RED));
        opponent.addPiece(new Piece(9, PlayerColor.BLUE));

    }

    /**
     * This method verifie if the game can start if not an exeption is displays
     */
    @Override
    public void start() {
        if (board == null || isOver() == true) {
            throw new IllegalStateException(" ");

        }

    }

    /**
     * Thos method return true or false if the game is over
     *
     * @return over
     */
    @Override
    public boolean isOver() {
        boolean over = false;

        return over;
    }

    /**
     * This method return th board of the game
     *
     * @return board
     */
    @Override
    public Square[][] getBoard() {
        return this.board.getSquare();
    }

    /**
     * This is the method that generate the hascode of game
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.board);
        hash = 89 * hash + Objects.hashCode(this.current);
        hash = 89 * hash + Objects.hashCode(this.opponent);
        return hash;
    }

    /**
     * This method verfie if all the attribut of the game are equals
     *
     * @param obj
     * @return true
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
        final Game other = (Game) obj;
        if (!Objects.equals(this.board, other.board)) {
            return false;
        }
        if (!Objects.equals(this.current, other.current)) {
            return false;
        }
        if (!Objects.equals(this.opponent, other.opponent)) {
            return false;
        }
        return true;
    }

    /**
     * This method diplays the board and the players
     *
     * @return bord and players
     */
    @Override
    public String toString() {
        return "Game{" + "board=" + board + ", current=" + current + ", opponent=" + opponent + '}';
    }

    /**
     * This method decmared a new instance for the position selected
     *
     * @param row
     * @param column
     */
    @Override
    public void select(int row, int column) {
        if (this.board.isInside(new Position(row, column)) == false) {
            throw new IllegalArgumentException("les coordonnées en paramètre sont hors du plateau");
        } else if (this.board.isFree(new Position(row, column)) == true) {
            throw new IllegalArgumentException("Les coordonnées en paramètre réfère à une case vide");
        } else if (this.board.getSquare(new Position(row, column)).isMyOwn(opponent.getColor())) {
            throw new IllegalArgumentException("la case est occuper");

        }
        this.selected = new Position(row, column);

    }

    /**
     * This method return the piece à the position selected
     *
     * @return piece
     */
    @Override
    public Piece getSelected() {
        if (this.selected == null) {
            throw new IllegalArgumentException("La position selectionner est hors du tableau");
        }

        return this.board.getPiece(selected);
    }

    /**
     * This method return a list of possibilities to move a piece
     *
     * @return listeMove
     */
    @Override
    public List<Move> getMoves() {
        List<Move> listeMove = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            Move moves = new Move(getSelected(), selected, selected.next(direction));
            if (selected == null) {
                throw new IllegalArgumentException("La position selectionner est hors du tableau");
            } else if (direction != null && this.board.isInside(selected.next(direction)) && this.board.isFree(selected.next(direction))) {
                listeMove.add(moves);

            }
        }
        return listeMove;
    }

    /**
     * This method apply the moves of the player
     *
     * @param moves
     */
    @Override
    public void apply(Move moves) {
        for (Direction direction : Direction.values()) {
            if (moves == null) {
                throw new IllegalArgumentException("Le déplacement est null");
            } else if (board.isFree(selected.next(direction))) {
                board.remove(selected);
                board.put(getSelected(), selected.next(direction));
            } else if (!board.isFree(selected.next(direction))) {
                squareBusy();

            }

        }

    }

    /**
     * This method apply the rules of the game if the the piece selected has the
     * same rank or is stronger
     */
    private void squareBusy() {
        for (Direction direction : Direction.values()) {
            if (getSelected().isStronger(board.getPiece(selected.next(direction)))) {
                board.remove(selected.next(direction));
                updatePlayerPieceList();
                board.put(getSelected(), selected.next(direction));
            } else if (getSelected().hasSameRank(board.getPiece(selected.next(direction)))) {
                board.remove(selected);
                board.remove(selected.next(direction));
                updatPlayerPieceList2();
            }

        }

    }

    /**
     * This method update the list of piece of the players if a piece is
     * stronger
     */
    private void updatePlayerPieceList() {
        for (Direction direction : Direction.values()) {
            if (this.board.isMyOwn(selected.next(direction), PlayerColor.RED)) {
                this.opponent.remove(board.getPiece(selected.next(direction)));
            } else {
                this.current.remove(board.getPiece(selected.next(direction)));

            }
        }

    }

    /**
     * This method update the list if the piece has the same rank
     */
    private void updatPlayerPieceList2() {
        for (Direction direction : Direction.values()) {
            this.current.remove(board.getPiece(selected));
            this.opponent.remove(board.getPiece(selected.next(direction)));

        }

    }

    /**
     * This method swap the value of the players
     */
    public void swapPlayer() {
        Player player = this.current;
        this.current = this.opponent;
        this.opponent = player;

    }

    /**
     * This method return thr current player
     *
     * @return current player
     */
    @Override
    public Player getcurrent() {
        return this.current;
    }

}
