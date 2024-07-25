package creational.singleton;

public class ClassHolderSingleton {
    private ClassHolderSingleton() {

    }

    private static class Inner {
        private static final ClassHolderSingleton
                INSTANCE = new ClassHolderSingleton();
    }

    public ClassHolderSingleton getInstance() {
        return Inner.INSTANCE;
    }
}
