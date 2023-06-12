package it.uniba.app.io;

import it.uniba.app.enumType.CommandType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Classe che testa la classe Parser.
 */
class ParserTest {

    /**
     * Lista dei comandi disponibili.
     */
    private List<CommandType> availableCommands = new ArrayList<>();

    @BeforeEach
    void setUpClass() {
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
     * Verifica se il metodo parse() ritorna il comando corretto quando
     * l'input è un comando non riconosciuto.
     */
    @Test
    void testParseUnknownCommand() {
        Command command = Parser.parse("", availableCommands);
        assertEquals(CommandType.UNKNOWN, command.getCommand(),
                "Il comando ritornato dovrebbe essere UNKNOWN");
    }

    /**
     * Verifica se il metodo parse() ritorna il comando corretto quando
     * l'input è un comando valido.
     */
    @Test
    void testParseKnownCommand() {
        Command command = Parser.parse("/gioca", availableCommands);
        assertEquals(CommandType.NEW_GAME, command.getCommand(),
                "Il comando ritornato dovrebbe essere NEW_GAME");
    }

    /**
     * Verifica se il metodo parse() ritorna gli argomenti corretti quando
     * viene effettuato un hit.
     */
    @Test
    void testParseHitCommand() {
        Command command = Parser.parse("A-1", availableCommands);
        assertEquals(CommandType.HIT, command.getCommand(),
                "Il comando ritornato dovrebbe essere HIT");
    }

    /**
     * Verifica se il metodo parse() ritorna gli argomenti corretti quando
     * viene effettuato un hit.
     */
    @Test
    void testParseHitCommandArgs() {
        Command command = Parser.parse("A-1", availableCommands);
        assertArrayEquals(new String[]{"A", "1"}, command.getArgs(),
                "Gli argomenti ritornati dovrebbero essere A e 1");
    }


    /**
     * Verifica se il metodo parse() ritorna gli argomenti corretti quando
     * viene lanciato il programma con un argomento.
     */
    @Test
    void testGetCommandFromArgsHelpShort() {
        Command commandHelpShort = Parser.getCommandFromArgs("-h", availableCommands);
        assertEquals(CommandType.HELP, commandHelpShort.getCommand(),
                "Il comando ritornato dovrebbe essere HELP");
    }

    /**
     * Verifica se il metodo parse() ritorna gli argomenti corretti quando
     * viene lanciato il programma con un argomento.
     */
    @Test
    void testGetCommandFromArgsHelpLong() {
        Command commandHelpLong = Parser.getCommandFromArgs("--help", availableCommands);
        assertEquals(CommandType.HELP, commandHelpLong.getCommand(),
                "Il comando ritornato dovrebbe essere HELP");
    }

    /**
     * Verifica se il metodo parse() ritorna gli argomenti corretti quando
     * viene lanciato il programma con un argomento.
     */
    @Test
    void testGetCommandFromArgsNewGameShort() {

        Command commandPlayShort = Parser.getCommandFromArgs("-g", availableCommands);
        assertEquals(CommandType.NEW_GAME, commandPlayShort.getCommand(),
                "Il comando ritornato dovrebbe essere NEW_GAME");
    }

    /**
     * Verifica se il metodo parse() ritorna gli argomenti corretti quando
     * viene lanciato il programma con un argomento.
     */
    @Test
    void testGetCommandFromArgsNewGameLong() {

        Command commandPlayShort = Parser.getCommandFromArgs("--gioca", availableCommands);
        assertEquals(CommandType.NEW_GAME, commandPlayShort.getCommand(),
                "Il comando ritornato dovrebbe essere NEW_GAME");
    }

    /**
     * Verifica se il metodo parse() ritorna gli argomenti corretti quando
     * viene lanciato il programma con un argomento.
     */
    @Test
    void testGetCommandFromArgsInvalid() {
        Command command = Parser.getCommandFromArgs("invalid", availableCommands);
        assertEquals(CommandType.UNKNOWN, command.getCommand(),
                "Il comando ritornato dovrebbe essere UNKNOWN");
    }

}
