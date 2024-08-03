package behavioral.chain_of_responsibility;


public class IncreaseDefenseMod extends CharacterModifier {
    public IncreaseDefenseMod(Game game, Character character) {
        super(game, character);

        game.queries.subscribe(query -> {
            if (query.creatureName.equals(character.name)
                    && query.argument == Query.Argument.DEFENSE) {
                query.result += 3;
            }
        });
    }
}
