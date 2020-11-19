package singleton;

/**
 * 静态内部类的方式
 * JVM保证线程安全（虚拟机加载一个类时，只加载一次）
 * 加载外部类时不会加载内部类，这样就可以实现懒加载
 * 完美版本之一、在加载Mgr07时，内部类Mgr07Holder不会被加载，调用getInstance时才会被加载
 */
public class Mgr07 {

    private Mgr07() {}

    private static class Mgr07Holder {
        private final static Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance() {
        return Mgr07Holder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            new Thread(()->{
                System.out.println(Mgr07.getInstance().hashCode());
            }).start();
        }
    }
}
