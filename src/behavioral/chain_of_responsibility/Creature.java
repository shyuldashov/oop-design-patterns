package behavioral.chain_of_responsibility;


public class Creature {
    public String name;
    public int attack, defense;

    public Creature(String name, int attack, int defense) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
    }

    @Override
    public String toString() {
        return String.format(
                "Creature(name=\"%s\", attack=%d, defense=%d)",
                name, attack, defense
        );
    }
}


class Main {
    public static void main(String[] args) {
        Creature goblin = new Creature("Goblin", 5, 5);
        System.out.println(goblin);

        // Instantiate root class of CreatureModifier as a starting point
        CreatureModifier root = new CreatureModifier(goblin);

        // --------------------

        System.out.println("Let's double goblin's attack");
        root.add(new DoubleAttackModifier(goblin));
        // Subverts the chain of responsibility
        root.add(new NoBonusesModifier(goblin));

        System.out.println("Let's increase goblin's defense");
        root.add(new IncreaseDefenseModifier(goblin));

        // THIS is what traverses chain of responsibility
        root.handle();
        System.out.println(goblin);
    }
}
