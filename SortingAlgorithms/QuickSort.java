package SortingAlgorithms;


public class QuickSort {
    public static void main(String[] args) {

        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        QuickSort obj = new QuickSort();
        obj.quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ,");
        }
    }

    public void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int index = partition(arr, l, r);
            quickSort(arr, l, index-1);
            quickSort(arr, index + 1, r);
        }
    }

    public int partition(int[] arr, int l, int r) {
        int pivotElement = arr[r];
        int index = l - 1;
        for (int i = l; i < r; i++) {
            if (arr[i] <= pivotElement) {
                index++;
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[index + 1];
        arr[index + 1] = arr[r];
        arr[r] = temp;
        return index + 1;
    }
}
