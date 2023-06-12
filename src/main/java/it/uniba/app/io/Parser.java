
package it.uniba.app.io;
import it.uniba.app.enumType.CommandType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
/**
 * classe che gestisce il parser.
 */
public final class Parser {
    /**
     * Costruttore privato.
     */
    private Parser() {
    }
    /**
     * metodo che gestisce il parser.
     * @param cliInput input inserito dall'utente
     * @param availableCommands lista dei comandi disponibili
     * @return il comando inserito dall'utente
     */
    public static Command parse(final String cliInput,
                                final List<CommandType> availableCommands) {
        String[] splitted = cliInput.split(" ");
        String command;
        CommandType commandTypeInput = CommandType.UNKNOWN;
        if (splitted.length == 0 || splitted[0].equals("")) {
            return new Command(CommandType.UNKNOWN);
        }
        //check if the command starts with a slash
        if (splitted[0].charAt(0) == '/') {
            command = splitted[0];
            for (CommandType c : availableCommands) {
                if (c.getCliCommand().equals(command)) {
                    commandTypeInput = c;
                    break;
                }
            }
            if (commandTypeInput.equals(CommandType.SET_HARD)
                    || commandTypeInput.equals(CommandType.SET_EASY)
                    || commandTypeInput.equals(CommandType.SET_MEDIUM)
                    || commandTypeInput.equals(CommandType.SET_ATTEMPTS)) {
                if (splitted.length > 1) {
                    return new Command(commandTypeInput, splitted[1]);
                }
                return new Command(commandTypeInput);
            }
        }

        if (commandTypeInput.equals(CommandType.SET_TIMER)) {
            if (splitted.length > 1) {
                return new Command(commandTypeInput, splitted[1]);
            }
            return new Command(CommandType.UNKNOWN);
        }

        if (splitted[0].length() > 2) {
            //check if the command is a hit coordinate
            if (splitted[0].charAt(1) == '-') {
                String[] coords = splitted[0].split("-");
                System.out.println(coords[0] + " " + coords[1]);
                return new Command(CommandType.HIT, coords);
            }
        }
        return new Command(commandTypeInput);
    }
    /**
     * Metodo che legge l'input inserito dall'utente.
     * @return l'input inserito dall'utente.
     */
    public static String readInput() {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String input;
        try {
            input = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return input;
    }
    /**
     * Metodo che legge il comando inserito dall'utente.
     * @param availableCommands lista dei comandi disponibili.
     * @return il comando inserito dall'utente.
     */
    public static  Command getCommand(final List<CommandType>
                                              availableCommands) {
        String choice;
        System.out.println("Inserire un comando: ");
        choice = readInput();
        while (choice == null || choice.equals("")) {
            System.out.println("Inserire un comando: ");
            choice = readInput();
        }

        return parse(choice, availableCommands);
    }

    /**
     * metodo usato per ottenere il comando da una stringa.
     * @param args la stringa da cui ottenere il comando.
     * @param availableCommands la lista dei comandi disponibili.
     * @return il comando ottenuto dalla stringa.
     */
    public static Command getCommandFromArgs(final String args,
                                             final List<CommandType>
                                                     availableCommands) {
        switch (args) {
            case "-h":
                return new Command(CommandType.HELP);
            case "--help":
                return new Command(CommandType.HELP);
            case "-g":
                return new Command(CommandType.NEW_GAME);
            case "--gioca":
                return new Command(CommandType.NEW_GAME);
            default:
                return new Command(CommandType.UNKNOWN);
        }
    }

}
