package singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到按需初始化的目的，但却带来了线程不安全的问题
 * 多线程访问时会有问题、多个线程间并发同时判断到INSTANCE == nul、会new出多个实例
 */
public class Mgr03 {

    private static Mgr03 INSTANCE = null;

    private Mgr03() {
    }

    public static Mgr03 getInstance() {

        if (INSTANCE == null) {
            //测试代码start、增加被其他线程打断的机会，更容易发现代码的问题
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //测试代码end
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {

        for (int i=1; i<=100; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Mgr03.getInstance().hashCode());
                }
            }).start();

            new Thread(()-> {System.out.println(Mgr03.getInstance().hashCode());} ).start();
        }
    }
}
