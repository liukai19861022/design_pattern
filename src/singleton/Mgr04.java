package singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来了线程不安全的问题
 * 可以通过syncchranized解决，但也带来效率下降
 */
public class Mgr04 {

    private static Mgr04 INSTANCE = null;

    private Mgr04() {}

    public static synchronized Mgr04 getInstance() {

        if (INSTANCE == null) {

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            INSTANCE = new Mgr04();
        }

        return INSTANCE;
    }

    public static void main(String[] args) {

        for (int i=1; i<100; i++) {

            new Thread(()->{
                System.out.println(Mgr04.getInstance().hashCode());
            }).start();
        }
    }
}
