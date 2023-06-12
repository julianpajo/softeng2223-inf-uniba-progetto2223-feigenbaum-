package it.uniba.app;

import it.uniba.app.enumType.CommandType;
import it.uniba.app.enumType.Difficulty;
import it.uniba.app.enumType.GridSize;
import it.uniba.app.enumType.ResultType;
import it.uniba.app.io.Command;
import it.uniba.app.io.Parser;
import it.uniba.app.io.Printer;

import java.util.ArrayList;
import java.util.List;
/**
 * Classe principale.
 */
public final class App {
    /**
     * Minuti di default.
     */
    private static final int DEFAULT_MINUTES = 10;
    /**
     * Lista dei comandi disponibili.
     */
    private List<CommandType> availableCommands = new ArrayList<>();
    /**
     * L'istanza di gioco.
     */
    private Game game;
    /**
     * La difficoltà della partita.
     */
    private Difficulty difficulty = Difficulty.MEDIUM;
    /**
     * La dimensione della griglia.
     */
    private GridSize gridSize = GridSize.STANDARD;

    //private Printer output;
    /**
     * Minuti a disposizione per terminare una partita.
     */
    private int minutes = 0;
    /**
     * Timer.
     */
    private Timer timer;

    /**
     * Get a greeting sentence.
     *
     * @return the "Hello World!" string.
     */

    public String getGreeting() {
        return "Hello World!!!";
    }
    /**
     * Print the help menu.
     */
    public void printHelp() {
        Printer.printHelp();
    }
    /**
     * Classe Timer.
     */
    private class Timer implements Runnable {
        /**
         * Secondi rimanenti.
         */
        private int remaningSeconds;
        /**
         * Secondi trascorsi.
         */
        private int elapsedSeconds;
        /**
         * Secondi in un minuto.
         */
        private static final int SECONDSINMINUTE = 60;
        /**
         * Millisecondi di attesa.
         */
        private static final int DELAY = 1000;
        /**
         * Metodo che avvia il timer.
         */
        public void run() {
            remaningSeconds = minutes * SECONDSINMINUTE;
            try {
                while (remaningSeconds > 0) {
                    Thread.sleep(DELAY);
                    elapsedSeconds++;
                    remaningSeconds--;
                }
                loseGame(true);
            } catch (InterruptedException e) {
                System.out.println("Timer interrupted");
            }
        }

        /**
         * Metodo che restituisce i secondi rimanenti.
         * @return secondi rimanenti
         */
        public int getRemainingSeconds() {
            return remaningSeconds;
        }
        /**
         * Metodo che restituisce i secondi trascorsi.
         * @return secondi trascorsi
         */
        public int getElapsedSeconds() {
            return elapsedSeconds;
        }

    }


        /**
     * Initizialize the application.
     */
    public App() {
        game = new Game(gridSize, difficulty);
        // output = new Printer();
        timer = new Timer();

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
        availableCommands.add(CommandType.ABANDON);
        availableCommands.add(CommandType.PRINT_GRID);

    }
    /**
     * Start a new battleship game.
     */
    public void newGame() {
        game.newGame();
        game.setIsRunning(true);
    }
    /**
     * Exit from the game.
     */
    public void exit() {
        Printer.printExit();
        System.exit(0);
    }
    /**
     * Make the next move.
     * @param command the command to execute.
     */
    public void nextMove(final Command command) {
        switch (command.getCommand()) {
            case HELP:
                printHelp();
                break;
            case NEW_GAME:
                setNewGame();
                break;
            case SET_EASY:
                if (game.isRunning()) {
                    Printer.printGameIsRunning();
                    break;
                }
                String[] argsEasy = command.getArgs();
                if (argsEasy != null && argsEasy.length > 0) {
                    try {
                        int attempts = Integer.parseInt(argsEasy[0]);
                        if (attempts < 1) {
                            Printer.notValidAttempts();
                            break;
                        }
                        setDifficulty(Difficulty.EASY, attempts);
                    } catch (NumberFormatException e) {
                        Printer.notValidAttempts();
                    }
                } else {
                    setDifficulty(Difficulty.EASY);
                }
                break;
            case SET_MEDIUM:
                if (game.isRunning()) {
                    Printer.printGameIsRunning();
                    break;
                }
                String[] argsMedium = command.getArgs();
                if (argsMedium != null && argsMedium.length > 0) {
                    try {
                        int attempts = Integer.parseInt(argsMedium[0]);
                        if (attempts < 1) {
                            Printer.notValidAttempts();
                            break;
                        }
                        setDifficulty(Difficulty.MEDIUM, attempts);
                    } catch (NumberFormatException e) {
                        Printer.notValidAttempts();
                    }
                } else {
                    setDifficulty(Difficulty.MEDIUM);
                }
                break;
            case SET_HARD:
                if (game.isRunning()) {
                    Printer.printGameIsRunning();
                    break;
                }
                String[] argsHard = command.getArgs();
                if (argsHard != null && argsHard.length > 0) {
                    try {
                        int attempts = Integer.parseInt(argsHard[0]);
                        if (attempts < 1) {
                            Printer.notValidAttempts();
                            break;
                        }
                        setDifficulty(Difficulty.HARD, attempts);
                    } catch (NumberFormatException e) {
                        Printer.notValidAttempts();
                    }
                } else {
                    setDifficulty(Difficulty.HARD);
                }
                break;
            case SHOW_DIFFICULTY:
                Printer.showDifficulty(game.getDifficulty(),
                        game.getAttempts());
                break;
            case SHOW_SHIPS:
                Printer.showShips(game.getRemaningCapitalships(), game.getRemaningDestroyers(),
                        game.getRemaningCruisers(),
                        game.getRemaningCarriers());
                break;
            case SHOW_GRID:
                if (game.isRunning()) {
                    Printer.showFullGrid(game.getGrid(),
                            game.getCurrentColumnsLabels());
                } else {
                    Printer.printNoGameRunning();
                }
                break;
            case SET_ATTEMPTS:
                setAttempts(command);
                break;
            case SHOW_TIME:
                if (game.isRunning()) {
                    Printer.printElapsedTime(timer.getRemainingSeconds(),
                            timer.getElapsedSeconds());
                } else {
                    Printer.printNoGameRunning();
                }
                break;
            case SHOW_ATTEMPTS:
                if (game.isRunning()) {
                    Printer.showAttempts(game.getFailedAttempts(),
                            game.getSuccesfulAttempts(),
                            game.getAttempts());
                } else {
                    Printer.printNoGameRunning();
                }
                break;
            case STANDARD:
                setGridSize(GridSize.STANDARD);
                break;
            case LARGE:
                setGridSize(GridSize.LARGE);
                break;
            case EXTRA_LARGE:
                setGridSize(GridSize.EXTRA_LARGE);
                break;
            case HIT:
                if (game.isRunning()) {
                    try {
                        checkIsNotNumber(command);
                        hit(command.getArgs()[0].toString(),
                                Integer.parseInt(command.getArgs()[1]));
                    } catch (NumberFormatException e) {
                        Printer.printNotValidFormat();
                    }
                } else {
                    Printer.printNoGameRunning();
                }
                break;
            case SET_TIMER:
                setTimer(command);
                break;
            case PRINT_GRID:
                printgrid();
                break;
            case EXIT:
                exit();
                break;
            case UNKNOWN:
                Printer.notValidCommand();
                break;
            case ABANDON:
                abandon();
                break;
            default:
                Printer.notValidCommand();
                break;
        }
    }

    /**
     * Metodo per impostare una nuova partita.
     */
    private void setNewGame() {
        if (game.isRunning()) {
            Printer.printGameIsRunning();
            return;
        }
        System.out.println("Partita Iniziata!");
        game.setIsRunning(true);
        System.out.println(game.isRunning());
        if (minutes > 0) {
            Thread timerThread = new Thread(timer);
            timerThread.start();
        } else {
            minutes = DEFAULT_MINUTES;
            Thread timerThread = new Thread(timer);
            timerThread.start();
        }
        newGame();
        Printer.showGameGrid(game.getGrid(),
                game.getCurrentColumnsLabels());
        Printer.showDifficulty(game.getDifficulty(), game.getAttempts());
        if (minutes > 0) {
            Printer.printRemainingTime(timer.getRemainingSeconds());
        }
    }

    /**
     * Metodo per impostare il numero di tentativi.
     * @param command comando da eseguire
     */
    private void setAttempts(final Command command) {
        if (game.isRunning()) {
            Printer.printGameIsRunning();
        } else {
            if (command.getArgs() != null
                    &&
                    command.getArgs().length > 0) {
                try {
                    int attempts =
                            Integer.parseInt(command.getArgs()[0]);
                    if (attempts < 1) {
                        Printer.notValidAttempts();
                    }
                    setDifficulty(Difficulty.CUSTOM, attempts);
                } catch (NumberFormatException e) {
                    Printer.emptyAttempts();
                }
            } else {
                Printer.emptyAttempts();
            }
        }
    }

    /**
     * Metodo per impostare la durata del tempo di gioco.
     * @param command comando da eseguire
     */
    private void setTimer(final Command command) {
        if (!game.isRunning()) {
            minutes = Integer.parseInt(command.getArgs()[0].toString());
            Printer.printTimeSet(minutes);
        } else {
            Printer.printGameIsRunning();
        }
    }
    /**
     * Metodo per colpire una cella.
     * @param column etichetta colonna.
     * @param row numero riga.
     */
    private void hit(final String column, final int row) {
        ResultType result;
        Boolean isWon;
        if (game.checkValidity(column, row)) {
            result = game.hit(column, row);
            isWon = game.isWon();
            Printer.showGameGrid(game.getGrid(),
                    game.getCurrentColumnsLabels());
            Printer.printRemaningAttempts(game.getRemaningAttempts());

            if (isWon) {
                Printer.printWin();
                game.setIsRunning(false);
            } else if (game.getRemaningAttempts() == 0) {
                Printer.printLose(false);
                game.setIsRunning(false);
            } else {
            if (minutes > 0) {
                Printer.printRemainingTime(timer.getRemainingSeconds());
            }
                Printer.printHitResult(result);
            }

        } else {
        Printer.printNotValidFormat();
        }
    }
    /**
     * Metodo per stampare la griglia di gioco.
     */
    private void printgrid() {
        if (game.isRunning()) {
            Printer.showGameGrid(game.getGrid(),
                    game.getCurrentColumnsLabels());
        } else {
            Printer.printNoGameRunning();
        }
    }

    /**
     * Metodo per controllare che il primo argomento non sia un numero.
     * @param command comando da controllare
     */
    private static void checkIsNotNumber(final Command command) {
        String regEx = "-?\\d+(\\.\\d+)?";
        boolean isNumber = command.getArgs()[0].matches(regEx);
        if (isNumber) {
            throw new NumberFormatException();
        }
    }

    /**
     * Metodo per abbandonare la partita.
     */
    public void abandon() {
        Printer.abandonGame(); String confirmation = Parser.readInput();
        if (confirmation.equalsIgnoreCase("yes")) {
            Printer.showFullGrid(game.getGrid(), game.getCurrentColumnsLabels());
            game.setIsRunning(false);
        }
    }

    /**
     * Metodo per impostare la dimensione della griglia.
     * @param size dimensione della griglia
     */
    public void setGridSize(final GridSize size) {
        if (game.isRunning()) {
            Printer.printGameIsRunning();
        } else {
            game.setGridSize(size);
            gridSize = size;
            Printer.printSettedGridSize(size);
        }
    }

    /**
     * Metodo per ritornare i minuti del timer.
     * @return minuti del timer
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Metodo per impostare la difficoltà.
     * @param difficultyParam difficoltà
     */
    public void setDifficulty(final Difficulty difficultyParam) {
        if (game.isRunning()) {
            Printer.printGameIsRunning();
        } else {
            game.setDifficulty(difficultyParam);
            this.difficulty = difficultyParam;
            Printer.showDifficulty(game.getDifficulty(),
                    game.getAttempts());
        }
    }

    /**
     * Metodo che restituisce il gioco.
     * @return gioco
     */
    public Game getGame() {
        return game.copy();
    }

    /**
     * Metodo per impostare la difficoltà.
     * @param difficultyParam difficoltà
     * @param attempts numero di tentativi
     */
    public void setDifficulty(final Difficulty difficultyParam, final int attempts) {
        if (game.isRunning()) {
            Printer.printGameIsRunning();
        } else {
            game.setDifficulty(difficultyParam);
            game.setAttempts(attempts);

            Printer.printAttemptsModified(attempts);
            game.setAttempts(attempts);

            this.difficulty = difficultyParam;
            Printer.showDifficulty(game.getDifficulty(), game.getAttempts());
        }
    }
    /**
     * Metodo da invocare in caso di sconfitta.
     * @param timeOver true se il tempo è scaduto, false altrimenti
     */
    public void loseGame(final boolean timeOver) {
        game.setIsRunning(false);
        Printer.printLose(timeOver);
        System.out.println("Inserire un comando: ");
    }

    /**
     * Entrypoint of the application.
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        App app = new App();
        String choice = "";
        String inArgs = "";
        Command command = new Command(CommandType.UNKNOWN, new String[]{});

        Printer.printTitle();
        if (args.length > 0) {
            inArgs = args[0];
            command = Parser.getCommandFromArgs(inArgs, app.availableCommands);
            app.nextMove(command);
        }
        //until there's no exit commnad keep asking for input
        while (command.getCommand() != CommandType.EXIT) {
            command = Parser.getCommand(app.availableCommands);
            app.nextMove(command);
        }
    }
}
