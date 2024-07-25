package creational.singleton;

public class DoubleCheckedLockingSingleton {
    private static DoubleCheckedLockingSingleton INSTANCE;

    public static DoubleCheckedLockingSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (LazySingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return INSTANCE;
    }
}
