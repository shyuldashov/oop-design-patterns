package creational.singleton;

import java.io.*;

public class SimpleSingleton implements Serializable {
    // Private instance
    private static final SimpleSingleton INSTANCE = new SimpleSingleton();
    private int value = 0;


    private SimpleSingleton() {
    }

    // Expose the singleton
    public static SimpleSingleton getInstance() {
        return INSTANCE;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // Hint to the JVM that serialization should happen on this instance.
    @Serial
    protected Object readResolve() {
        return INSTANCE;
    }
}

class Demo {
    // Serialization
    static void saveToFile(SimpleSingleton singleton, String filename) throws Exception {
        try (
                FileOutputStream fileOut = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(fileOut)
        ) {
            out.writeObject(singleton);
        }
    }

    // Deserialization
    static SimpleSingleton readFromFile(String filename) throws Exception {
        try (
                FileInputStream fileIn = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(fileIn)
        ) {
            return (SimpleSingleton) in.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        // new SimpleSingleton(); // cannot call with private constructor
        SimpleSingleton singleton = SimpleSingleton.getInstance();
        singleton.setValue(111);

        // Show how serialization is problematic with singletons
        String filename = "singleton.txt";
        saveToFile(singleton, filename);

        singleton.setValue(222);

        // --------------------

        SimpleSingleton singleton2 = readFromFile(filename);

        // returns without readResolve()
        /* System.out.println(singleton == singleton2); // false
        System.out.println(singleton.getValue()); // returns 222
        System.out.println(singleton2.getValue()); // returns 111 */

        // returns with readResolve()
        System.out.println(singleton == singleton2); // true
        System.out.println(singleton.getValue()); // returns 222
        System.out.println(singleton2.getValue()); // returns 222
    }
}
