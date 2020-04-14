package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
1104. Path In Zigzag Labelled Binary Tree
 */
public class PathInZigzagLabelledBT {
    public static void main(String[] args) {
        List<Integer> list = pathInZigZagTree(26);

        for (int i : list) {
            System.out.println(i);
        }
    }

    public static List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new ArrayList<>();
        while (label > 1) {
            result.add(label);
            int curLevel = computeLevelAndDirection(label);
            if (curLevel % 2 == 0) {
                int curLevelStart = (int) Math.pow(2, curLevel - 1);
                int distance = label - curLevelStart;
                int prevLevel = curLevel - 1;
                int next = (int) Math.pow(2, prevLevel) - 1 - distance / 2;
                label = next;
            } else {
                int distance = (int) Math.pow(2, curLevel) - 1 - label;
                int preLevel = curLevel - 1;
                int prevLevelStart = (int) Math.pow(2, preLevel - 1);
                int next = prevLevelStart + distance / 2;
                label = next;
            }
        }
        result.add(label);
        Collections.reverse(result);
        return result;
    }

    private static int computeLevelAndDirection(int label) {
        int n = 0;
        while (Math.pow(2, n) <= label) {
            n++;
        }
        return n;
    }
}