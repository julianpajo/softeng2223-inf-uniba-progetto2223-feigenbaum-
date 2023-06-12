package it.uniba.app.enumType;
/**
 * Enumerazione che definisce le dimensioni delle navi di gioco.
 */
public enum ShipSize {
    /**
     * Dimensioni delle diverse navi.
     */
    CRUISER(3), DESTROYER(2), CAPITALSHIP(4), CARRIER(5);
    /**
     * private final int che indica la dimensione della nave.
     */
    private final int size;
    /**
     * Costruttore della classe.
     * @param sizeParam
     */
    ShipSize(final int sizeParam) {
        this.size = sizeParam;
    }
    /**
     * metodo che ritorna la dimensione della nave.
     * @return size
     */
    public int getSize() {
        return size;
    }


}
