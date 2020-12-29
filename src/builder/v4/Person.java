package builder.v4;

/**
 * builder模式
 * 必须经过最后的build方法，对象才能构建成功 -- 使用内部静态类方式
 */
public class Person {

    int id;
    String name;
    int age;
    double weight;
    int score;
    Location loc;


    private Person() { }

    static class PersonBuilder {
        Person p = new Person();

        public PersonBuilder basicInfo(int id, String name, int age) {

            p.id = id;
            p.name = name;
            p.age = age;

            return this;
        }

        public PersonBuilder weight(double weight) {

            p.weight = weight;

            return this;
        }

        public PersonBuilder score(int score) {

            p.score = score;

            return this;
        }

        public PersonBuilder loc(String street, String roomNo) {

            p.loc = new Location(street, roomNo);

            return this;
        }

        public Person build() {
            return p;
        }

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

        Person p = new Person.PersonBuilder().basicInfo(1, "刘凯", 18)
                .weight(54.42)
                .score(88)
                .loc("安定门外", "No50")
                .build();

        System.out.println(p);
    }
}