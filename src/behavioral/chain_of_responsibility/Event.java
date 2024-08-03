package behavioral.chain_of_responsibility;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;


// Command Query Separation (Observer pattern used here)
public class Event<Args> {
    private int index = 0; // Key into the map to find a consumer
    private Map<Integer, Consumer<Args>> handlers = new HashMap<>();

    /**
     * Subscribe to the event
     * @param handler Event handler
     * @return
     */
    public int subscribe(Consumer<Args> handler) {
        int i = index;
        handlers.put(index++, handler);
        return i;
    }

    /**
     * Unsubscribe from event per consumer
     * @param key `key` into the map to find a consumer
     */
    public void unsubscribe(int key) {
        handlers.remove(key);
    }

    /**
     * Fire the event on every single consumer
     * @param args
     */
    public void fire(Args args) {
        for (Consumer<Args> handler : handlers.values()) {
            handler.accept(args);
        }
    }
}
