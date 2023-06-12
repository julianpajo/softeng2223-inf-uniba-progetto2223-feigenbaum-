package it.uniba.app;

import it.uniba.app.enumType.ResultType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniba.app.enumType.Difficulty;
import it.uniba.app.enumType.GridSize;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe di test per la classe Game.
 */
class GameTest {
    /**
     * Variabile che rappresenta un oggetto Game.
     */
    private Game game;
    /**
     *  Variabile che rappresenta la dimensione della griglia.
     */
    private GridSize gridSize = GridSize.STANDARD;
    /**
     * Variabile che rappresenta le lettere delle colonne della griglia.
     */
    private final String[]  columsLabels = {"A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z"};

    private Random random;

    /**
     * Metodo che inizializza un nuovo oggetto Game prima di ogni test.
     */
    @BeforeEach
    void setUp() {
        game = new Game(GridSize.STANDARD, Difficulty.MEDIUM);
        random = new Random();
    }


    /**
     * Test che verifica che il metodo hit() restituisca true quando
     * viene colpita una cella con una nave.
     */
    @Test
    void testHitSuccessful() {
        ResultType result = ResultType.MISS;
        for (int i = 0; i < gridSize.getSize(); i++) {
            for (int j = 0; j < gridSize.getSize(); j++) {
                if (game.getGrid().getCell(i, j).isShip()) {
                    result = game.hit(columsLabels[j], i + 1);
                    assertEquals(ResultType.HIT, result, "l'hit dovrebbe essere andato a segno");
                    break;
                }
                if (result == ResultType.HIT) {
                    break;
                }
            }
            if (result == ResultType.HIT) {
                break;
            }
        }
    }

    /**
     * Test che verifica che il metodo hit() restituisca false quando
     * viene colpita una cella senza una nave.
     */
    @Test
    void testHitUnsuccessful() {

        for (int i = 0; i < gridSize.getSize(); i++) {
            for (int j = 0; j < gridSize.getSize(); j++) {
                if (!game.getGrid().getCell(i, j).isShip()) {
                    ResultType result = game.hit(columsLabels[j], i + 1);
                    assertEquals(ResultType.MISS, result, "l'hit non dovrebbe essere andato a segno");
                }
            }
        }
    }

    /**
     * Test che verifica che il metodo hit() restituisca true quando
     * viene colpita una cella con una nave e che la nave sia affondata.
     */
    @Test
    void testHitSuccessfulAndSunk() {
        ResultType result = ResultType.MISS;
        int i;
        int j = 0;
        for (i = 0; i < gridSize.getSize(); i++) {
            for (j = 0; j < gridSize.getSize(); j++) {
                if (game.getGrid().getCell(i, j).isShip()) {
                    result = game.hit(columsLabels[j], i + 1);
                    break;
                }
                if (result == ResultType.HIT) {
                    break;
                }
            }
            if (result == ResultType.HIT) {
                break;
            }
        }
        int row = i;
        int col = j;
        if (result == ResultType.HIT) {
            int sizeOfShipHit = game.getGrid().getCell(row, col).getShip().getSize().getSize();
            int hits = game.getGrid().getCell(i, col).getShip().getHits();
            //caso nave orrizzontale
            for (int k = col + 1; k < col + sizeOfShipHit; k++) {
                if (game.getGrid().getCell(row, k).isShip()) {
                    if (game.getGrid().getCell(row, k).getShip().getHits() == hits) {
                        result = game.hit(columsLabels[k], row + 1);
                        hits = game.getGrid().getCell(i, col).getShip().getHits();
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (result != ResultType.HITANDSUNK) {
                //caso nave verticale
                for (int t = row + 1; t < row + sizeOfShipHit; t++) {
                    if (game.getGrid().getCell(t, col).isShip()) {
                        if (game.getGrid().getCell(t, col).getShip().getHits() == hits) {
                            result = game.hit(columsLabels[col], t + 1);
                            hits = game.getGrid().getCell(i, col).getShip().getHits();
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            assertEquals(ResultType.HITANDSUNK, result, "l'hit dovrebbe essere andato a segno e la nave dovrebbe "
                    +
                    "essere affondata");
        }
    }


    /**
     * Test che verifica che set difficulty() imposti la difficoltà
     * corretta.
     */
    @Test
    void testSetDifficulty() {
        Difficulty newDifficulty = Difficulty.EASY;
        game.setDifficulty(newDifficulty);
        Difficulty currentDifficulty = game.getDifficulty();
        assertEquals(newDifficulty, currentDifficulty, "la difficoltà dovrebbe essere "
                +
                " stata impostata correttamente");
    }

    /**
     * Test che verifica che set gridSize() imposti la dimensione
     * della griglia corretta.
     */
    @Test
    void testSetGridSize() {
        GridSize newGridSize = GridSize.STANDARD;
        game.setGridSize(newGridSize);
        GridSize currentGridSize = game.getGrid().getSize();
        assertEquals(newGridSize, currentGridSize, "la dimensione della griglia dovrebbe "
                +
                "essere stata impostata correttamente");
    }

    /**
     * Test che verifica che getAttempts() restituisca il numero di
     * tentativi corretto quando sono stati effettuati colpi
     * andati a segno.
     */
    @Test
    void testGetRemaningAttemptsWhenHit() {

        int x = random.nextInt(gridSize.getSize());
        int y = random.nextInt(gridSize.getSize());

        int remainingAttempts;
        System.out.println("x: " + x + " y: " + y);
        if (game.hit(columsLabels[x], y + 1) == ResultType.HIT) {
            remainingAttempts = game.getRemaningAttempts();
            assertEquals(game.getAttempts(), remainingAttempts, "il numero di tentativi "
                    +
                    "rimanenti dovrebbe essere uguale al numero di tentativi iniziali");
        }
    }

    /**
     * Test che verifica che getAttempts() restituisca il numero di
     * tentativi corretto quando sono stati effettuati colpi non
     * andati a segno.
     */
    @Test
    void testGetRemaningAttemptsWhenMiss() {
        int x = random.nextInt(gridSize.getSize());
        int y = random.nextInt(gridSize.getSize());

        int remainingAttempts;

        if (game.hit(columsLabels[x], y + 1) == ResultType.MISS) {
            remainingAttempts = game.getRemaningAttempts();
            assertEquals(game.getAttempts() - 1, remainingAttempts, "il numero di tentativi "
                    +
                    "rimanenti dovrebbe essere uguale al numero di tentativi iniziali - 1");
        }
    }

    /**
     * Test che verifica che la difficoltà della copia sia
     * uguale a quella dell'oggetto originale.
     */
    @Test
    void testCopyDifficulty() {
        Game gameCopy = game.copy();
        assertEquals(game.getDifficulty(), gameCopy.getDifficulty(), "la "
                +
                "difficoltà dovrebbe essere uguale");
    }

    /**
     * Test che verifica che il numero di tentativi della copia sia
     * uguale a quello dell'oggetto originale.
     */
    @Test
    void testCopyAttempts() {
        Game gameCopy = game.copy();
        assertEquals(game.getAttempts(), gameCopy.getAttempts(),
                "Il numero di tentativi dovrebbe essere uguale");
    }

    /**
     * Test che verifica che il numero di tentativi falliti della
     * copia sia uguale a quello dell'oggetto originale.
     */
    @Test
    void testCopyFailedAttempts() {
        Game gameCopy = game.copy();
        assertEquals(game.getFailedAttempts(), gameCopy.getFailedAttempts(),
                "Il numero di tentativi falliti dovrebbe essere uguale");
    }

    /**
     * Test che verifica che la grandezza della griglia della copia
     * sia uguale a quella dell'oggetto originale.
     */
    @Test
    void testCopyGridSize() {
        Game gameCopy = game.copy();
        assertEquals(game.getGridSize(), gameCopy.getGridSize(),
                "La dimensione della griglia dovrebbe essere uguale");
    }

    /**
     * Test che verifica che il numero massimo di tentativi della
     * copia sia uguale a quello dell'oggetto originale.
     */
    @Test
    void testCopyMaxAttempts() {
        Game gameCopy = game.copy();
        assertEquals(game.getMaxAttempts(), gameCopy.getMaxAttempts(),
                "Il numero massimo di tentativi dovrebbe essere uguale");
    }

    /**
     * Test che verifica che il numero di navi capitalship rimanenti
     * della copia sia uguale a quello dell'oggetto originale.
     */
    @Test
    void testCopyRemainingCapitalships() {
        Game gameCopy = game.copy();
        assertEquals(game.getRemaningCapitalships(), gameCopy.getRemaningCapitalships(),
                "Il numero di navi capitali rimanenti dovrebbe essere uguale");
    }

    /**
     * Test che verifica che il numero di navi destroyer rimanenti
     * della copia sia uguale a quello dell'oggetto originale.
     */
    @Test
    void testCopyRemainingDestroyers() {
        Game gameCopy = game.copy();
        assertEquals(game.getRemaningDestroyers(), gameCopy.getRemaningDestroyers(),
                "Il numero di cacciatorpediniere rimanenti dovrebbe essere uguale");
    }

    /**
     * Test che verifica che il numero di navi cruiser rimanenti
     * della copia sia uguale a quello dell'oggetto originale.
     */
    @Test
    void testCopyRemainingCruisers() {
        Game gameCopy = game.copy();
        assertEquals(game.getRemaningCruisers(), gameCopy.getRemaningCruisers(),
                "Il numero di incrociatori rimanenti dovrebbe essere uguale");
    }

    /**
     * Test che verifica che il numero di tentativi riusciti della
     * copia sia uguale a quello dell'oggetto originale.
     */
    @Test
    void testCopySuccessfulAttempts() {
        Game gameCopy = game.copy();
        assertEquals(game.getSuccesfulAttempts(), gameCopy.getSuccesfulAttempts(),
                "Il numero di tentativi riusciti dovrebbe essere uguale");
    }

    /**
     * Test che verifica che il numero di tentativi rimanenti della
     * copia sia uguale a quello dell'oggetto originale.
     */
    @Test
    void testCopyRemainingAttempts() {
        Game gameCopy = game.copy();
        assertEquals(game.getRemaningAttempts(), gameCopy.getRemaningAttempts(),
                "Il numero di tentativi rimanenti dovrebbe essere uguale");
    }


}
