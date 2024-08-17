package behavioral.observer;

import java.io.Closeable;
import java.io.IOException;


public class Rat implements Closeable {
    private Game game;
    public int attack = 1;

    public Rat(Game game) {
        this.game = game;
        game.ratEnters.subscribe((sender, arg) -> {
            if (sender != this) {
                ++attack;
                game.notifyRat.invoke(this, (Rat) sender);
            }
        });

        game.notifyRat.subscribe((sender, rat) -> {
            if (rat == this) {
                ++attack;
            }
        });
        game.ratDies.subscribe((sender, arg) -> --attack);
        game.ratEnters.invoke(this, null);
    }

    @Override
    public void close() throws IOException {
        game.ratDies.invoke(this, null);
    }
}


class Main {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        Rat rat1 = new Rat(game);
        Rat rat2 = new Rat(game);
        Rat rat3 = new Rat(game);

        System.out.println(rat1.attack);
        rat3.close();
        System.out.println(rat1.attack);
    }
}
