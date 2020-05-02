package graph;

import java.util.*;

/*
1387. Sort Integers by The Power Value
 */
public class SortIntegersbyThePowerValue {

    public int getKth(int lo, int hi, int k) {
        int ans = 0;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = lo; i <= hi; i++) {
            int power = computePower(i);
            if (map.get(power) != null) {
                List<Integer> list = map.get(power);
                list.add(i);
                map.put(power, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(power, list);
            }
        }
        int i = 1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            Collections.sort(list);

            for (int j = 0; j < list.size(); j++) {
                if (i == k) {
                   return list.get(j);
                } else {
                    i++;
                }
            }

        }
        return ans;

    }

    public int computePower(int n) {
        int count = 0;
        if (n == 1) {
            return 1;
        } else {
            while (n != 1) {
                if (n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = 3 * n + 1;
                }
                count++;
            }
        }
        return count;
    }
}
