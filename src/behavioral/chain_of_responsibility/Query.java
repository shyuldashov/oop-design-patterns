package behavioral.chain_of_responsibility;


public class Query {

    enum Argument {
        ATTACK,
        DEFENSE
    }
    
    public String creatureName;
    public Argument argument;
    public int result; // value of the handlers

    public Query(String creatureName, Argument argument, int result) {
        this.creatureName = creatureName;
        this.argument = argument;
        this.result = result;
    }
}
