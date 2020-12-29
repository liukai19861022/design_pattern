package builder.v3;

/**
 * builder模式
 * 必须经过最后的build方法，对象才能构建成功
 */
public class Person {

    int id;
    String name;
    int age;
    double weight;
    int score;
    Location loc;

    static Person p = new Person();
    static Person INSTANCE = new Person();

    private Person() { }

    public static Person getInstance() {
        return INSTANCE;
    }

    public Person basicInfo(int id, String name, int age) {

        p.id = id;
        p.name = name;
        p.age = age;
        Person p = new Person();

        return this;
    }

    public Person weight(double weight) {

        p.weight = weight;

        return this;
    }

    public Person score(int score) {

        p.score = score;

        return this;
    }

    public Person loc(String street, String roomNo) {

        p.loc = new Location(street, roomNo);

        return this;
    }

    public Person build() {
        return p;
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

        Person p = Person.getInstance().basicInfo(1, "刘凯", 18)
                .weight(54.42)
                .score(88)
                .loc("安定门外", "No50")
                .build();

        System.out.println(p);
    }
}