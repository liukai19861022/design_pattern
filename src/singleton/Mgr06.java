package singleton;
/**
 * lazy loadingpublic class Mgr05 {
 * 也称懒汉式
 * 可以通过syncchranized同步代码块解决，同时效率优于在方法上加锁、是最完美的版本
 */
public class Mgr06 {

    private static Mgr06 INSTANCE = null;

    private Mgr06() {}

    public static Mgr06 getInstance() {

        if (INSTANCE == null) {

            synchronized (Mgr06.class) {

                if (INSTANCE == null) {

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    INSTANCE = new Mgr06();
                }
            }
        }

        return INSTANCE;
    }

    public static void main(String[] args) {

        for (int i=0; i<100; i++) {
            new Thread(()->{
                System.out.println(Mgr06.getInstance().hashCode());
            }).start();
        }
    }
}
