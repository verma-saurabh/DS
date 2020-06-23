package Tree;

import java.util.LinkedList;
import java.util.Queue;

/*
222. Count Complete Tree Nodes
 */
public class NumberOfNodesInATree {
    public int countNodes(TreeNode root) {
        int count = 0;
        if (root == null) return count;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);


        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count++;

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return count;
    }
}
