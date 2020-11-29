package factorymethod;

/**
 * 简单工厂模式可扩展性并不好
 */
public class SimpleVeHicleFactory {

    public Car createCar () {
        //before processing
        return new Car();
    }

    public Broom createBroom() {
        return new Broom();
    }
}
