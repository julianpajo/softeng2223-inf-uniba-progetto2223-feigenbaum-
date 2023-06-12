package it.uniba.app;

import it.uniba.app.io.Parser;
import org.junit.jupiter.api.Test;
import it.uniba.app.enumType.Difficulty;
import it.uniba.app.enumType.GridSize;
import it.uniba.app.enumType.CommandType;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Classe che testa la classe App.
 */
class AppTest {

    /**
     * Oggetto di tipo App per i test.
     */
    private App app;

    /**
     * Lista dei comandi disponibili.
     */
    private List<CommandType> availableCommands = new ArrayList<>();

    /**
     * Numero di minuti test.
     */
    private static final int MINUTES = 10;

    /**
     * Numero di tentativi test.
     */
    private static final int ATTEMPTS = 30;

    /**
     * Numero di tentativi test custom.
     */
    private static final int ATTEMPTS_CUSTOM = 10;

    /**
     * Metodo che inizializza i componenti necessari per i test.
     */
    @BeforeEach
    void setUp() {
        app = new App();
        availableCommands.add(CommandType.HELP);
        availableCommands.add(CommandType.EXIT);
        availableCommands.add(CommandType.NEW_GAME);
        availableCommands.add(CommandType.SET_EASY);
        availableCommands.add(CommandType.SET_MEDIUM);
        availableCommands.add(CommandType.SET_HARD);
        availableCommands.add(CommandType.SHOW_DIFFICULTY);
        availableCommands.add(CommandType.SHOW_SHIPS);
        availableCommands.add(CommandType.SHOW_GRID);
        availableCommands.add(CommandType.SET_ATTEMPTS);
        availableCommands.add(CommandType.SET_TIMER);
        availableCommands.add(CommandType.SHOW_ATTEMPTS);
        availableCommands.add(CommandType.STANDARD);
        availableCommands.add(CommandType.LARGE);
        availableCommands.add(CommandType.EXTRA_LARGE);
        availableCommands.add(CommandType.SHOW_TIME);
    }

    /**
     * Verifica se l'app ha il messaggio di benvenuto.
     */
    @Test
    void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(
                classUnderTest.getGreeting(), "app should have a greeting");
    }

    /**
     * Verifica se il comando /gioca inizia una nuova partita.
     */
    @Test
    void testNewGame() {
        app.nextMove(Parser.parse("/gioca", availableCommands));
        assertTrue(app.getGame().isRunning(), "Il gioco "
                +
                "dovrebbe essere in esecuzione");
    }
    /**
     * Verifica se il comando /facile imposta la difficoltà a facile.
     */
    @Test
    void testSetDifficultyEasyTrue() {
        app.nextMove(Parser.parse("/facile", availableCommands));
        assertEquals(app.getGame().getDifficulty(), Difficulty.EASY, "La difficoltà dovrebbe "
                +
                "essere impostata a facile");
    }

    /**
     * Verifica se il comando /facile imposta la difficoltà a facile.
     */
    @Test
    void testSetDifficultyEasyFalse() {
        app.nextMove(Parser.parse("/facile", availableCommands));
        assertNotEquals(app.getGame().getDifficulty(), Difficulty.HARD, "La difficoltà non "
                +
                "dovrebbe essere impostata a difficile");
    }

    /**
     * Verifica se il comando /facile imposta la difficoltà a facile.
     */
    @Test
    void testSetDifficultyEasyWithArgs1() {
        app.nextMove(Parser.parse("/facile 30", availableCommands));
        assertEquals(app.getGame().getDifficulty(), Difficulty.EASY, "La difficoltà dovrebbe "
                +
                "essere impostata a facile");
    }

    /**
     * Verifica se il comando /facile imposta la difficoltà a facile.
     */
    @Test
    void testSetDifficultyEasyWithArgs2() {
        app.nextMove(Parser.parse("/facile 30", availableCommands));
        assertEquals(app.getGame().getMaxAttempts(), ATTEMPTS,
                "Il numero di tentativi dovrebbe essere impostato a 30");
    }

    /**
     * Verifica se il comando /medio imposta la difficoltà a medio.
     */
    @Test
    void testSetDifficultyMediumTrue() {
        app.nextMove(Parser.parse("/medio", availableCommands));
        assertEquals(app.getGame().getDifficulty(), Difficulty.MEDIUM, "La difficoltà dovrebbe "
                +
                "essere impostata a medio");
    }

    /**
     * Verifica se il comando /medio imposta la difficoltà a medio.
     */
    @Test
    void testSetDifficultyMediumFalse() {
        app.nextMove(Parser.parse("/medio", availableCommands));
        assertNotEquals(app.getGame().getDifficulty(), Difficulty.EASY, "La difficoltà non "
                +
                "dovrebbe essere impostata a facile");
    }

    /**
     * Verifica se il comando /facile imposta la difficoltà a medio.
     */
    @Test
    void testSetDifficultyMediumWithArgs1() {
        app.nextMove(Parser.parse("/medio 30", availableCommands));
        assertEquals(app.getGame().getDifficulty(), Difficulty.MEDIUM, "La difficoltà dovrebbe "
                +
                "essere impostata a facile");
    }

    /**
     * Verifica se il comando /facile imposta la difficoltà a medio.
     */
    @Test
    void testSetDifficultyMediumWithArgs2() {
        app.nextMove(Parser.parse("/medio 30", availableCommands));
        assertEquals(app.getGame().getMaxAttempts(), ATTEMPTS,
                "Il numero di tentativi dovrebbe essere impostato a 30");
    }

    /**
     * Verifica se il comando /difficile imposta la difficoltà a difficile.
     */
    @Test
    void testSetDifficultyHardTrue() {
        app.nextMove(Parser.parse("/difficile", availableCommands));
        assertEquals(app.getGame().getDifficulty(), Difficulty.HARD, "La difficoltà dovrebbe "
                +
                "essere impostata a difficile");
    }

    /**
     * Verifica se il comando /difficile imposta la difficoltà a difficile.
     */
    @Test
    void testSetDifficultyHardFalse() {
        app.nextMove(Parser.parse("/difficile", availableCommands));
        assertNotEquals(app.getGame().getDifficulty(), Difficulty.EASY, "La difficoltà non "
                +
                "dovrebbe essere impostata a facile");
    }

    /**
     * Verifica se il comando /facile imposta la difficoltà a difficile.
     */
    @Test
    void testSetDifficultyHardWithArgs1() {
        app.nextMove(Parser.parse("/difficile 30", availableCommands));
        assertEquals(app.getGame().getDifficulty(), Difficulty.HARD, "La difficoltà dovrebbe "
                +
                "essere impostata a difficile");
    }

    /**
     * Verifica se il comando /facile imposta la difficoltà a difficile.
     */
    @Test
    void testSetDifficultyHardWithArgs2() {
        app.nextMove(Parser.parse("/difficile 30", availableCommands));
        assertEquals(app.getGame().getMaxAttempts(), ATTEMPTS,
                "Il numero di tentativi dovrebbe essere impostato a 30");
    }

    /**
     * Verifica se il comando /tentativi n imposta il numero di tentativi a n.
     */
    @Test
    void testSetAttemptsTrue() {
        app.nextMove(Parser.parse("/tentativi 10", availableCommands));
        assertEquals(app.getGame().getAttempts(), ATTEMPTS_CUSTOM, "Il numero di tentativi dovrebbe "
                +
                "essere impostato a 10");
    }

    /**
     * Verifica se il comando /tentativi n imposta il numero di tentativi a n.
     */
    @Test
    void testSetAttemptsFalse() {
        app.nextMove(Parser.parse("/tentativi 10", availableCommands));
        assertNotEquals(app.getGame().getAttempts(), 0, "Il numero di tentativi non "
                +
                "dovrebbe essere impostato a 0");
    }

    /**
     * Verifica se il comando /timer n imposta il timer a n minuti.
     */
    @Test
    void testSetTimerTrue() {
        app.nextMove(Parser.parse("/timer 10", availableCommands));
        assertEquals(app.getMinutes(), MINUTES, "Il timer dovrebbe "
                +
                "essere impostato a 10 minuti");
    }

    /**
     * Verifica se il comando /timer n imposta il timer a n minuti.
     */
    @Test
    void testSetTimerFalse() {
        app.nextMove(Parser.parse("/timer 10", availableCommands));
        assertNotEquals(app.getMinutes(), 0, "Il timer non "
                +
                "dovrebbe essere impostato a 0 minuti");
    }

    /**
     * Verifica se il comando /abbandona termina il gioco.
     */
    @Test
    void testAbandon() {
        app.nextMove(Parser.parse("/abbandona", availableCommands));
        assertFalse(app.getGame().isRunning(), "Il gioco "
                +
                "non dovrebbe essere in esecuzione");
    }

    /**
     * Verifica se la griglia è impostata correttamente a STANDARD.
     */
    @Test
    void testSetGridSizeStandardTrue() {
        app.nextMove(Parser.parse("/standard", availableCommands));
        assertEquals(app.getGame().getGridSize(), GridSize.STANDARD, "La griglia dovrebbe "
                +
                "essere impostata a STANDARD");
    }

    /**
     * Verifica se la griglia è impostata correttamente a STANDARD.
     */
    @Test
    void testSetGridSizeStandardFalse() {
        app.nextMove(Parser.parse("/standard", availableCommands));
        assertNotEquals(app.getGame().getGridSize(), GridSize.LARGE, "La griglia non "
                +
                "dovrebbe essere impostata a LARGE");
    }

    /**
     * Verifica se la griglia è impostata correttamente a LARGE.
     */
    @Test
    void testSetGridSizeLargeTrue() {
        app.nextMove(Parser.parse("/large", availableCommands));
        assertEquals(app.getGame().getGridSize(), GridSize.LARGE, "La griglia dovrebbe "
                +
                "essere impostata a LARGE");
    }

    /**
     * Verifica se la griglia è impostata correttamente a LARGE.
     */
    @Test
    void testSetGridSizeLargeFalse() {
        app.nextMove(Parser.parse("/large", availableCommands));
        assertNotEquals(app.getGame().getGridSize(), GridSize.STANDARD, "La griglia non "
                +
                "dovrebbe essere impostata a STANDARD");
    }

    /**
     * Verifica se la griglia è impostata correttamente a EXTRA_LARGE.
     */
    @Test
    void testSetGridSizeExtraLargeTrue() {
        app.nextMove(Parser.parse("/extralarge", availableCommands));
        assertEquals(app.getGame().getGridSize(), GridSize.EXTRA_LARGE, "La griglia dovrebbe "
                +
                "essere impostata a EXTRA_LARGE");
    }

    /**
     * Verifica se la griglia è impostata correttamente a EXTRA_LARGE.
     */
    @Test
    void testSetGridSizeExtraLargeFalse() {
        app.nextMove(Parser.parse("/extralarge", availableCommands));
        assertNotEquals(app.getGame().getGridSize(), GridSize.STANDARD, "La griglia non "
                +
                "dovrebbe essere impostata a STANDARD");
    }
}
