package behavioral.chain_of_responsibility;

public class CharacterModifier {
    protected Game game;
    protected Character character;

    public CharacterModifier(Game game, Character character) {
        this.game = game;
        this.character = character;
    }
}
