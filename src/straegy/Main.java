package straegy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        int[] a = {9, 2, 3, 5, 7, 1, 4};
        Sorter sorter = new Sorter();
        sorter.sort(a);
        System.out.println(Arrays.toString(a));

        Cat[] cats = {
            new Cat(10, 1),
            new Cat(19, 3),
            new Cat(5, 2),
        };
        SortComparable.sort(cats);
        for (Iterator<Cat> iterator = Arrays.stream(cats).iterator(); iterator.hasNext();) {

            Cat next = iterator.next();
            System.out.println(next);
        }

        Dog[] dogs = {new Dog(1,1), new Dog(3,3), new Dog(2, 2)};
        SortComparable.sort(dogs);
        System.out.println(Arrays.toString(dogs));

        System.out.println("----------------------------------------------------------------------------");

        Dog[] dogs2 = {new Dog(1,1), new Dog(3,31), new Dog(2, 2)};
        SortComparator<Dog> dogSortComparator = new SortComparator<Dog>();
        dogSortComparator.sort(dogs2, new DogHeightComparator());
        System.out.println("DogHeightComparator : "+ Arrays.toString(dogs2));
        System.out.println("----------------------------------------------------------------------------");

        Dog[] dogs3 = {new Dog(7,1), new Dog(3,3), new Dog(12, 2)};
        SortComparator<Dog> dogSortComparator2 = new SortComparator<Dog>();
        dogSortComparator.sort(dogs3, new DogWeightComparator());
        System.out.println("DogWeightComparator : "+ Arrays.toString(dogs3));

        System.out.println("----------------------------------------------------------------------------");
        Cat[] cats1 = {new Cat(10, 2), new Cat(12, 5), new Cat(6, 1)};
        SortComparator<Cat> catSortComparator = new SortComparator<>();
        catSortComparator.sort(cats1, ((o1, o2) -> {
            if (o1.height > o2.height) return -1;
            else if (o1.height < o2.height) return 1;
            else return 0;
        }));
        System.out.println("CatMaxWeightComparator : "+ Arrays.toString(cats1));


    }
}
