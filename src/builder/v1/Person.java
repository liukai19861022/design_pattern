package builder.v1;

/**
 * 构建对象过于复杂（参数过多） -- 此时应该考虑用builder模式
 */
public class Person {

    int id;
    String name;
    int age;
    double weight;
    int score;
    Location loc;

    public Person(int id, String name, int age, double weight, int score, String street, String roomNo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.score = score;
        this.loc = new Location(street, roomNo);


    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", score=" + score +
                ", loc=" + loc +
                '}';
    }
}

class Location {
    String street;
    String roomNo;

    public Location(String street, String roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }
}

class Main {

    public static void main(String[] args) {

        Person person = new Person(1, "刘凯", 18, 54.42, 88,"安定门外", "No50");

        System.out.println(person);
    }
}