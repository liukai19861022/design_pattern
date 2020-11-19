package singleton;

/**
 * 不仅可以解决线程安全同步，还可以防止反序列化
 * effective java一书中，java创始人之一写到的方法
 */
public enum Mgr08 {

    INSTANCE;

    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            new Thread(()->{
                System.out.println(Mgr08.INSTANCE.hashCode());
            }).start();
        }
    }

}
