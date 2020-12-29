package builder.v2;

/**
 * builder模式雏形 -- 构建复杂对象时，应该用builder模式
 * 未经过最后的build方法，对象已经构建成功
 */
public class Person {

    int id;
    String name;
    int age;
    double weight;
    int score;
    Location loc;

    public Person() { }

    public Person basicInfo(int id, String name, int age) {

        this.id = id;
        this.name = name;
        this.age = age;

        return this;
    }

    public Person weight(double weight) {

        this.weight = weight;

        return this;
    }

    public Person score(int score) {

        this.score = score;

        return this;
    }

    public Person loc(String street, String roomNo) {

        this.loc = new Location(street, roomNo);

        return this;
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

        Person person = new Person();
        person.basicInfo(1, "刘凯", 18).weight(54.42).score(88).loc("安定门外", "No50");

        System.out.println(person);
    }
}