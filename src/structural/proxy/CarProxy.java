package structural.proxy;


public class CarProxy extends Car {

    public CarProxy(Driver driver) {
        super(driver);
    }

    @Override
    public void drive() {
        int MIN_AGE_TO_DRIVE_CAR = 16;
        if (driver.age >= MIN_AGE_TO_DRIVE_CAR) {
            super.drive();
        } else {
            System.out.printf("Driver %s too young!%n", driver.name);
        }
    }
}


class Main {
    public static void main(String[] args) {
        // Driver age is not checked
        Car car = new Car(new Driver("Mike", 23));
        car.drive();

        // Driver age is checked
        Car car2 = new CarProxy(new Driver("John", 15));
        car2.drive();
    }
}
