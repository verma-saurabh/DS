package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 1469. Find All the Lonely Nodes
 */
public class FIndAllLonelyNodes {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> getLonelyNodes(TreeNode root) {
        helper(root);
        return ans;
    }

    public void helper(TreeNode root) {
        if (root == null)
            return;

        if (root.left == null && root.right != null)
            ans.add(root.right.val);

        if (root.right == null && root.left != null)
            ans.add(root.left.val);

        helper(root.left);
        helper(root.right);

    }
}
