package SortingAlgorithms;

public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort.selectionSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
