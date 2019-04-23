package g53554.FourInLine;

import java.util.List;

/**
 *
 * @author jussy
 */
public class Column {

    private List<Disc> discs;
    private int HEIGHT = 6;

    /**
     * The constructor of the class column
     *
     * @param discs
     */
    public Column(List<Disc> discs) {
        this.discs = discs;

    }

    /**
     * This method return a boolean if the list is full
     *
     * @return
     */
    public boolean isFull() {
        boolean full = false;
        for (int i = 0; i < this.discs.size(); i++) {
            if (i == this.HEIGHT) {
                full = true;
            }

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

}
