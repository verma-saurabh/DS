package Tree;

import java.util.*;
/**
 * 107. Binary Tree Level Order Traversal II
 * */
public class LevelOrderBottom {
    LinkedList ans = new LinkedList();
    Queue<TreeNode> q = new ArrayDeque<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode head = root;

        head.left = new TreeNode(9);
        head.right = new TreeNode(20);
        head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);

        LevelOrderBottom obj = new LevelOrderBottom();
        obj.levelOrderBottom(root);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null) return ans;

        q.offer(root);
        while (!q.isEmpty()) {

            List<Integer> tmp = new ArrayList<>();

            int size = q.size();
            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();
                tmp.add(node.val);

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ans.addFirst(tmp);
        }

        return ans;
    }
}
