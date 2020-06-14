package Array;

import java.util.Arrays;
/*
787. Cheapest Flights Within K Stops
 */
public class CheapestFlightWithKStops {
    public static void main(String[] args) {

        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int n = 3;
        int src = 0, dst = 2, k = 1;
        CheapestFlightWithKStops obj = new CheapestFlightWithKStops();
        System.out.println(obj.findCheapestPrice(n, flights, src, dst, k));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i <= K; i++) {
            int[] tmpDist = Arrays.copyOf(dist, dist.length);
            for (int[] edge : flights) {
                int u = edge[0];
                if (dist[u] == Integer.MAX_VALUE) continue;
                int v = edge[1];
                int w = edge[2];
                tmpDist[v] = Math.min(tmpDist[v], dist[u] + w);
            }
            dist = tmpDist;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
