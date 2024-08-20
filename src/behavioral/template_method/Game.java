package behavioral.template_method;


public abstract class Game {
    protected int currentPlayer;
    protected final int numOfPlayers;

    public Game(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public void run() {
        start();
        while (!haveWinner()) {
            takeTurn();
        }
        System.out.printf("Player %d wins!%n", getWinningPlayer());
    }

    protected abstract int getWinningPlayer();

    protected abstract boolean haveWinner();

    protected abstract void takeTurn();

    protected abstract void start();

}
