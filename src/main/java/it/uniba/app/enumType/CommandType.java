package it.uniba.app.enumType;
/**
 * Enumerazione dei comandi disponibili.
 */
public enum CommandType {
    /**
     * Comando per mostrare l'help.
     */
    HELP("/help"),
    /**
     * Comando per uscire dal gioco.
     */
    EXIT("/exit"),
    /**
     * Comando per iniziare una nuova partita.
     */
    NEW_GAME("/gioca"),
    /**
     * Comando per impostare la difficoltà "facile".
     */
    SET_EASY("/facile"),
    /**
     * Comando per impostare la difficoltà "media".
     */
    SET_MEDIUM("/medio"),
    /**
     * Comando per impostare la difficoltà "difficile".
     */
    SET_HARD("/difficile"),
    /**
     * Comando per mostrare il livello di difficoltà".
     */
    SHOW_DIFFICULTY("/mostralivello"),

    /**
     * Comando per impostare la grandezza della griglia "standard" 10x10.
     */
    STANDARD("/standard"),
    /**
     * Comando per impostare la grandezza della griglia "large" 18x18.
     */
    LARGE("/large"),
    /**
     * Comando per impostare la grandezza della griglia "extra large" 26x26.
     */
    EXTRA_LARGE("/extralarge"),
    /**
     * Comando per visulaizzare le navi.
     */
    SHOW_SHIPS("/mostranavi"),
    /**
     * Comando per svelare la griglia con le posizioni delle navi.
     */
    SHOW_GRID("/svelagriglia"),
    /**
     * Comando per stampare la griglia.
     */
    PRINT_GRID("/mostragriglia"),
    /**
     * Comando per abbondare la partita.
     */
    ABANDON("/abbandona"),

    /**
     * Comando per effettuare un tentativo.
     */
    HIT(""),
    /**
     * Comando per impostare il timer.
     */
    SET_TIMER("/timer"),
    /**
     * Comando per impostare il numero di tentativi.
     */
    SET_ATTEMPTS("/tentativi"),
    /**
     * Comando per visualizzare il numero di tentativi.
     */
    SHOW_ATTEMPTS("/mostratentativi"),
    /**
     * Comando per mostrare il tempo rimanente.
     */
    SHOW_TIME("/mostratempo"),
    /**
     * Comando non valido.
     */
    UNKNOWN("");
    /**
     * Comando CLI che corrisponde all'enum.
     */
    private String cliCommand;
    /**
     * Costruttore.
     * @param cliCommandParam comando CLI.
     */
    CommandType(final String cliCommandParam) {
        this.cliCommand = cliCommandParam;
    }
    /**
     * Restituisce il comando CLI relativo all'enum.
     * @return comando CLI.
     */
    public String getCliCommand() {
        return cliCommand;
    }
}
