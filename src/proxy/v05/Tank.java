package proxy.v05;

import java.util.Random;

/**
 * 坦克跑起来、并让坦克跑一段时间、记录坦克移动的时间
 * 问题：我想记录坦克的移动时间
 * 最简单的办法就是修改源码，记录时间
 * 问题2：如果无法修改源码呢？
 * 如何实现代理的各种组合、聚合Decorator
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

    public static void main(String[] args) {
        new TankTimeProxy(new Tank()).move();
        new TankLogProxy(new Tank()).move();
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

}

class TankLogProxy implements Moveable {

    Tank tank;

    @Override
    public void move() {
        System.out.println("start logging");
        tank.move();
        System.out.println("end logging");
    }

    public TankLogProxy(Tank tank) {
        this.tank = tank;
    }

}

interface Moveable {

    void move();
}

