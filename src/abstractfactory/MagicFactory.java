package abstractfactory;

public class MagicFactory extends AbstractFactory{

    private MagicFactory() {}

    private static class MagincFactoryHolder {

        private static final MagicFactory INSTANCE = new MagicFactory();
        private static final Vehicle VEHICLEINSTANCE = new Broom();
        private static final Weapon WEAPONINSTANCE = new MagicStick();
        private static final Food FOODINSTANCE = new MushRoom();
    }

    public static MagicFactory getInstance() {
        return MagincFactoryHolder.INSTANCE;
    }

    @Override
    public Vehicle createVehicle() {
        return MagincFactoryHolder.VEHICLEINSTANCE;
    }

    @Override
    public Weapon createWeapon() {
        return MagincFactoryHolder.WEAPONINSTANCE;
    }

    @Override
    public Food createFood() {
        return MagincFactoryHolder.FOODINSTANCE;
    }
}
