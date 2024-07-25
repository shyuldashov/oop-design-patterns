package creational.singleton;

public class SyncAccessorSingleton {
    private static SyncAccessorSingleton INSTANCE;

    public static synchronized SyncAccessorSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SyncAccessorSingleton();
        }
        return INSTANCE;
    }
}
