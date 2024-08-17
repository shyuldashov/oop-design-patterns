package behavioral.state;

public class Pair<T, S> {
    private final T trigger;
    private final S state;


    public Pair(T trigger, S state) {
        this.trigger = trigger;
        this.state = state;
    }

    public S getState() {
        return state;
    }

    public T getTrigger() {
        return trigger;
    }

}
