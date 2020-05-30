package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
973. K Closest Points to Origin
 */
public class KClosestPointstoOrigin {
    public static void main(String[] args) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int K = 2;
        KClosestPointstoOrigin obj = new KClosestPointstoOrigin();
        obj.kClosest(points, K);
    }

    public int[][] kClosest(int[][] points, int K) {

        TreeMap<Double, List<int[]>> map = new TreeMap<>();

        for (int[] point : points) {
            double distanceFromOrigin = 0;
            distanceFromOrigin = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
            if (map.containsKey(distanceFromOrigin)) {
                List<int[]> list = map.get(distanceFromOrigin);
                list.add(point);
                map.put(distanceFromOrigin, list);
            } else {
                List<int[]> list = new ArrayList<>();
                list.add(point);
                map.put(distanceFromOrigin, list);
            }
        }
        int i = 0;
        int[][] ans = new int[K][];
        for (Map.Entry<Double, List<int[]>> entry : map.entrySet()) {
            List<int[]> list = entry.getValue();
            for (int j = 0; j < list.size(); j++) {
                ans[i] = list.get(j);
                i++;
                if (i == K) {
                    return ans;
                }
            }
        }
        return ans;

    }
}
