package straegy;

public class SorterCat {

    public static void sort(Cat[] cats) {

        for (int i=0; i<cats.length-1; i++) {

            int minCatPos = i;

            for (int j=i+1; j<cats.length; j++) {

                minCatPos = cats[minCatPos].compareTo(cats[j]) == -1 ? minCatPos : j;
            }

            swap(cats, i, minCatPos);
        }

    }

    static void swap(Cat[] cats, int i, int j) {

        Cat temp = cats[i];
        cats[i] = cats[j];
        cats[j] = temp;
    }

}