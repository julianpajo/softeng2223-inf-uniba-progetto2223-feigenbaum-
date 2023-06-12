package it.uniba.app.type;

import it.uniba.app.enumType.GridSize;

/**
 * Classe che rappresenta la griglia di gioco.
 */
public class Grid {
    /**
     * Attributo che rappresenta la griglia di gioco.
     */
    private Cell[][] grid;
    /**
     * Attributo che rappresenta la dimensione della griglia.
     */
    private GridSize size;
    /**
     * Costruttore della classe.
     * @param sizeParam
     */
    public Grid(final GridSize sizeParam) {
        this.size = sizeParam;
        int intSize = size.getSize();
        grid = new Cell[intSize][intSize];
        for (int i = 0; i < intSize; i++) {
            for (int j = 0; j < intSize; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }
    }
    /**
     * Metodo che ritorna la dimensione della griglia.
     * @return size
     */
    public GridSize getSize() {
        return size;
    }
    /**
     * Metodo che ritorna la griglia di gioco.
     * @param x coordinate x.
     * @param y coordinate y.
     * @return .
     */
    public Cell getCell(final int x, final int y) {
        return grid[x][y].copy();
    }
    /**
     * Metodo che setta la griglia di gioco.
     *@param x coordinate x.
     *@param y coordinate y.
     *@param cell cella.
     */
    public void setCell(final int x, final int y, final Cell cell) {
        grid[x][y] = cell;
    }
    /**
     * Metodo che ritorna se è presente una nave nella cella.
     * @param x coordinate x.
     * @param y coordinate y.
     * @return true se è presente una nave, false altrimenti.
     */
    public boolean isShip(final int x, final int y) {
        return grid[x][y].isShip();
    }

    /**
     * Metodo che ritorna se è stata colpita una nave nella cella.
     * @param x coordinate x.
     * @param y coordinate y.
     * @return true se è stata colpita una nave, false altrimenti.
     */
    public boolean hit(final int x, final int y) {
        return grid[x][y].hit();
    }

    /** Metodo per copiare la griglia.
     * @return copia della griglia.
     */
    public Grid copy() {
        Grid clone = new Grid(size);
        for (int i = 0; i < size.getSize(); i++) {
            for (int j = 0; j < size.getSize(); j++) {
                clone.setCell(i, j, grid[i][j].copy());
            }
        }
        return clone;
    }



}
