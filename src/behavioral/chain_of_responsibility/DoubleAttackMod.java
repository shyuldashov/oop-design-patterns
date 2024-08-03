package behavioral.chain_of_responsibility;


public class DoubleAttackMod
        extends CharacterModifier implements AutoCloseable {
    private final int token;

    public DoubleAttackMod(Game game, Character character) {
        super(game, character);
        // Subscribe mediator (Game) to all queries
        token = game.queries.subscribe(query -> {
            if (query.creatureName.equals(character.name)
                    && query.argument == Query.Argument.ATTACK) {
                query.result *= 2;
            }
        });
    }

    @Override
    public void close() throws Exception {
        // Unsubscribe from handling any changes to the underlying character
        game.queries.unsubscribe(token);
    }
}
