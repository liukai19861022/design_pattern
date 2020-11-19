package singleton;

/**
 * 跟01是一个意思
 */
public class Mgr02 {

    private static final Mgr02 INSTANCE = null;
    static {
        Mgr02 INSTANCE = new Mgr02();
    }

    private Mgr02() {
    }


    public static Mgr02 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mgr02 m1 = Mgr02.getInstance();
        Mgr02 m2 = Mgr02.getInstance();
        System.out.println(m1 == m2);
    }

}
