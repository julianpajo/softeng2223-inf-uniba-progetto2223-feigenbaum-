package it.uniba.app.type;

import it.uniba.app.enumType.ShipSize;

/**
 * Classe che rappresenta la nave Carrier.
 */
public class Carrier extends Ship {
    /**
     * Costruttore della classe Carrier.
     */
    public Carrier() {
        super("Carrier", ShipSize.CARRIER, 'A');

    }
}
