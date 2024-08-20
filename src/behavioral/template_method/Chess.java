package behavioral.template_method;


public class Chess extends Game {
    private final int maxTurns = 10;
    private int turn = 1;

    public Chess() {
        // In a classic chess game the number of players is 2
        super(2);
    }

    @Override
    protected int getWinningPlayer() {
        return 0;
    }

    @Override
    protected void takeTurn() {
        System.out.printf("Turn %d taken by player %d%n", turn++, currentPlayer);
        currentPlayer = (currentPlayer + 1) % numOfPlayers;
    }

    @Override
    protected boolean haveWinner() {
        return turn == maxTurns;
    }

    @Override
    protected void start() {
        System.out.println("Starting a game of Chess");
    }
}


class Main {
    public static void main(String[] args) {
        Chess game = new Chess();
        game.run();
    }
}
