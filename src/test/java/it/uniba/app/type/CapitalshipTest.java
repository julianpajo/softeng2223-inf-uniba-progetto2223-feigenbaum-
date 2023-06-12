package it.uniba.app.type;

import it.uniba.app.enumType.ShipSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe che testa la classe Capitalship.
 */
class CapitalshipTest {
    /**
     * Oggetto Ship che rappresenta la nave.
     */
    private Ship ship;

    /**
     * Metodo che inizializza l'oggetto Ship.
     */
    @BeforeEach
    void setUp() {
        ship = new Ship("Capitalship",
                ShipSize.CAPITALSHIP, 'R');
    }

    /**
     * Test del metodo getSize.
     */
    @Test
    void testGetSize() {
        assertEquals(ShipSize.CAPITALSHIP, ship.getSize(),
                "La grandezza della nave dovrebbe essere CAPITALSHIP");
    }

    /**
     * Test del metodo getSymbol.
     */
    @Test
    void testGetSymbol() {
        assertEquals('R',
                ship.getSymbol(), "Il simbolo della nave dovrebbe essere R");
    }

    /**
     * Test del metodo getName.
     */
    @Test
    void testGetName() {
        assertEquals("Capitalship",
                ship.getName(), "Il nome della nave dovrebbe essere Capitalship");
    }

}
