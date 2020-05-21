package SortingAlgorithms;

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort.insertionSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public void insertionSort(int[] arr) {

        for (int j = 1; j < arr.length; j++) {
            int current = arr[j];
            int i = j - 1;

            while (i > -1 && arr[i] > current) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = current;
        }
    }
}
