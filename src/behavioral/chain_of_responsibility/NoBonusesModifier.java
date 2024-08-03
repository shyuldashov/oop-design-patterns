package behavioral.chain_of_responsibility;


public class NoBonusesModifier extends CreatureModifier {

    public NoBonusesModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        System.out.println("No bonuses for you!");
        // Don't call super.handle() to interrupt chain
        // after this one is called
    }
}
