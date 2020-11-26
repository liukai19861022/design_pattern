package straegy;

public class Cat implements Comparable<Cat>{
    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    //定义了猫是如何比较大小的
    @Override
    public int compareTo(Cat cat) {

        if (this.weight > cat.weight) return 1;
        else if (this.weight < cat.weight) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
