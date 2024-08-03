package behavioral.chain_of_responsibility;


public class DoubleAttackModifier extends CreatureModifier {

    public DoubleAttackModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        System.out.printf("Doubling %s's attack%n", creature.name);
        creature.attack *= 2;
        super.handle();
    }
}
