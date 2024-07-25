package creational.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public enum EnumSingleton {
    INSTANCE;
    private int value;

    EnumSingleton() {
        value = 42;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class EnumDemo {
    // Serialization
    static void saveToFile(EnumSingleton singleton, String filename) throws Exception {
        try (
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)
        ) {
            out.writeObject(singleton);
        }
    }

    // Deserialization
    static EnumSingleton readFromFile(String filename) throws Exception {
        try (
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn)
        ) {
            return (EnumSingleton) in.readObject();
        }
    }

    public static void main(String[] args) throws Exception {
        // new EnumSingleton(); // cannot call with private constructor
        String filename = "enum_singleton.txt";

        EnumSingleton singleton = EnumSingleton.INSTANCE;
        singleton.setValue(111);
        saveToFile(singleton, filename);

        // --------------------

        EnumSingleton singleton2 = readFromFile(filename);
        System.out.println(singleton2.getValue());
    }
}
