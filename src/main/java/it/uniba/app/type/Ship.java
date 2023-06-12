package it.uniba.app.type;

import it.uniba.app.enumType.ShipSize;

/**
 * Classe che rappresenta la nave.
 */
public class Ship {
    /**
     * private String che rappresenta il nome della nave.
     */
    private String name;
    /**
     * Private char che rappresenta il simbolo della nave.
     */
    private char symbol;
    /**
     * Private ShipSize che rappresenta la dimensione della nave.
     */
    private ShipSize size;
    /**
     * Private int che rappresenta il numero di colpi ricevuti dalla nave.
     */
    private int hits;
    /**
     * Private boolean che rappresenta se la nave è affondata o meno.
     */
    private boolean sunk;
    /**
     * Costruttore della classe Ship.
     * @param shipName
     * @param shipSymbol
     * @param shipSize
     */
    public Ship(
            final String shipName, final ShipSize shipSize, final char shipSymbol
    ) {
        this.name = shipName;
        this.symbol = shipSymbol;
        this.size = shipSize;
    }
    /**
     * ritorna la dimensione della nave.
     * @return size
     */
    public ShipSize getSize() {
        return size;
    }
    /**
     * ritorna il simbolo della nave.
     * @return symbol
     */
    public char getSymbol() {
        return symbol;
    }
    /**
     * ritorna il nome della nave.
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * imposta il nome della nave.
     * @param shipName
     */
    public void setName(final String shipName) {
        this.name = shipName;
    }
    /**
     * imposta il simbolo della nave.
     * @param shipSymbol
     */
    public void setSymbol(final char shipSymbol) {
        this.symbol = shipSymbol;
    }
    /**
     * imposta la dimensione della nave.
     * @param shipSize
     */
    public void setSize(final ShipSize shipSize) {
        this.size = shipSize;
    }
    /**
     * ritorna se la nave è affondata o meno.
     * @return sunk
     */
    public boolean isSunk() {
        return sunk;
    }
    /**
     * imposta se la nave è affondata o meno.
     * @param sunkParam
     */
    public void setSunk(final boolean sunkParam) {
        this.sunk = sunkParam;
    }
    /**
     * ritorna il numero di colpi ricevuti dalla nave.
     * @return hits
     */
    public int getHits() {
        return hits;
    }
    /**
     * imposta il numero di colpi ricevuti dalla nave.
     * @param hitsParam
     */
    public void setHits(final int hitsParam) {
        this.hits = hitsParam;
    }
    /**
     * registra un colpo ricevuto dalla nave.
     */
    public void hit() {
        this.hits++;
        if (this.hits == this.size.getSize()) {
            this.sunk = true;
        }
    }
    /**
     * ritorna una copia della nave.
     * @return Ship
     */
    public Ship copy() {
        Ship copy = new Ship(this.name, this.size, this.symbol);
        copy.setHits(this.hits);
        copy.setSunk(this.sunk);
        return copy;
    }
}
