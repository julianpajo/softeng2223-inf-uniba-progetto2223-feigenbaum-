package it.uniba.app.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniba.app.enumType.ShipSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe che testa la classe Ship.
 */
class ShipTest {
    /**
     * Oggetto Ship che rappresenta la nave.
     */
    private Ship ship;

    /**
     * Metodo che inizializza l'oggetto Ship.
     */
    @BeforeEach
    void setUp() {
        ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
    }

    /**
     * Test del metodo getSize.
     */
    @Test
    void testGetSize() {
        assertEquals(ShipSize.DESTROYER, ship.getSize(),
                "La dimensione della nave dovrebbe essere Destroyer");
    }

    /**
     * Test del metodo getSymbol.
     */
    @Test
    void testGetSymbol() {
        assertEquals('D', ship.getSymbol(),
                "Il simbolo della nave dovrebbe essere D");
    }

    /**
     * Test del metodo getName.
     */
    @Test
    void testGetName() {
        assertEquals("Destroyer", ship.getName(),
                "Il nome della nave dovrebbe essere Destroyer");
    }

    /**
     * Test del metodo setName.
     */
    @Test
    void testSetName() {
        ship.setName("Destroyer");
        assertEquals("Destroyer", ship.getName(), "Il nome della nave "
                +
                "dovrebbe essere Destroyer");
    }

    /**
     * Test del metodo setSymbol.
     */
    @Test
    void testSetSymbol() {
        ship.setSymbol('D');
        assertEquals('D', ship.getSymbol(), "Il simbolo della nave "
                +
                "dovrebbe essere D");
    }

    /**
     * Test del metodo setSize.
     */
    @Test
    void testSetSize() {
        ship.setSize(ShipSize.DESTROYER);
        assertEquals(ShipSize.DESTROYER, ship.getSize(),
                "La dimensione della nave dovrebbe essere Destroyer");
    }

    /**
     * Test del metodo isSunk.
     */
    @Test
    void testSetSunk() {
        ship.setSunk(true);
        assertTrue(ship.isSunk(), "La nave dovrebbe essere affondata");
    }

    /**
     * Test del metodo isSunk.
     */
    @Test
    void testGetHits() {
        assertEquals(0, ship.getHits(),
                "Il numero di colpi ricevuti dalla nave dovrebbe essere 0");
    }

    /**
     * Test del metodo setHits.
     */
    @Test
    void testSetHits() {
        ship.setHits(2);
        assertEquals(2, ship.getHits(), "Il numero di colpi ricevuti dalla "
                +
                "nave dovrebbe essere 2");
    }

    /**
     * Test dei hit sulla nave.
     */
    @Test
    void testHitSunkFalse() {
        ship.hit();
        assertFalse(ship.isSunk(),
                "La nave non dovrebbe essere affondata");
    }

    /**
     * Test dei hit sulla nave.
     */
    @Test
    void testCountHits() {
        ship.hit();
        assertEquals(1, ship.getHits(),
                "Il numero di colpi ricevuti dalla nave dovrebbe essere 1");
    }

    /**
     * Test dei hit sulla nave.
     */
    @Test
    void testHitSunkTrue() {
        ship.hit();
        ship.hit();
        assertTrue(ship.isSunk(),
                "La nave dovrebbe essere affondata");
    }

    /**
     * Test se la copia è uguale all'originale.
     */
    @Test
    void testCopyName() {
        Ship copy = ship.copy();
        assertEquals(ship.getName(), copy.getName(),
                "Il nome della nave copiata dovrebbe essere uguale all'originale");
    }

    /**
     * Test se la copia è uguale all'originale.
     */
    @Test
    void testCopySize() {
        Ship copy = ship.copy();
        assertEquals(ship.getSize(), copy.getSize(),
                "La dimensione della nave copiata dovrebbe essere uguale all'originale");
    }

    /**
     * Test se la copia è uguale all'originale.
     */
    @Test
    void testCopySymbol() {
        Ship copy = ship.copy();
        assertEquals(ship.getSymbol(), copy.getSymbol(),
                "Il simbolo della nave copiata dovrebbe essere uguale all'originale");
    }

    /**
     * Test se la copia è uguale all'originale.
     */
    @Test
    void testCopyHits() {
        Ship copy = ship.copy();
        assertEquals(ship.getHits(), copy.getHits(),
                "Il numero di colpi ricevuti dalla nave copiata dovrebbe essere uguale all'originale");
    }

    /**
     * Test se la copia è uguale all'originale.
     */
    @Test
    void testCopySunk() {
        Ship copy = ship.copy();
        assertEquals(ship.isSunk(), copy.isSunk(),
                "Lo stato di affondamento della nave copiata dovrebbe essere uguale all'originale");
    }

}
