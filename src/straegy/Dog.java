package straegy;

public class Dog implements Comparable<Dog> {

    private int weight;
    private int height;

    public Dog(int weight, int height) {

        this.weight = weight;
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int compareTo(Dog d) {

        if (this.weight > d.weight) return 1;
        else if (this.weight < d.weight) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
