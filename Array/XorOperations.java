/*
package Array;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XorOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int tc = scan.nextInt();


        List<Pair<Integer, Integer>> pair = new ArrayList<>();
        int maxIndex = Integer.MIN_VALUE;
        scan.nextLine();
        for (int i = 0; i < tc; i++) {
            String line = scan.nextLine();
            String[] arr = line.split(" ");
            pair.add(new Pair<>(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])));
            maxIndex = Math.max(maxIndex, Math.max(Integer.valueOf(arr[i]), Integer.valueOf(arr[i])));
        }
        int[] xor = new int[maxIndex];
        xor[0] = 1;
        for (int i = 1; i < maxIndex; i++) {
            xor[i] = (i + 1) ^ xor[i - 1];
        }

        for (int i = 1; i < maxIndex; i++) {
            xor[i] += xor[i - 1];
        }

        for (int i = 0; i < pair.size(); i++) {
            int ans = 0;
            int key = pair.get(i).getKey();
            int value = pair.get(i).getValue();

            if(key==1){
                ans= xor[value-1];
            }
            else {
                ans=xor[value-1]-xor[key-2];
            }

            */
/*for (int j = pair.get(i).getKey(); j <= pair.gevt(i).getValue(); j++) {
                ans += xor[j - 1];
            }*//*


            System.out.println(ans);

        }
    }
}
*/
