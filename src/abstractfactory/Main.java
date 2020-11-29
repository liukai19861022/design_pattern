package abstractfactory;

import factorymethod.Broom;
import factorymethod.CarFactory;
import factorymethod.Moveable;
import factorymethod.PlaneFactory;

public class Main {

    public static void main(String[] args) {

        System.out.println("modern");
        //old modern
        Car car = new Car();
        Ak47 ak47 = new Ak47();
        Bread bread = new Bread();


        //abstractfactory
        ModernFactory modern = ModernFactory.getInstance();
        modern.createVehicle().go();
        modern.createWeapon().shoot();
        modern.createFood().printName();

        System.out.println("---------------------");

        System.out.println("magicman");
        MagicFactory magicMan = MagicFactory.getInstance();
        magicMan.createVehicle().go();
        magicMan.createWeapon().shoot();
        magicMan.createFood().printName();


    }
}
