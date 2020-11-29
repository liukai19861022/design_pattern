package abstractfactory;

public class ModernFactory extends AbstractFactory {

    private ModernFactory () {}

    public static ModernFactory getInstance() {
        return ModernFactoryHolder.INSTANCE;
    }

    private static class ModernFactoryHolder {

        private static final ModernFactory INSTANCE = new ModernFactory();
        private static final Vehicle CARINSTANCE = new Car();
        private static final Weapon WEAPONINSTANCE = new Ak47();
        private static final Food FOODINSTANCE = new Bread();
    }

    @Override
    public Vehicle createVehicle() {

        return ModernFactoryHolder.CARINSTANCE;
    }

    @Override
    public Weapon createWeapon() {

        return ModernFactoryHolder.WEAPONINSTANCE;
    }

    @Override
    public Food createFood() {

        return ModernFactoryHolder.FOODINSTANCE;
    }
}
