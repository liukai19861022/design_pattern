package singleton;
/**
 * lazy loadingpublic class Mgr05 {
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来了线程不安全的问题
 * 可以通过syncchranized解决，但也带来效率下降
 * 为提高效率使用syncchranized同步代码块、但此版本并不能解决多线程访问下，只有一个实例
 */
public class Mgr05 {

    private static Mgr05 INSTANCE = null;

    private Mgr05() {}

    public static Mgr05 getInstance() {

        if (INSTANCE == null) {

            synchronized (Mgr05.class) {

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mgr05();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {

        for (int i=0; i<100; i++) {

            new Thread(()->{
                System.out.println(Mgr05.getInstance().hashCode());
            }).start();
        }
    }
}
