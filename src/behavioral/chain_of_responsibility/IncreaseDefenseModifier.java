package behavioral.chain_of_responsibility;


public class IncreaseDefenseModifier extends CreatureModifier {

    public IncreaseDefenseModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        System.out.printf("Increasing %s's defense%n", creature.name);
        creature.defense += 3;
        super.handle();
    }
}
