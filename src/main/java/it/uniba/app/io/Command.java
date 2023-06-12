package it.uniba.app.io;


import it.uniba.app.enumType.CommandType;

/**
 * Questa classe è un Data Transfer Object che rappresenta un comando.
 * Contiene il tipo di comando e gli eventuali argomenti.
 */
public class Command {

    /**
     * Enumerazione dei comandi disponibili.
     */
    private CommandType command;

    /**
     * Eventuali argomenti del comando.
     */
    private String[] args = null;

    /**
     * Costruttore.
     * @param commandParam tipo di comando.
     * @param argsParam argomenti del comando.
     */
    public Command(final CommandType commandParam, final String[] argsParam) {
        this.command = commandParam;
        this.args = argsParam.clone();
    }

    /**
     * Costruttore.
     * @param commandParam tipo di comando.
     * @param argParam argomento del comando.
     */
    public Command(final CommandType commandParam, final String argParam) {
        this.command = commandParam;
        this.args = new String[1];
        this.args[0] = argParam;
    }

    /**
     * Costruttore.
     * @param commandParam tipo di comando.
     */

    public Command(final CommandType commandParam) {
        this.command = commandParam;
    }


    /**
     * Restituisce il tipo di comando.
     * @return tipo di comando.
     */

    public CommandType getCommand() {
        return this.command;
    }

    /**
     * Restituisce gi eventuali argomenti del comando.
     * @return argomenti del comando.
     */
    public String[] getArgs() {
        if (args == null) {
            return new String[0];  // restituisce un array vuoto invece di null
        } else {
            return args.clone();
        }
    }

    /**
     * Imposta il tipo di comando.
     * @param commandParam tipo di comando.
     */
    public void setCommand(final CommandType commandParam) {
        this.command = commandParam;
    }

    /**
     * Imposta gli eventuali argomenti del comando.
     * @param argsParam argomenti del comando.
     */
    public void setArgs(final String[] argsParam) {
        this.args = argsParam.clone();
    }


}
