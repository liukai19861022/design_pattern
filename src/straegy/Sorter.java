package straegy;

public class Sorter {

    public static void sort(int[] arr) {

        for(int i=0; i<arr.length-1; i++) {

            int minPos = i;

            for (int j=i+1; j<arr.length; j++) {

                minPos = arr[minPos] < arr[j] ? minPos : j;
            }

            swap(arr, i, minPos);
        }
    }

    static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}