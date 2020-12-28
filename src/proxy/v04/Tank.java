package proxy.v04;

import java.util.Random;

/**
 * 坦克跑起来、并让坦克跑一段时间、记录坦克移动的时间
 * 问题：我想记录坦克的移动时间
 * 最简单的办法就是修改源码，记录时间
 * 问题2：如果无法修改源码呢？
 * 使用代理模式、该版本被代理人只能是坦克、应该让被代理人更灵活一些
 */
public class Tank implements Moveable{

    /**
     * 模拟坦克移动了多少时间
      */
    @Override
    public void move() {
        System.out.println("tank moveing.....");

        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class TankTimeProxy implements Moveable {

    Tank tank;

    @Override
    public void move() {
        long startMillTime = System.currentTimeMillis();
        tank.move();
        long endMillTime = System.currentTimeMillis();
        System.out.println(endMillTime-startMillTime);

    }

    public TankTimeProxy(Tank tank) {
        this.tank = tank;
    }


    public static void main(String[] args) {
        TankTimeProxy tankProxy = new TankTimeProxy(new Tank());
        tankProxy.move();
    }
}

interface Moveable {

    void move();
}

