package it.uniba.app.io;

import it.uniba.app.enumType.CommandType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Classe che testa la classe Command.
 */
class CommandTest {

    /**
     * Verifica se il metodo getCommand() ritorna il comando corretto.
     */
    @Test
    void testGetCommand() {
        Command command = new Command(CommandType.NEW_GAME);
        assertEquals(CommandType.NEW_GAME, command.getCommand(), "Il comando "
                +
                "ritornato dovrebbe essere NEW_GAME");
    }

    /**
     * Verifica se il metodo getArgs() ritorna gli argomenti corretti.
     */
    @Test
    void testGetArgs() {
        Command command = new Command(CommandType.HIT, new String[]{"A", "2"});
        assertArrayEquals(new String[]{"A", "2"}, command.getArgs(), "Gli "
                +
                "argomenti ritornati dovrebbero essere giusti");
    }

    /**
     * Verifica se il metodo getArgs() ritorna un array vuoto se non sono
     * presenti argomenti.
     */
    @Test
    void testGetArgsNull() {
        Command command = new Command(CommandType.SHOW_DIFFICULTY);
        assertArrayEquals(new String[0], command.getArgs(), "L'array ritornato "
                +
                "dovrebbe essere vuoto");
    }

    /**
     * Verifica se il metodo setCommand() imposta il comando corretto.
     */
    @Test
    void testSetCommand() {
        Command command = new Command(CommandType.HELP);
        command.setCommand(CommandType.HELP);
        assertEquals(CommandType.HELP, command.getCommand(), "Il comando "
                +
                "impostato dovrebbe essere giusto");
    }

    /**
     * Verifica se il metodo setArgs() imposta gli argomenti corretti.
     */
    @Test
    void testSetArgs() {
        Command command = new Command(CommandType.HIT);
        command.setArgs(new String[]{"A", "5"});
        assertArrayEquals(new String[]{"A", "5"}, command.getArgs(),
                "Gli argomenti impostati dovrebbero essere giusti");
    }
}
