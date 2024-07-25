package creational.singleton;


class LazySingleton {
    private static LazySingleton INSTANCE;

    private LazySingleton() {
        System.out.println("Initializing a Lazy Singleton");
    }

    public static LazySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }

        return INSTANCE;
    }
}
