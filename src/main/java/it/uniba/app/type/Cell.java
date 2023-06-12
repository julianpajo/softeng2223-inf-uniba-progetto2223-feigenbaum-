package it.uniba.app.type;
/**
 * classe che rappresenta una cella della griglia.
 */
public class Cell {
    /**
     * private boolean che indica se la cella è stata colpita.
     */
    private boolean hit;
    /**
     * private int che indica la posizione x della cella.
     */
    private int posX;
    /**
     * private int che indica la posizione y della cella.
     */
    private int posY;
    /**
     * private Ship che indica la nave che occupa la cella.
     */
    private Ship ship;
    /**
     *  Costruttore della classe.
     *  @param posXParam
     *  @param posYParam
     */
    public Cell(final int posXParam, final int posYParam) {
        this.posX = posXParam;
        this.posY = posYParam;
        this.hit = false;
        this.ship = null;
    }
    /**
     * Costruttore della classe.
     * @param shipParam
     */
    public Cell(final Ship shipParam) {
        setShip(shipParam);
    }
    /**
     * metodo che imposta se la cella è stata colpita.
     * @param hitParam
     */
    public void setHit(final boolean hitParam) {
        this.hit = hitParam;
    }
    /**
     * metodo che imposta la nave che occupa la cella.
     * @param shipParam
     */
    private void setShip(final Ship shipParam) {
        this.ship = shipParam;
    }
    /**
     * metodo che ritorna se la cella è stata colpita.
     * @return hit
     */
    public boolean isHit() {
        return hit;
    }
    /**
     * metodo che ritorna la nave che occupa la cella.
     * @return ship
     */
    public Ship getShip() {
        return ship.copy();
    }
    /**
     * metodo che ritorna se la cella è occupata da una nave.
     * @return true se la cella è occupata da una nave, false altrimenti
     */
    public boolean isShip() {
        return ship != null;
    }

    /**
     * metodo che ritorna se la colpita ha una nave.
     * @return true se la ha una nave colpita, false altrimenti.
     */
    public boolean hit() {
            this.hit = true;
            if (this.isShip()) {
                this.ship.hit();
                return true;
            }
            return false;
    }

    /**
     * Ritorna una copia della cella.
     * @return cella clonata.
     */
    public Cell copy() {
            Cell cell = new Cell(this.posX, this.posY);
            cell.setHit(this.hit);
            if (this.ship != null) {
                cell.setShip(this.ship);
            }
            return cell;
    }
}
