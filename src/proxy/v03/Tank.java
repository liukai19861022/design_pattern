package proxy.v03;

import java.util.Random;

/**
 * 坦克跑起来、并让坦克跑一段时间、记录坦克移动的时间
 * 问题：我想记录坦克的移动时间
 * 最简单的办法就是修改源码，记录时间
 * 问题2：如果无法修改源码呢？
 * 最low、用继承、模拟测试中的benchMark，本质是在对整个方法进行时间记录、并达不到对某个细节点做测试
 *
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

class Tank2 extends Tank {

    @Override
    public void move() {

        long startMillTime = System.currentTimeMillis();
        super.move();
        long endMillTime = System.currentTimeMillis();
        System.out.println(endMillTime-startMillTime);

    }

    public static void main(String[] args) {
        new Tank2().move();
    }
}


interface Moveable {

    void move();
}