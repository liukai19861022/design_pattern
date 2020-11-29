package factorymethod;

public class CarFactory {

    private CarFactory() {}

    private static class CarFactoryHolder {

        private static final CarFactory INSTANCE = new CarFactory();
    }

    public static CarFactory getInstance() {
        return CarFactoryHolder.INSTANCE;
    }

    public Moveable create() {
        System.out.println("a car created");

        return new Car();
    }
}
