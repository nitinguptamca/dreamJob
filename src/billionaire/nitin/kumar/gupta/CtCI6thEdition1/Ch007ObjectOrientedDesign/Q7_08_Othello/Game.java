package billionaire.nitin.kumar.gupta.CtCI6thEdition1.Ch007ObjectOrientedDesign.Q7_08_Othello;

public class Game {
    private static Game instance;
    private final int ROWS = 10;
    private final int COLUMNS = 10;
    private Player[] players;
    private Board board;

    private Game() {
        board = new Board(ROWS, COLUMNS);
        players = new Player[2];
        players[0] = new Player(Color.Black);
        players[1] = new Player(Color.White);
        Automator.getInstance().initialize(players); // used for testing
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public Board getBoard() {
        return board;
    }
}
