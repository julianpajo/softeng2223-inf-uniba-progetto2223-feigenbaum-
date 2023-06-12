package it.uniba.app;
import it.uniba.app.enumType.Difficulty;
import it.uniba.app.enumType.GridSize;
import it.uniba.app.enumType.ResultType;
import it.uniba.app.type.Capitalship;
import it.uniba.app.type.Carrier;
import it.uniba.app.type.Cell;
import it.uniba.app.type.Cruiser;
import it.uniba.app.type.Destroyer;
import it.uniba.app.type.Grid;
import it.uniba.app.type.Ship;
import java.util.Arrays;
import java.util.Random;

/**
 * Class that represents the game.
 */
public class Game {
    /**
     * final int indica il numero di tentativi massimi in difficoltà  facile
     * di default.
     */
    private static final int DEFAULTATTEMPTSEASY = 50;
    /**
     * final int indica il numero di tentativi massimi in difficoltà media
     * di default.
     */
    private static final int DEFAULTATTEMPTSMEDIUM = 30;
    /**
     * final int indica il numero di tentativi massimi in difficoltà diffcile
     * di default.
     */
    private static final int DEFAULTATTEMPTSHARD = 10;
    /**
     * final int indica la grandezza della griglia di gioco standard.
     */
    private static final int DEFAULTSIZE = 10;
    /**
     * final int indica la grandezza della griglia di gioco large.
     */
    private static final int LARGESIZE = 18;
    /**
     * final int indica la grandezza della griglia di gioco extra large.
     */
    private static final int EXTRALARGESIZE = 26;
    /**
     * Private boolean indica se il gioco è in esecuzione o meno.
     */
    private Boolean isRunning = false;

    /**
     * Private static Random object.
     */
    private static final Random RANDOM = new Random();
    /**
     * int indica il numero di tentativi massimi in difficoltà facile.
     */
    private int nAttemptsEasy = DEFAULTATTEMPTSEASY;
    /**
     * int indica il numero di tentativi massimi in difficoltà media.
     */
    private int nAttemptsMedium = DEFAULTATTEMPTSMEDIUM;
    /**
     * int indica il numero di tentativi massimi in difficoltà difficile.
     */
    private int nAttemptsHard = DEFAULTATTEMPTSHARD;
    /**
     * int indica il numero di tentativi massimi personalizzati.
     */
    private int nAttemptsCustom = 0;
    /**
     * final int indica il numero di Destroyer.
     */
    private static final int N_DESTROYER = 4;
    /**
     * final int indica il numero di Cruiser.
     */
    private static final int N_CRUISER = 3;
    /**
     * final int indica il numero di Capitalship.
     */
    private static final int N_CAPITALSHIP = 2;
    /**
     * final int indica il numero di Carriers.
     */
    private static final int N_CARRIER = 1;

    /**
     * final int indica il valore di ritorno nel caso la ship
     * venga colpita più volte nella stessa cella.
     */
    private static final int RESULT_MORE_HITS = 3;
    /**
     * private int Tentativi rimanenti.
     */
    private int remaningAttempts;
    /**
     * private int Tentativi di successo.
     */
    private int succesfulAttempts = 0;
    /**
     * private int Tentativi falliti.
     */
    private int failedAttempts = 0;
    /**
     * private int Destroyers rimanenti.
     */
    private int remaningDestroyers;
    /**
     * private int Cruisers rimanenti.
     */
    private int remaningCruisers;
    /**
     * private int Capitalships rimanenti.
     */
    private int remaningCapitalships;
    /**
     * private int Carriers rimanenti.
     */
    private int remaningCarriers;
    /**
     * private char matrix that represents the grid.
     */
    private Grid grid;
    /**
     * private String that represents the maximum number of attempts.
     */
    private int maxAttempts;
    /**
     * private final String[] le possibili etichette delle colonne.
     */
    private final String[] columsLabels = {"A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z"};
    /**
     * private final String[] le etichette delle colonne attuali.
     */
    private String[] currentColumnsLabels;
    /**
     * private GridSize rappresenta la dimesione della griglia.
     */
    private GridSize gridSize;
    /**
     * private String that represents the difficulty.
     */
    private Difficulty difficulty = Difficulty.MEDIUM;


    /**
     * Inizializza la griglia.
     */
    private void initializeGrid() {
        grid = new Grid(gridSize);
        for (int i = 0; i < grid.getSize().getSize(); i++) {
            for (int j = 0; j < grid.getSize().getSize(); j++) {
                grid.setCell(i, j, new Cell(i, j));
            }
        }
    }

    /**
     * Popola la griglia con le navi in modo casuale.
     * @param ship le navi da posizionare
     */
    private void populateShip(final Ship ship) {
        boolean isPlaced = false;

        while (!isPlaced) {
            int direction = RANDOM.nextInt(2);
            int x = RANDOM.nextInt(gridSize.getSize());
            int y = RANDOM.nextInt(gridSize.getSize());

            // check if position is valid
            if (checkPosition(grid, x, y, direction,
                    ship.getSize().getSize())) {
                // Populate the ship in the grid
                for (int i = 0; i < ship.getSize().getSize(); i++) {
                    if (direction == 0) {
                        grid.setCell(x, y + i, new Cell(ship));
                    } else {
                        grid.setCell(x + i, y, new Cell(ship));
                    }
                }
                isPlaced = true;
            }
        }
    }

    /**
     * Controllo se la posizione delle navi è valida.
     * @param grid la griglia.
     * @param x la coordinata x.
     * @param y la coordinata y.
     * @param direction la direzione.
     * @param size la dimensione.
     * @return true se la posizione è valida, false altrimenti.
     */
    private static boolean checkPosition(
            final Grid grid, final int x, final int y, final int direction,
            final int size
    ) {
        if (direction == 0) {
            // check if the ship is inside the grid
            if (y + size > grid.getSize().getSize()) {
                return false;
            }
            // check if the ship overlaps with other ships
            for (int i = 0; i < size; i++) {
                if (grid.isShip(x, y + i)) {
                    return false;
                }
            }
        } else {
            // check if the ship is inside the grid
            if (x + size > grid.getSize().getSize()) {
                return false;
            }
            // check if the ship overlaps with other ships
            for (int i = 0; i < size; i++) {
                if (grid.isShip(x + i, y)) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Effettua un colpo sulla griglia.
     * @param col la colonna.
     * @param row la riga.
     * @return 1 se colpito, 0 se non colpito, 2 se colpito e affondato, 3 se già colpito.
     */
    public ResultType hit(final String col, final int row) {
        int y = getColumnIndex(col);
        int x = row - 1;
        Boolean isHit;
        Cell cell;
        Boolean isAlreadyHit = grid.getCell(x, y).isHit();
        if (isAlreadyHit) {
            return ResultType.ALREADYHIT;
        }
        isHit = grid.hit(x, y);
        cell = grid.getCell(x, y);
        if (isHit) {
            if (cell.getShip().isSunk()) {
                switch (cell.getShip().getName()) {
                    case "Destroyer" -> setRemaningDestroyers(getRemaningDestroyers() - 1);
                    case "Cruiser" -> setRemaningCruisers(getRemaningCruisers() - 1);
                    case "Capitalship" -> setRemaningCapitalships(getRemaningCapitalships() - 1);
                    case "Carrier" -> setRemaningCarriers(getRemaningCarriers() - 1);
                    default -> {
                    }
                }
                setSuccesfulAttempts(getSuccesfulAttempts() + 1);
                return ResultType.HITANDSUNK;
            } else {
                setSuccesfulAttempts(getSuccesfulAttempts() + 1);
                return ResultType.HIT;
            }
        }
        setFailedAttempts(getFailedAttempts() + 1);
        setRemaningAttempts(getRemaningAttempts() - 1);
        return ResultType.MISS;
    }

    /**
     * Populate the grid with ships.
     */
    public void newGame() {
        initializeGrid();
        // setDifficulty();
        currentColumnsLabels = Arrays.copyOfRange(columsLabels, 0,
                gridSize.getSize());
        // ships definition
        Ship[] ships = {
                new Destroyer(),
                new Destroyer(),
                new Destroyer(),
                new Destroyer(),
                new Cruiser(),
                new Cruiser(),
                new Cruiser(),
                new Capitalship(),
                new Capitalship(),
                new Carrier()
        };
        // grid population
        for (Ship ship : ships) {
            populateShip(ship);
        }

        setRemaningCapitalships(N_CAPITALSHIP);
        setRemaningCarriers(N_CARRIER);
        setRemaningCruisers(N_CRUISER);
        setRemaningDestroyers(N_DESTROYER);

    }

    /**
     * Imposta la difficoltà del gioco.
     * @param difficultyParam difficoltà da impostare.
     */
    public void setDifficulty(final Difficulty difficultyParam) {
        this.difficulty = difficultyParam;
        switch (difficulty) {
            case EASY -> setMaxAttempts(nAttemptsEasy);
            case MEDIUM -> setMaxAttempts(nAttemptsMedium);
            case HARD -> setMaxAttempts(nAttemptsHard);
            case CUSTOM -> setMaxAttempts(nAttemptsCustom);
            default -> {
            }
        }
        this.remaningAttempts = maxAttempts;
    }

    /**
     * Metodo che controlla la validità delle coordinate.
     * @param col la colonna.
     * @param row la riga.
     * @return true se le coordinate sono valide, false altrimenti.
     */
    public boolean checkValidity(final String col, final int row) {
        GridSize size = getGrid().getSize();
        boolean isValid = true;
        isValid = Arrays.asList(currentColumnsLabels).contains(col);
        if ((row > size.getSize() || row < 1)) {
            return false;
        }
        if (!isValid) {
            return false;
        }
        return true;
    }

    /**
     * Imposta il numero massimo di tentativi.
     * @param maxAttemptsParam il numero massimo di tentativi.
     */
    public void setMaxAttempts(final int maxAttemptsParam) {
        this.maxAttempts = maxAttemptsParam;
    }

    /**
     * Get the difficulty.
     * @return the difficulty
     */
    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    /**
     * Ritorna il numero di tentativi rimanenti.
     * @return the maximum number of attempts
     */
    public int getRemaningAttempts() {
        return this.remaningAttempts;
    }

    /**
     * Get the maximum number of attempts.
     * @return the maximum number of attempts
     */
    public int getAttempts() {
        return this.maxAttempts;
    }

    /**
     * Set the grid size.
     * @param gridSizeParam the grid size to set
     */
    public void setGridSize(final GridSize gridSizeParam) {
        this.gridSize = gridSizeParam;
    }

    /**
     * Restituisce la griglia.
     * @return Grid.
     */
    public Grid getGrid() {
        return grid.copy();
    }

    /**
     * Costruttore.
     * @param gridSizeParam la dimensione della griglia.
     * @param difficultyParam la difficoltà.
     */
    public Game(final GridSize gridSizeParam,
                final Difficulty difficultyParam) {
        setGridSize(gridSizeParam);
        setDifficulty(difficultyParam);
        newGame();
    }


    /**
     * Restituisce il numero di tentativi andati a segno.
     * @param gridSizeParam la dimensione della griglia.
     *                      (small, medium, large).
     * @param difficultyParam la difficoltà.
     *                       (easy, medium, hard, custom).
     * @param attempts il numero di tentativi.
     */
    public Game(final GridSize gridSizeParam,
                final Difficulty difficultyParam,
                final int attempts) {
        setGridSize(gridSizeParam);
        setDifficulty(difficultyParam);
        setAttempts(attempts);
        newGame();
    }

    /**
     * ritorna il numero di carriers rimanenti.
     * @return carriers rimanenti.
     */
    public int getRemaningCarriers() {
        return remaningCarriers;
    }

    /**
     * ritorna il numero massimo di tentativi.
     * @return numero massimo di tentativi.
     */
    public int getMaxAttempts() {
        return maxAttempts;
    }

    /**
     * ritorna la grandezza della griglia.
     * @return grandezza della griglia.
     */
    public GridSize getGridSize() {
        return gridSize;
    }

    /**
     * Indica se la partita è terminata.
     * @return boolean.
     */
    public boolean isRunning() {
        return isRunning;

    }

    /**
     * Imppsta se la partita è in eseuzione.
     * @param  isRunningParam boolean.
     */
    public void setIsRunning(final boolean isRunningParam) {
        this.isRunning = isRunningParam;
    }

    /**
     * Restituisce le etichette delle colonne.
     * @return String[].
     */
    public String[] getCurrentColumnsLabels() {
        return currentColumnsLabels.clone();
    }

    /**
     * Restituisce le etichette delle colonne.
     * @param colLabel etichetta della colonna.
     * @return Lista di colonne
     */
    public int getColumnIndex(final String colLabel) {
        return Arrays.asList(columsLabels).indexOf(colLabel.toUpperCase());
    }

    /**
     * Modifica il numero di tentativi.
     * @param attempts
     */
    public void setAttempts(final int attempts) {
        this.maxAttempts = attempts;
        this.remaningAttempts = attempts;
    }

    /**
     * Modifica il numero di tentativi in difficoltà facile.
     * @param attempts
     */
    public void setEasyAttempts(final int attempts) {
        this.nAttemptsEasy = attempts;
    }
    /**
     * Modifica il numero di tentativi in difficoltà media.
     * @param attempts
     */
    public void setMediumAttempts(final int attempts) {
        this.nAttemptsMedium = attempts;
    }

    /**
     * Modifica il numero di tentativi in difficoltà difficile.
     * @param attempts
     */
    public void setHardAttempts(final int attempts) {
        this.nAttemptsHard = attempts;
    }

    /**
     * Restituisce il numero di tentativi in difficoltà facile.
     * @return nAttemptsEasy.
     */
    public int getEasyAttempts() {
        return nAttemptsEasy;
    }

    /**
     * Restituisce il numero di tentativi in difficoltà media.
     * @return nAttemptsMedium.
     */
    public int getMediumAttempts() {
        return nAttemptsMedium;
    }

    /**
     * Restituisce il numero di tentativi in difficoltà difficile.
     * @return nAttemptsHard.
     */
    public int getHardAttempts() {
        return nAttemptsHard;
    }

    /**
     * Restituisce il numero di tentativi rimanenti.
     * @return succesfulAttempts.
     */
    public int getSuccesfulAttempts() {
        return succesfulAttempts;
    }

    /**
     * Modifica il numero di tentativi andati a segno.
     * @param succesfulAttemptsParam
     */
    public void setSuccesfulAttempts(final int succesfulAttemptsParam) {
        this.succesfulAttempts = succesfulAttemptsParam;
    }

    /**
     * Imposta il numero di tentativi rimanenti.
     * @param remaningAttemptsParam il numero di tentativi rimanenti.
     */
    public void setRemaningAttempts(final int remaningAttemptsParam) {
        this.remaningAttempts = remaningAttemptsParam;
    }

    /**
     * Imposta la griglia di gioco.
     * @param gridParam la griglia di gioco.
     */
    public void setGrid(final Grid gridParam) {
        this.grid = gridParam.copy();
    }

    /**
     * Restituisce il numero di tentativi falliti.
     * @return failedAttempts.
     */
    public int getFailedAttempts() {
        return failedAttempts;
    }

    /**
     * Modifica il numero di tentativi falliti.
     * @param failedAttemptsParam
     */
    public void setFailedAttempts(final int failedAttemptsParam) {
        this.failedAttempts = failedAttemptsParam;
    }


    /**
     * Modifica il numero di navi Carriers rimanenti.
     * @param remaningCarriersParam
     */
    public void setRemaningCarriers(final int remaningCarriersParam) {
        this.remaningCarriers = remaningCarriersParam;
    }

    /**
     * Restituisce il numero di navi Capitalships rimanenti.
     * @return remaningCapitalships.
     */
    public int getRemaningCapitalships() {
        return remaningCapitalships;
    }

    /**
     * Modifica il numero di navi Capitalships rimanenti.
     * @param remaningCapitalshipsParam
     */
    public void setRemaningCapitalships(final int remaningCapitalshipsParam) {
        this.remaningCapitalships = remaningCapitalshipsParam;
    }

    /**
     * Restituisce il numero di navi Cruisers rimanenti.
     * @return remaningCruisers.
     */
    public int getRemaningCruisers() {
        return remaningCruisers;
    }

    /**
     * Modifica il numero di navi Cruisers rimanenti.
     * @param remaningCruisersParam
     */
    public void setRemaningCruisers(final int remaningCruisersParam) {
        this.remaningCruisers = remaningCruisersParam;
    }

    /**
     * Restituisce il numero di navi Destroyers rimanenti.
     * @return remaningDestroyers.
     */
    public int getRemaningDestroyers() {
        return remaningDestroyers;
    }

    /**
     * Modifica il numero di navi Destroyers rimanenti.
     * @param remaningDestroyersParam
     */
    public void setRemaningDestroyers(final int remaningDestroyersParam) {
        this.remaningDestroyers = remaningDestroyersParam;
    }

    /**
     * Metodo che controlla se la partita è vinta.
     * @return boolean.
     */
    public boolean isWon() {
        if (getRemaningCapitalships() == 0 && getRemaningCarriers() == 0
                && getRemaningCruisers() == 0 && getRemaningDestroyers() == 0
                && getRemaningAttempts() > 0) {
            return true;
        }
        return false;
    }

    /**
     * Restituisce la copia del gioco.
     * @return copia del gioco.
     */
    public Game copy() {
        Game clone = new Game(gridSize, difficulty);
        clone.setAttempts(maxAttempts);
        clone.setIsRunning(isRunning);
        clone.setSuccesfulAttempts(succesfulAttempts);
        clone.setFailedAttempts(failedAttempts);
        clone.setRemaningAttempts(remaningAttempts);
        clone.setGrid(this.grid);
        clone.setRemaningCarriers(remaningCarriers);
        clone.setRemaningCapitalships(remaningCapitalships);
        clone.setRemaningCruisers(remaningCruisers);
        clone.setRemaningDestroyers(remaningDestroyers);
        return clone;
    }

}
