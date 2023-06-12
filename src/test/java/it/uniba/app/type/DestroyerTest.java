package it.uniba.app.type;

import it.uniba.app.enumType.ShipSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe che testa la classe Capitalship.
 */
class DestroyerTest {
    /**
     * Oggetto Ship che rappresenta la nave.
     */
    private Ship ship;

    /**
     * Metodo che inizializza l'oggetto Ship.
     */
    @BeforeEach
    void setUp() {
        ship = new Ship("Destroyer",
                ShipSize.DESTROYER, 'D');
    }

    /**
     * Test del metodo getSize.
     */
    @Test
    void testGetSize() {
        assertEquals(ShipSize.DESTROYER, ship.getSize(),
                "La grandezza della nave dovrebbe essere DESTROYER");
    }

    /**
     * Test del metodo getSymbol.
     */
    @Test
    void testGetSymbol() {
        assertEquals('D',
                ship.getSymbol(), "Il simbolo della nave dovrebbe essere D");
    }

    /**
     * Test del metodo getName.
     */
    @Test
    void testGetName() {
        assertEquals("Destroyer",
                ship.getName(), "Il nome della nave dovrebbe essere Destroyer");
    }

}
