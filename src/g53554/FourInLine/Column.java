package g53554.FourInLine;

import java.util.List;

/**
 *
 * @author jussy
 */
public class Column {

    List<Disc> discs;
    int HEIGHT = 6;

    /**
     * The constructor of the class column
     *
     * @param discs
     */
    public Column(List<Disc> discs) {
        this.discs = discs;

    }

    /**
     *
     */
    public Column() {
    }

    /**
     * This method return a boolean if the list is full
     *
     * @return
     */
    public boolean isFull() {
        boolean full = false;
        if (HEIGHT == this.discs.size()) {
            full = true;

        }

        return full;
    }

    /**
     * This method add a disk to the column
     *
     * @param disc
     */
    public void drop(Disc disc) {
        Column column = new Column(discs);
        if (column.isFull()) {
            throw new IllegalStateException("La colonne est remplie");
        } else {
            column.discs.add(disc);
        }

    }

    /**
     * This method return the disc at the postion i in parameter
     *
     * @param i
     * @return disc
     */
    public Disc get(int i) {
        Disc disc = null;
        for (int j = 0; j < this.discs.size(); j++) {
            if (i == j) {
                disc = this.discs.get(j);

            }

        }
        return disc;

    }

    /**
     * This method verifie if their is four equals piece in the same column with
     * the same color
     *
     * @return win
     */
    public boolean isWinning() {
        boolean win = false;
        for (int i = 0; i < this.discs.size(); i++) {
            if (this.discs.get(i).equals(this.discs.get(i)) && this.discs.get(i) == Disc.RED || this.discs.get(i) == Disc.YELLOW) {
                win = true;

            }
        }

        return win;

    }

}
