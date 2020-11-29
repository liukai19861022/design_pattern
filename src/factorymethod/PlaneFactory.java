package factorymethod;

public class PlaneFactory {

    private PlaneFactory() {}

    private static final PlaneFactory INSTANCE = new PlaneFactory();

    public static PlaneFactory getInstance() {
        return INSTANCE;
    }

    public Moveable create() {

        System.out.println("a plane created");
        return new Plane();
    }
}
