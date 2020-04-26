package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
LeetCode 	1120
Maximum Average Subtree
 */
public class MaximumAverageSubtree_1120 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(1);

        MaximumAverageSubtree_1120 obj = new MaximumAverageSubtree_1120();
        System.out.println("Ans is -> "+obj.maximumAverageSubtree(root));
    }

    public double maximumAverageSubtree(TreeNode root) {
        double ans = recurssion(root);
        return ans;
    }

    public double recurssion(TreeNode root) {
        if (root != null) {
            double avg = getAvg(root);
            double left = recurssion(root.left);
            double right = recurssion(root.right);
            return Math.max(Math.max(avg, left), right);
        }else {
            return 0;
        }
    }

    public double getAvg(TreeNode root) {
        double avg = 0;
        if (root == null) return avg;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        avg = list.stream().mapToInt(Integer::intValue).sum() / list.size();

        System.out.println("Average of");
        for (int i : list) {
            System.out.println(i);
        }
        System.out.println("is " + avg);

        return avg;
    }
}
