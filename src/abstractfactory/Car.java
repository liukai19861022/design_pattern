package abstractfactory;

import factorymethod.Moveable;

public class Car extends Vehicle{

    @Override
    public void go () {
        System.out.println("car runing...");
    }
}
