package g53554.stratego.main;

/**
 * Cette classe permet l'écriture d'un texte coloré 4/11/2104 - Ajout d'un main
 * - MCD
 */
public class Color {

    /**
     * Méthode de couleur default du BASH.
     *
     * @return La couleur default.
     */
    private String toDefault() {
        return "\033[0m";
    }

    /**
     * Colorie une chaine en noir.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public String toBlack(String a) {
        return "\033[30m" + a + toDefault();
    }

    /**
     * Colorie une chaine en rouge.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public String toRed(String a) {
        return "\033[31m" + a + toDefault();
    }

    /**
     * Colorie une chaine en vert.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public String toGreen(String a) {
        return "\033[32m" + a + toDefault();
    }

    /**
     * Colorie une chaine en jaune.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public String toYellow(String a) {
        return "\033[33m" + a + toDefault();
    }

    /**
     * Colorie une chaine en bleu.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public String toBlue(String a) {
        return "\033[34m" + a + toDefault();
    }

    /**
     * Colorie une chaine en mauve.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public String toPurple(String a) {
        return "\033[35m" + a + toDefault();
    }

    /**
     * Colorie une chaine en cyan.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public String toCyan(String a) {
        return "\033[36m" + a + toDefault();
    }

    /**
     * Colorie une chaine en blanc.
     *
     * @param a La chaine à colorer.
     * @return La chaine colorée.
     */
    public String toWhite(String a) {
        return "\033[37m" + a + toDefault();
    }

    /**
     * Affiche un message coloré pour montrer le but de la classe.
     */
}
