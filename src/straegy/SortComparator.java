package straegy;

public class SortComparator<T> {

    public void sort(T[] arr, Comparator<T> comparator) {

        for (int i=0; i<arr.length-1; i++) {

            int minPos = i;

            for (int j=i+1; j<arr.length; j++) {
                minPos = comparator.compare(arr[minPos], arr[j]) == -1 ? minPos : j;
            }

            swap(arr, minPos, i);
        }
    }

    public void swap(T[] arr, int i, int j) {

        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
