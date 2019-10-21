package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*1222. Queens That Can Attack the King*/
public class QueensAttacktheKing {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

        int[][] chess = new int[8][8];

        for (int i = 0; i < queens.length; i++) {
            chess[queens[i][0]][queens[i][1]] = 1;
        }
        List<List<Integer>> ans = new ArrayList<>();

        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {

                if (r == 0 && c == 0) {
                    continue;
                }
                List<Integer> queenAttaching = doSearch(chess, king, r, c);
                if (queenAttaching != null) {
                    ans.add(queenAttaching);
                }
            }
        }
        return ans;
    }

    public List<Integer> doSearch(int[][] chess, int[] king, int row, int column) {
        int r = king[0] + row;
        int c = king[1] + column;

        while (r >= 0 && c >= 0 && r < 8 && c < 8) {

            if (chess[r][c] == 1) {
                return Arrays.asList(r, c);
            }
            r = r + row;
            c = c + column;
        }
        return null;
    }
}
