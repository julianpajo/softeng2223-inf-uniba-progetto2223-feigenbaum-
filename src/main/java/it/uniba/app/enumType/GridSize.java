package it.uniba.app.enumType;
/**
 * Enumerazione che definisce le dimensioni della griglia di gioco.
 */
public enum GridSize {
    /**
     * Dimensioni della griglia piccola, media e grande.
     */
    STANDARD(10), LARGE(18), EXTRA_LARGE(26);
    /**
     * private final int che indica la dimensione della griglia.
     */
    private final int size;
    /**
     * Costruttore della classe.
     * @param sizeParam
     */
    GridSize(final int sizeParam) {
        this.size = sizeParam;
    }
    /**
     * metodo che ritorna la dimensione della griglia.
     * @return size
     */
    public int getSize() {
        return size;
    }


}
