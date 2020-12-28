package proxy.v02;

import java.util.Random;

/**
 * 坦克跑起来、并让坦克跑一段时间、记录坦克移动的时间
 * 问题：我想记录坦克的移动时间
 * 最简单的办法就是修改源码，记录时间
 * 问题2：如果无法修改源码呢？
 *
 */
public class Tank implements Moveable{

    /**
     * 模拟坦克移动了多少时间
      */
    @Override
    public void move() {
        System.out.println("tank moveing.....");

        long startMillTime = System.currentTimeMillis();
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endMillTime = System.currentTimeMillis();
        System.out.println(endMillTime-startMillTime);

    }

    public static void main(String[] args) {
        new Tank().move();
    }
}

interface Moveable {

    void move();
}