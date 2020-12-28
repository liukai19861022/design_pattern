package proxy.v01;

import java.util.Random;

/**
 * 坦克跑起来、并让坦克跑一段时间
 */
public class Tank implements Moveable{

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
        new Tank().move();
    }
}

interface Moveable {

    void move();
}