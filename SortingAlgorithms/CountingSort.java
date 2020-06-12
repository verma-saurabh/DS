package SortingAlgorithms;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        CountingSort obj = new CountingSort();
        obj.countingSort(arr);
        arr = new int[]{-10, -5, -3, -1, 0, 5, 8, 10};
        obj.countingSortWithNegativeNumbers(arr);
    }

    public void countingSort(int[] arr) {

        int max = IntStream.of(arr).max().getAsInt();

        int[] index = new int[max + 1];

        for (int num : arr) {
            index[num]++;
        }

        for (int i = 1; i < index.length; i++) {
            index[i] = index[i - 1] + index[i];
        }

        int[] ans = new int[index[index.length - 1]];

        for (int i = 0; i < arr.length; i++) {
            ans[index[arr[i]] - 1] = arr[i];
            index[arr[i]]--;
        }

        for (int num : ans) {
            System.out.print(num + ",");
        }
    }

    public void countingSortWithNegativeNumbers(int[] arr) {

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        for (int i = 1; i < count.length; i++) count[i] += count[i - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        for (int num : output) {
            System.out.println(num + ",");
        }

    }
}
