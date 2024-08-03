package behavioral.chain_of_responsibility;


public class Character {
    private Game game;
    public String name;
    public int baseAttack, baseDefense;

    public Character(Game game,
                     String name,
                     int baseAttack,
                     int baseDefense) {
        this.game = game;
        this.name = name;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
    }

    int getAttack() {
        Query q = new Query(name, Query.Argument.ATTACK, baseAttack);
        game.queries.fire(q);
        return q.result;
    }

    int getDefense() {
        Query q = new Query(name, Query.Argument.DEFENSE, baseDefense);
        game.queries.fire(q);
        return q.result;
    }

    @Override
    public String toString() {
        return String.format(
                "Creature(game=\"%s\", name=\"%s\", attack=%d, defense=%d)",
                game, name, getAttack(), getDefense()
        );
    }
}


class MainTwo {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        Character goblin = new Character(game, "Strong Goblin", 5, 5);
        System.out.println(goblin);

        // --------------------

        IncreaseDefenseMod increaseDefenseMod = new IncreaseDefenseMod(game, goblin);
        DoubleAttackMod doubleAttackMod = new DoubleAttackMod(game, goblin);

        try (doubleAttackMod) {
            System.out.println("Inside try block: " + goblin);
        }
        System.out.println("Double attack mod goes back: " + goblin);
    }
}
