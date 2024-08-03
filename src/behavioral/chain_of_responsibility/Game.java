package behavioral.chain_of_responsibility;


/**
 * Central location where any modifier can subscribe itself
 * to queries on the creature and modify its attributes
 */
public class Game {
    public Event<Query> queries = new Event<>();
}
