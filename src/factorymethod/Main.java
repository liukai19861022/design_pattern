package factorymethod;

public class Main {

    public static void main(String[] args) {

        Moveable m = new Broom();
        m.go();

        Moveable car = CarFactory.getInstance().create();
        car.go();
        Moveable plane = PlaneFactory.getInstance().create();
        plane.go();
    }
}