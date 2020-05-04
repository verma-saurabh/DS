package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ValidateBinaryTreeNodes_1361 {
    public boolean validateBinaryTreeNodes(
            int n, int[] leftChild, int[] rightChild) {
        // Rules for a tree
        // - each node that is not the root is exactly one time a
        // left or right child (should be in right or left)
        // - the rooth is not in left child or right child
        // - all nodes should be accessible from the root
        // all these conditions are necessare and sufficient (it is
        // possible to show it)
        // From all these we get the following algorithm:
        // 1. Find the root and make sure each other node appears
        // only once the leftChild or rightChild
        // 2. bfs from the root
        // return true if the dfs visited all nodes
        Set<Integer> nodes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nodes.add(i);
        }
        for (int val : leftChild) {
            if (val != -1) {
                if (!nodes.contains(val)) {
                    // appears many times
                    return false;
                }
                nodes.remove(val);
            }
        }
        for (int val : rightChild) {
            if (val != -1) {
                if (!nodes.contains(val)) {
                    // appears many times
                    return false;
                }
                nodes.remove(val);
            }
        }
        if (nodes.size() != 1) {
            return false;
        }
        int root = nodes.iterator().next();
        nodes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nodes.add(i);
        }
        // BFS
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            // we know there is no cycle from root because of the
            // previous counting done
            int node = q.remove();
            nodes.remove(node);
            int left = leftChild[node];
            if (left != -1) {
                q.add(left);
            }
            int right = rightChild[node];
            if (right != -1) {
                q.add(right);
            }
        }
        return nodes.isEmpty();
    }
}
