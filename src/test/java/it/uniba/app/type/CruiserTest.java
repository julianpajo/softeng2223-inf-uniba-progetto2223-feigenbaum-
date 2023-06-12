package it.uniba.app.type;

import it.uniba.app.enumType.ShipSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe che testa la classe Capitalship.
 */
class CruiserTest {
    /**
     * Oggetto Ship che rappresenta la nave.
     */
    private Ship ship;

    /**
     * Metodo che inizializza l'oggetto Ship.
     */
    @BeforeEach
    void setUp() {
        ship = new Ship("Cruiser",
                ShipSize.CRUISER, 'I');
    }

    /**
     * Test del metodo getSize.
     */
    @Test
    void testGetSize() {
        assertEquals(ShipSize.CRUISER, ship.getSize(),
                "La nave non è di tipo Cruiser");
    }

    /**
     * Test del metodo getSymbol.
     */
    @Test
    void testGetSymbol() {
        assertEquals('I',
                ship.getSymbol(), "Il simbolo dovrebbe essere I");
    }

    /**
     * Test del metodo getName.
     */
    @Test
    void testGetName() {
        assertEquals("Cruiser",
                ship.getName(), "Il nome dovrebbe essere Cruiser");
    }

}
