package proxy.v06.v05;

import java.util.Random;

/**
 * 坦克跑起来、并让坦克跑一段时间、记录坦克移动的时间
 * 问题：我想记录坦克的移动时间
 * 最简单的办法就是修改源码，记录时间
 * 问题2：如果无法修改源码呢？
 * 如何实现代理的各种组合、被代理人必须由坦克改为Moveable、此时就可以实现 坦克时间代理去代理坦克、 坦克日志代理去代理坦克时间代理
 *
 * 此版本为最基础静态代理
 * 共同实现了Moveable接口、并且共同代理Moveable，所以可以实现互相嵌套
 */
public class Tank implements Moveable {

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
        new TankLogProxy(new TankTimeProxy(new Tank())).move();
//        new TankTimeProxy(new TankLogProxy(new Tank())).move();
    }
}

class TankTimeProxy implements Moveable {

    Moveable m;

    @Override
    public void move() {
        long startMillTime = System.currentTimeMillis();
        m.move();
        long endMillTime = System.currentTimeMillis();
        System.out.println(endMillTime-startMillTime);
    }

    public TankTimeProxy(Moveable m) {
        this.m = m;
    }

}

class TankLogProxy implements Moveable {

    Moveable m;

    @Override
    public void move() {
        System.out.println("start logging");
        m.move();
        System.out.println("end logging");
    }

    public TankLogProxy(Moveable m) {
        this.m = m;
    }

}

interface Moveable {

    void move();
}

