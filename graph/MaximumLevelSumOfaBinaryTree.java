package graph;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
1161. Maximum Level Sum of a Binary Tree
 */
public class MaximumLevelSumOfaBinaryTree {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int ans = 0;
        if (root == null) {
            return ans;
        }
        queue.add(root);
        list.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(temp.stream().mapToInt(Integer::intValue).sum());
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                ans = i;
            }
        }
        return ans;
    }
}
