package it.uniba.app.type;

import it.uniba.app.enumType.GridSize;
import it.uniba.app.enumType.ShipSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Classe che effettua il test della classe Grid.
 */
class GridTest {
    /**
     * Oggetto di tipo Grid che rappresenta la griglia da testare.
     */
    private Grid grid;

    /**
     * Metodo che inizializza i componenti necessari per il test.
     */
    @BeforeEach
    void setUp() {
        grid = new Grid(GridSize.STANDARD);
        for (int i = 0; i < grid.getSize().getSize(); i++) { //inizializzo la griglia
            for (int j = 0; j < grid.getSize().getSize(); j++) {
                Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
                grid.setCell(i, j, new Cell(ship));
            }
        }
    }

    /**
     * Test che verifica se la griglia è stata inizializzata correttamente.
     */
    @Test
    void testGetSize() {
        assertEquals(GridSize.STANDARD, grid.getSize(),
                "La grandezza della griglia dovrà essere STANDARD");
    }

    /**
     * Test che verifica se la nave è stata ritornata correttamente.
     */
    @Test
    void testGetCellShipName() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        grid.setCell(0, 0, cell);

        assertEquals(grid.getCell(0, 0).getShip().getName(), cell.getShip().getName(),
                "Il nome della nave dovrebbe essere uguale");
    }

    /**
     * Test che verifica se la nave è stata ritornata correttamente.
     */
    @Test
    void testGetCellShipSize() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        grid.setCell(0, 0, cell);

        assertEquals(grid.getCell(0, 0).getShip().getSize(), cell.getShip().getSize(),
                "La dimensione della nave dovrebbe essere uguale");
    }

    /**
     * Test che verifica se la nave è stata ritornata correttamente.
     */
    @Test
    void testGetCellShipSymbol() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        grid.setCell(0, 0, cell);

        assertEquals(grid.getCell(0, 0).getShip().getSymbol(), cell.getShip().getSymbol(),
                "Il simbolo della nave dovrebbe essere uguale");
    }

    /**
     * Test che verifica se la nave è stata ritornata correttamente.
     */
    @Test
    void testGetCellShipHits() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        grid.setCell(0, 0, cell);

        assertEquals(grid.getCell(0, 0).getShip().getHits(), cell.getShip().getHits(),
                "Il numero di colpi ricevuti dalla nave dovrebbe essere uguale");
    }

    /**
     * Test che verifica se la nave è stata ritornata correttamente.
     */
    @Test
    void testGetCellShipSunk() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        grid.setCell(0, 0, cell);

        assertEquals(grid.getCell(0, 0).getShip().isSunk(), cell.getShip().isSunk(),
                "Lo stato di affondamento della nave dovrebbe essere uguale");
    }

    /**
     * Test che verifica se la nave è stata ritornata correttamente.
     */
    @Test
    void testGetCellIsHit() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        grid.setCell(0, 0, cell);

        assertEquals(cell.isHit(), grid.getCell(0, 0).isHit(),
                "Lo stato di colpito della cella dovrebbe essere uguale");
    }

    /**
     * Test che verifica se la nave è stata ritornata correttamente.
     */
    @Test
    void testGetCellIsShip() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        grid.setCell(0, 0, cell);

        assertEquals(cell.isShip(), grid.getCell(0, 0).isShip(),
                "Lo stato di nave nella cella dovrebbe essere uguale");
    }

    /**
     * Test che verifica se la nave è stata inserita correttamente.
     */
    @Test
    void testSetCellShipName() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        grid.setCell(0, 0, cell);
        assertEquals(grid.getCell(0, 0).getShip().getName(), cell.getShip().getName(),
                "Il nome della nave dovrebbe essere uguale");
    }

    /**
     * Test che verifica se la nave è stata inserita correttamente.
     */
    @Test
    void testSetCellShipSize() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        grid.setCell(0, 0, cell);
        assertEquals(grid.getCell(0, 0).getShip().getSize(), cell.getShip().getSize(),
                "La dimensione della nave dovrebbe essere uguale");
    }

    /**
     * Test che verifica se la nave è stata inserita correttamente.
     */
    @Test
    void testSetCellShipSymbol() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        grid.setCell(0, 0, cell);
        assertEquals(grid.getCell(0, 0).getShip().getSymbol(), cell.getShip().getSymbol(),
                "Il simbolo della nave dovrebbe essere uguale");
    }

    /**
     * Test che verifica se la nave è stata inserita correttamente.
     */
    @Test
    void testSetCellShipHits() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        grid.setCell(0, 0, cell);
        assertEquals(grid.getCell(0, 0).getShip().getHits(), cell.getShip().getHits(),
                "Il numero di colpi ricevuti dalla nave dovrebbe essere uguale");
    }

    /**
     * Test che verifica se la nave è stata inserita correttamente.
     */
    @Test
    void testSetCellShipSunk() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        grid.setCell(0, 0, cell);
        assertEquals(grid.getCell(0, 0).getShip().isSunk(), cell.getShip().isSunk(),
                "Lo stato di affondamento della nave dovrebbe essere uguale");
    }

    /**
     * Test che verifica se la nave è stata inserita correttamente.
     */
    @Test
    void testSetCellIsHit() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        cell.setHit(true);
        grid.setCell(0, 0, cell);
        assertEquals(cell.isHit(), grid.getCell(0, 0).isHit(),
                "Lo stato di colpito della cella dovrebbe essere uguale");
    }

    /**
     * Test che verifica se la nave è stata inserita correttamente.
     */
    @Test
    void testSetCellIsShip() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        cell.setHit(true);
        grid.setCell(0, 0, cell);
        assertEquals(cell.isShip(), grid.getCell(0, 0).isShip(),
                "Lo stato di nave nella cella dovrebbe essere uguale");
    }

    /**
     * Test che verifica se la cella è una nave.
     */
    @Test
    void testIsShip() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        grid.setCell(0, 0, cell);
        assertTrue(grid.isShip(0, 0), "La cella dovrebbe essere una nave");
    }

    /**
     * Test che verifica se la cella è stata colpita.
     */
    @Test
    void testHit() {
        for (int i = 0; i < grid.getSize().getSize(); i++) { //inizializzo la griglia
            for (int j = 0; j < grid.getSize().getSize(); j++) {
                grid.setCell(i, j, new Cell(i, j));
            }
        }
        Cell cell = new Cell(new Ship("Destroyer",
                ShipSize.DESTROYER, 'D'));
        cell.setHit(true);
        grid.setCell(0, 0, cell);
        assertTrue(grid.hit(0, 0), "La cella dovrebbe essere stata colpita");
    }
    /**
     * Test che verifica se la griglia è stata copiata correttamente.
     */
    @Test
    void testCopyCellShipName() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        grid.setCell(0, 0, cell);

        Grid clone = grid.copy();

        for (int i = 0; i < grid.getSize().getSize(); i++) {
            for (int j = 0; j < grid.getSize().getSize(); j++) {
                assertEquals(grid.getCell(i, j).getShip().getName(), clone.getCell(i, j).getShip().getName(),
                        "Il nome della nave nella cella dovrebbe essere uguale");
            }
        }
    }

    /**
     * Test che verifica se la griglia è stata copiata correttamente.
     */
    @Test
    void testCopyCellShipSize() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        grid.setCell(0, 0, cell);

        Grid clone = grid.copy();

        for (int i = 0; i < grid.getSize().getSize(); i++) {
            for (int j = 0; j < grid.getSize().getSize(); j++) {
                assertEquals(grid.getCell(i, j).getShip().getSize(), clone.getCell(i, j).getShip().getSize(),
                        "La dimensione della nave nella cella dovrebbe essere uguale");
            }
        }
    }

    /**
     * Test che verifica se la griglia è stata copiata correttamente.
     */
    @Test
    void testCopyCellShipSymbol() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        grid.setCell(0, 0, cell);

        Grid clone = grid.copy();

        for (int i = 0; i < grid.getSize().getSize(); i++) {
            for (int j = 0; j < grid.getSize().getSize(); j++) {
                assertEquals(grid.getCell(i, j).getShip().getSymbol(), clone.getCell(i, j).getShip().getSymbol(),
                        "Il simbolo della nave nella cella dovrebbe essere uguale");
            }
        }
    }

    /**
     * Test che verifica se la griglia è stata copiata correttamente.
     */
    @Test
    void testCopyCellShipHits() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        grid.setCell(0, 0, cell);

        Grid clone = grid.copy();

        for (int i = 0; i < grid.getSize().getSize(); i++) {
            for (int j = 0; j < grid.getSize().getSize(); j++) {
                assertEquals(grid.getCell(i, j).getShip().getHits(), clone.getCell(i, j).getShip().getHits(),
                        "Il numero di colpi ricevuti dalla nave nella cella dovrebbe essere uguale");
            }
        }
    }

    /**
     * Test che verifica se la griglia è stata copiata correttamente.
     */
    @Test
    void testCopyCellShipSunk() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        grid.setCell(0, 0, cell);

        Grid clone = grid.copy();

        for (int i = 0; i < grid.getSize().getSize(); i++) {
            for (int j = 0; j < grid.getSize().getSize(); j++) {
                assertEquals(grid.getCell(i, j).getShip().isSunk(), clone.getCell(i, j).getShip().isSunk(),
                        "Lo stato di affondamento della nave nella cella dovrebbe essere uguale");
            }
        }
    }

    /**
     * Test che verifica se la griglia è stata copiata correttamente.
     */
    @Test
    void testCopyCellIsHit() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        cell.setHit(true);
        grid.setCell(0, 0, cell);

        Grid clone = grid.copy();

        for (int i = 0; i < grid.getSize().getSize(); i++) {
            for (int j = 0; j < grid.getSize().getSize(); j++) {
                assertEquals(grid.getCell(i, j).isHit(), clone.getCell(i, j).isHit(),
                        "Lo stato di colpito della cella dovrebbe essere uguale");
            }
        }
    }

    /**
     * Test che verifica se la griglia è stata copiata correttamente.
     */
    @Test
    void testCopyCellIsShip() {
        Ship ship = new Ship("Destroyer", ShipSize.DESTROYER, 'D');
        Cell cell = new Cell(ship);
        grid.setCell(0, 0, cell);

        Grid clone = grid.copy();

        for (int i = 0; i < grid.getSize().getSize(); i++) {
            for (int j = 0; j < grid.getSize().getSize(); j++) {
                assertEquals(grid.getCell(i, j).isShip(), clone.getCell(i, j).isShip(),
                        "Lo stato di nave nella cella dovrebbe essere uguale");
            }
        }
    }


}
