package it.uniba.app.type;

import it.uniba.app.enumType.ShipSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe che testa la classe Capitalship.
 */
class CarrierTest {
    /**
     * Oggetto Ship che rappresenta la nave.
     */
    private Ship ship;

    /**
     * Metodo che inizializza l'oggetto Ship.
     */
    @BeforeEach
    void setUp() {
        ship = new Ship("Carrier",
                ShipSize.CARRIER, 'A');
    }

    /**
     * Test del metodo getSize.
     */
    @Test
    void testGetSize() {
        assertEquals(ShipSize.CARRIER, ship.getSize(),
                "La grandezza della nave dovrebbe essere CARRIER");
    }

    /**
     * Test del metodo getSymbol.
     */
    @Test
    void testGetSymbol() {
        assertEquals('A',
                ship.getSymbol(), "Il simbolo della nave dovrebbe essere A");
    }

    /**
     * Test del metodo getName.
     */
    @Test
    void testGetName() {
        assertEquals("Carrier",
                ship.getName(), "Il nome della nave dovrebbe essere Carrier");
    }

}
