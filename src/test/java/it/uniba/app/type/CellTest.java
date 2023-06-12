package it.uniba.app.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniba.app.enumType.ShipSize;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Classe che effettua il test della classe Cell.
 */
class CellTest {
    /**
     * Oggetto di tipo Cell che rappresenta la cella da testare.
     */
    private Cell cell;
    /**
     * Oggetto di tipo Ship che rappresenta la nave da inserire nella cella.
     */
    private Ship ship;

    /**
     * Metodo che inizializza i componenti necessari per il test.
     */
    @BeforeEach
    void setUp() {
        ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        cell = new Cell(ship);
    }

    /**
     * Test se la nave impostata nella cella è corretta.
     */
    @Test
    void testSetShipName()
            throws InvocationTargetException, IllegalAccessException,
            NoSuchMethodException {
        Ship newShip = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Method setShipMethod = Cell.class.getDeclaredMethod("setShip", Ship.class);
        setShipMethod.setAccessible(true);
        setShipMethod.invoke(cell, newShip);

        assertEquals(newShip.getName(), cell.getShip().getName(),
                "Il nome della nave nella cella dovrebbe essere corretto");
    }

    /**
     * Test se la nave impostata nella cella è corretta.
     */
    @Test
    void testSetShipSize()
            throws InvocationTargetException, IllegalAccessException,
            NoSuchMethodException {
        Ship newShip = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Method setShipMethod = Cell.class.getDeclaredMethod("setShip", Ship.class);
        setShipMethod.setAccessible(true);
        setShipMethod.invoke(cell, newShip);

        assertEquals(newShip.getSize(), cell.getShip().getSize(),
                "La dimensione della nave nella cella dovrebbe essere corretta");
    }

    /**
     * Test se la nave impostata nella cella è corretta.
     */
    @Test
    void testSetShipSymbol()
            throws InvocationTargetException, IllegalAccessException,
            NoSuchMethodException  {
        Ship newShip = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Method setShipMethod = Cell.class.getDeclaredMethod("setShip", Ship.class);
        setShipMethod.setAccessible(true);
        setShipMethod.invoke(cell, newShip);

        assertEquals(newShip.getSymbol(), cell.getShip().getSymbol(),
                "Il simbolo della nave nella cella dovrebbe essere corretto");
    }

    /**
     * Test se la nave impostata nella cella è corretta.
     */
    @Test
    void testSetShipHits()
            throws InvocationTargetException, IllegalAccessException,
            NoSuchMethodException {
        Ship newShip = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Method setShipMethod = Cell.class.getDeclaredMethod("setShip", Ship.class);
        setShipMethod.setAccessible(true);
        setShipMethod.invoke(cell, newShip);

        assertEquals(newShip.getHits(), cell.getShip().getHits(),
                "Il numero di colpi ricevuti dalla nave nella cella dovrebbe essere corretto");
    }

    /**
     * Test se la nave impostata nella cella è corretta.
     */
    @Test
    void testSetShipSunk()
            throws InvocationTargetException, IllegalAccessException,
            NoSuchMethodException {
        Ship newShip = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Method setShipMethod = Cell.class.getDeclaredMethod("setShip", Ship.class);
        setShipMethod.setAccessible(true);
        setShipMethod.invoke(cell, newShip);

        assertEquals(newShip.isSunk(), cell.getShip().isSunk(),
                "Lo stato di affondamento della nave nella cella dovrebbe essere corretto");
    }

    /**
     * Test che verifica se la cella è stata colpita.
     */
    @Test
    void testIsHitFalse() {
        cell.setHit(false);
        assertFalse(cell.isHit(),
                "La cella non dovrebbe essere stata colpita");
    }

    /**
     * Test che verifica che il setHit ritorni il valore corretto.
     */
    @Test
    void testIsHitTrue() {
        cell.setHit(true);
        assertTrue(cell.isHit(),
                "La cella dovrebbe essere stata colpita");
    }

    /**
     * Test che verifica se il ritorno del metodo è corretto.
     */
    @Test
    void testGetShipName() {
        assertEquals(ship.getName(), cell.getShip().getName(),
                "Il nome della nave nella cella dovrebbe essere corretto");
    }

    /**
     * Test che verifica se il ritorno del metodo è corretto.
     */
    @Test
    void testGetShipSize() {
        assertEquals(ship.getSize(), cell.getShip().getSize(),
                "La dimensione della nave nella cella dovrebbe essere corretta");
    }

    /**
     * Test che verifica se il ritorno del metodo è corretto.
     */
    @Test
    void testGetShipSymbol() {
        assertEquals(ship.getSymbol(), cell.getShip().getSymbol(),
                "Il simbolo della nave nella cella dovrebbe essere corretto");
    }

    /**
     * Test che verifica se il ritorno del metodo è corretto.
     */
    @Test
    void testGetShipHits() {
        assertEquals(ship.getHits(), cell.getShip().getHits(),
                "Il numero di colpi ricevuti dalla nave nella cella dovrebbe essere corretto");
    }

    /**
     * Test che verifica se il ritorno del metodo è corretto.
     */
    @Test
    void testGetShipSunk() {
        assertEquals(ship.isSunk(), cell.getShip().isSunk(),
                "Lo stato di affondamento della nave nella cella dovrebbe essere corretto");
    }

    /**
     * Test che verifica se la copia della cella è uguale all'originale.
     */
    @Test
    void testCopyHit() {
        Cell clone = cell.copy();
        assertEquals(cell.isHit(), clone.isHit(),
                "Lo stato di colpita della cella dovrebbe essere uguale alla copia");
    }

    /**
     * Test che verifica se la copia della cella è uguale all'originale.
     */
    @Test
    void testCopyIsShip() {
        Cell clone = cell.copy();
        assertEquals(cell.isShip(), clone.isShip(),
                "Lo stato di contenere una nave della cella dovrebbe essere uguale alla copia");
    }

    /**
     * Test che verifica se la copia della cella è uguale all'originale.
     */
    @Test
    void testCopyShipName() {
        Cell clone = cell.copy();
        assertEquals(cell.getShip().getName(), clone.getShip().getName(),
                "Il nome della nave nella cella copiata dovrebbe essere corretto");
    }

    /**
     * Test che verifica se la copia della cella è uguale all'originale.
     */
    @Test
    void testCopyShipSize() {
        Cell clone = cell.copy();
        assertEquals(cell.getShip().getSize(), clone.getShip().getSize(),
                "La dimensione della nave nella cella copiata dovrebbe essere corretta");
    }

    /**
     * Test che verifica se la copia della cella è uguale all'originale.
     */
    @Test
    void testCopyShipSymbol() {
        Cell clone = cell.copy();
        assertEquals(cell.getShip().getSymbol(), clone.getShip().getSymbol(),
                "Il simbolo della nave nella cella copiata dovrebbe essere corretto");
    }

    /**
     * Test che verifica se la copia della cella è uguale all'originale.
     */
    @Test
    void testCopyShipHits() {
        Cell clone = cell.copy();
        assertEquals(cell.getShip().getHits(), clone.getShip().getHits(),
                "Il numero di colpi ricevuti dalla nave nella cella copiata dovrebbe essere corretto");
    }

    /**
     * Test che verifica se la copia della cella è uguale all'originale.
     */
    @Test
    void testCopyShipSunk() {
        Cell clone = cell.copy();
        assertEquals(cell.getShip().isSunk(), clone.getShip().isSunk(),
                "Lo stato di affondamento della nave nella cella copiata dovrebbe essere corretto");
    }

    /**
     * Test che verifica se la cella è occupata da una nave.
     */
    @Test
    void testIsShip() {
        assertTrue(cell.isShip(),
                "La cella dovrebbe essere occupata da una nave");
    }
}
