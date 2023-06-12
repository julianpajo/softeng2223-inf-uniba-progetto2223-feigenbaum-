package it.uniba.app.io;
import it.uniba.app.enumType.Difficulty;
import it.uniba.app.enumType.GridSize;
import it.uniba.app.enumType.ResultType;
import it.uniba.app.type.Grid;


/**
 * Classe che gestisce la stampa a video.
 */
public final class Printer {

    /**
     * Numero di righe con un solo numero.
     */
    private static final int N_ROWS_SINGLE_NUMBER = 9;

    /**
     * Costruttore privato.
     */
    private Printer() {
    }

    /**
     * Stampa la griglia di gioco.
     * @param grid Griglia di gioco
     * @param columnsLabels Etichette delle colonne
     */
    public static void showGameGrid(final Grid grid, final String[] columnsLabels) {
        int size = grid.getSize().getSize();
        System.out.print("   ");
        for (String s: columnsLabels) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1 + " ");
            if (i < N_ROWS_SINGLE_NUMBER) {
                System.out.print(" ");
            } else {
                System.out.print("");
            }

            for (int j = 0; j < size; j++) {
                if (grid.getCell(i, j).isHit()) {
                    if (grid.getCell(i, j).isShip()) {
                        if (grid.getCell(i, j).getShip().isSunk()) {
                            System.out.print(grid.getCell(i, j).getShip().getSymbol()
                                    + " ");
                        } else {
                            System.out.print("X ");
                        }
                    } else {
                        System.out.print("O ");
                    }
                } else {
                    System.out.print("~ ");
                }
            }
            System.out.println();
        }
        System.out.println("\nLegenda:");
        System.out.println("'O' = Acqua");
        System.out.println("'X' = Affondata");
        System.out.println("'D' = Destroyer");
        System.out.println("'I' = Cruiser");
        System.out.println("'R' = Capital Ship");
        System.out.println("'P' = Carrier");
    }

    /**
     * Stampa la griglia con le navi posizionate.
     * @param grid Griglia di gioco
     * @param columnsLabels Etichette delle colonne
     */
    public static void showFullGrid(final Grid grid, final String[] columnsLabels) {
        int size = grid.getSize().getSize();
        System.out.print("   ");
        for (String s: columnsLabels) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1 + " ");
            if (i < N_ROWS_SINGLE_NUMBER) {
                System.out.print(" ");
            } else {
                System.out.print("");
            }

            for (int j = 0; j < size; j++) {
                if (grid.getCell(i, j).isShip()) {
                    System.out.print(grid.getCell(i, j).getShip().getSymbol()
                            + " ");
                } else {
                    System.out.print("~ ");
                }
            }
            System.out.println();
        }
        System.out.println("\nLegenda:");
        System.out.println("'C' = Destroyer");
        System.out.println("'I' = Cruiser");
        System.out.println("'R' = Capital Ship");
        System.out.println("'P' = Carrier");
    }
    /**
     * Stampa l'help del gioco con i comandi disponibili.
     */
    public static void printHelp() {
        System.out.println("Comandi disponibili:");
        System.out.println("/help\t\t\t "
                + "Mostra l'elenco dei comandi disponibili");
        System.out.println("/gioca\t\t\t Avvia una nuova partita");
        System.out.println("/mostranavi\t\t "
                + "Mostra tipo, numero e dimensione delle navi");
        System.out.println("/mostralivello\t Mostra il livello di difficoltà");
        System.out.println("/svelagriglia\t Mostra la griglia con le navi");
        System.out.println("/abbandona\t\t Termina la partita corrente");
        System.out.println("/exit\t\t\t Termina il gioco\n");
        System.out.println("Per modificare il livello di difficoltà:");
        System.out.println("/facile\t\t\t Livello facile - 50 Tentativi");
        System.out.println("/medio\t\t\t "
                + "Livello medio - 30 Tentativi (Default)");
        System.out.println("/difficile\t\t Livello difficile - 10 Tentativi");
        System.out.println("/tentativi n\t Imposta a n il "
        + "numero massimo di tentativi falliti\n");
        System.out.println("Per modificare il dimensione della griglia:");
        System.out.println("/standard\t\t Griglia 10x10 (Default)");
        System.out.println("/large\t\t\t "
                + "Griglia 18x18");
        System.out.println("/extralarge\t\t Griglia 26x26");
        System.out.println("-----------------------------------");
    }


    /**
     * Richiede all'utente se abbandonare la partita o meno.
     */
    public static void abandonGame() {
        System.out.println("Sei sicuro di voler abbandonare la partita? yes/no");
    }

    /**
     * Stampa il messaggio di partita già in corso.
     */
    public static void printGameIsRunning() {
        System.out.println("Partita già in corso");
    }
    /**
     * Stampa il messaggio di nessuna partita in corso.
     */
    public static void printNoGameRunning() {
        System.out.println("Nessuna partita in corso");
    }

    /**
     * Stampa il messaggio di impostazione della dimensione della griglia.
     * @param size Dimensione della griglia
     */
    public static void printSettedGridSize(final GridSize size) {
        System.out.println("Dimensione griglia impostata a " + size.getSize()
                + "x" + size.getSize());
    }

    /**
     * Stampa il livello di difficoltà e il numero di tentativi.
     * @param difficulty Livello di difficoltà
     * @param attempts Numero di tentativi
     */
    public static void showDifficulty(final Difficulty difficulty, final int attempts) {
        System.out.println("Livello di difficoltà: " + difficulty.toString());
        System.out.println("Tentativi: " + attempts);
    }
    /**
     * Stampa il numero di navi per tipo e la loro dimensione.
     * @param capitalShips Numero di corazzate
     * @param destroyers Numero di cacciatorpediniere
     * @param cruisers Numero di incrociatori
     * @param carriers Numero di portaerei
     */
    public static void showShips(final int capitalShips, final int destroyers,
                          final int cruisers, final int carriers) {
        System.out.println("- Cacciatorpediniere ⊠⊠     esemplari: " + destroyers);
        System.out.println("- Incrociatore       ⊠⊠⊠    esemplari: " + cruisers);
        System.out.println("- Corazzata          ⊠⊠⊠⊠   esemplari: " + capitalShips);
        System.out.println("- Portaerei          ⊠⊠⊠⊠⊠  esemplari: " + carriers);
    }
    /**
     * Stampa il numero di tentativi falliti, riusciti e rimasti.
     * @param failedAttempts Tentativi falliti.
     * @param successAttempts Tentativi riusciti.
     * @param attempts Tentativi rimasti.
     */
    public static void showAttempts(final int failedAttempts,
                             final int successAttempts,
                             final int attempts) {
        System.out.println("Tentativi falliti: " + failedAttempts);
        System.out.println("Tentativi riusciti: " + successAttempts);
        System.out.println("Tentativi rimasti: " + (attempts - failedAttempts));
    }

    /**
     * Stampa il titolo del gioco.
     */
    public static void printTitle() {
        System.out.println("\n"
                +
                "______  ___ _____ _____ _      _____ _____ _   _ ___________ \n"
                +
                "| ___ \\/ _ \\_   _|_   _| |    |  ___/  ___| | | |_   _| ___ \\\n"
                +
                "| |_/ / /_\\ \\| |   | | | |    | |__ \\ `--.| |_| | | | | |_/ /\n"
                +
                "| ___ \\  _  || |   | | | |    |  __| `--. \\  _  | | | |  __/ \n"
                +
                "| |_/ / | | || |   | | | |____| |___/\\__/ / | | |_| |_| |    \n"
                +
                "\\____/\\_| |_/\\_/   \\_/ \\_____/\\____/\\____/\\_| |_/\\___/\\_|    \n"
                +
                "                                                             \n"
                +
                "                                                             \n");
    }
    /**
     * Stampa il messaggio di comando non valido.
     */
    public static void notValidCommand() {
        System.out.println("Comando non valido, "
                +
                "Usa /help per visualizzare i comandi disponibili");
    }
    /**
     * Stampa i tentativi rimanenti.
     * @param attempts Tentativi rimanenti
     */
    public static void printRemaningAttempts(final int attempts) {
        System.out.println("Tentativi rimanenti: " + attempts);
    }
    /**
     * Stampa il messaggio di saluto.
     */
    public static void printExit() {
        System.out.println("Arrivederci!");
    }
    /**
     * Stampa il messaggio di sconfitta.
     * @param timeOver True se il tempo è scaduto, false altrimenti
     */
    public static void printLose(final boolean timeOver) {
        if (timeOver) {
            System.out.println("Hai perso! Il tempo è scaduto!");
        } else {
            System.out.println("Hai perso! Hai esaurito i tentativi!");
        }
    }
    /**
     * Stampa un messaggio di errore.
     */
    public static void printNotValidFormat() {
        System.out.println("Formattazione non valida, riprova.");
    }
    /**
     * Stampa il messaggio di successo quando i tentativi vengono modificati.
     * @param attempts Numero di tentativi
     */
    public static void printAttemptsModified(final int attempts) {
        System.out.println("OK, il numero massimo di tentativi falliti è stato impostato a "
                + attempts);
    }

    /**
     * Stampa il messaggio di errore nel caso in cui
     * il numero di tentativi non sia un numero intero.
     */
    public static void notValidAttempts() {
        System.out.println("Errore: il numero di tentativi deve essere un numero intero.");
    }

    /**
     * Stampa il messaggio di errore nel caso in cui il numero di tentativi non viene specificato.
     */
    public static void emptyAttempts() {
        System.out.println("Errore: devi specificare il numero di tentativi.");
    }


    /**
     * Stampa i minuti o eventualmente, i secondi rimanenti.
     * @param timeSeconds secondi rimanente
     */
    public static void printRemainingTime(final int timeSeconds) {
        final int secondsInMinute = 60;
        if (timeSeconds > secondsInMinute) {
            System.out.println("Tempo rimanente: "
                    + timeSeconds / secondsInMinute + " minuti");
        } else {
            System.out.println("Tempo rimanente: "
                    + timeSeconds + " secondi");
        }
    }
    /**
     * Stampa i minuti o eventualmente, i secondi rimanenti e trascorsi.
     * @param remainingTimeSeconds secondi rimanenti
     * @param elapsedTimeSeconds secondi trascorsi
     */
    public static void printElapsedTime(final int remainingTimeSeconds,
                                 final int elapsedTimeSeconds) {
        final int secondsInMinute = 60;
        if (remainingTimeSeconds > secondsInMinute) {
            System.out.println("Tempo rimanente: "
                    + remainingTimeSeconds / secondsInMinute + " minuti");
        } else {
            System.out.println("Tempo rimanente: "
                    + remainingTimeSeconds + " secondi");
        }
        if (elapsedTimeSeconds > secondsInMinute) {
            System.out.println("Tempo trascorso: "
                    + elapsedTimeSeconds / secondsInMinute + " minuti");
        } else {
            System.out.println("Tempo trascorso: "
                    + elapsedTimeSeconds + " secondi");
        }
    }
    /**
     * Stampa i minuti impostati del timer. Se impostati a 0, il timer non viene considerato.
     * @param timeMinutes minuti
     */
    public static void printTimeSet(final int timeMinutes) {
        if (timeMinutes > 0) {
            System.out.println("Tempo impostato: "
                    + timeMinutes + " minuti");
        } else {
            System.out.println("Tempo impostato: "
                    + "Nessun limite di tempo");
        }
    }

    /**
     * Stampa l'esito del colpo sparato.
     * @param result Esito del colpo
     */
    public static void printHitResult(final ResultType result) {
        if (result == ResultType.MISS) {
            System.out.println("\n--Acqua!--");
        } else if (result == ResultType.HIT) {
            System.out.println("\n--Colpito!--");
        } else if (result == ResultType.HITANDSUNK) {
            System.out.println("\n--Colpito e affondato!--");
        } else if (result == ResultType.ALREADYHIT) {
            System.out.println("\n--Cella già colpita!--");
        }
    }

    /**
     * Stampa il messaggio di vittoira.
     */
    public static void printWin() {
        System.out.println("Hai vinto!");
    }

}
