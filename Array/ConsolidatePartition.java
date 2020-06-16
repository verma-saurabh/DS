package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ConsolidatePartition {
    public static void main(String[] args) {
        ArrayList<Integer> used = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> total = new ArrayList<>(Arrays.asList(3, 3, 3));
        //System.out.println(ConsolidatePartition.minPartitions(used, total));
        System.out.println(ConsolidatePartition.fewestCoins1("aabcce"));
    }

    public static int minPartitions(ArrayList<Integer> used, ArrayList<Integer> total) {

        int i = 0;
        int j = 0;
        while (i < used.size()) {
            int unusedSpace = total.get(j) - used.get(i);
            int k = i + 1;
            int partition = 0;
            int index = 0;
            int max = 0;
            while (k < used.size()) {

                if (used.get(k) <= unusedSpace) {
                    if (partition <= used.get(k)) {
                        partition = used.get(k);
                        index = k;
                    }
                }
                max = Math.max(max, partition);
                k++;
            }

            used.set(i, used.get(i) + max);
            used.set(index, used.get(index) - max);
            i++;
            j++;

        }
        int count = 0;
        for (int k = 0; k < used.size(); k++) {
            if (used.get(k) == 0) {
                count++;
            }
        }

        return j - count;

    }

    public static int fewestCoins(String coins) {
        int max = coins.length();

        HashSet<Character> dict = new HashSet<>();
        for (char c : coins.toCharArray()) {
            dict.add(c);
        }
        int len = dict.size();
        for (int i = 0; i < coins.length() - len; i++) {

            for (int j = i + 1; j < coins.length(); j++) {

                String str = coins.substring(i, j + 1);

                HashSet<Character> temp1 = new HashSet<>();

                for (char ch : str.toCharArray()) {
                    temp1.add(ch);
                }

                if (dict.size() == temp1.size()) {
                    max = Math.min(max, str.length());
                }

            }
        }
        return max;
    }

    public static int fewestCoins1(String coins) {
        int max = coins.length();

        HashSet<Character> dict = new HashSet<>();
        for (char c : coins.toCharArray()) {
            dict.add(c);
        }
        int len = dict.size();

        int i = 0;
        int j = 0;
        boolean turn = false;
        while (i <= j && j<coins.length()) {
            String str = coins.substring(i, j + 1);
            HashSet<Character> temp1 = new HashSet<>();

            for (char ch : str.toCharArray()) {
                temp1.add(ch);
            }
            if (dict.size() != temp1.size()) {
                j++;
            } else {
                i++;
                max = Math.min(max, str.length());
            }
        }
        return max;
    }

}
