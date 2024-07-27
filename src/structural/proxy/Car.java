package structural.proxy;


public class Car implements Drivable {
    protected Driver driver;

    public Car(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void drive() {
        System.out.printf("Car is being driven by %s!%n", driver.name);
    }
}
