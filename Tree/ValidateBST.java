package Tree;

import com.sun.source.tree.Tree;

/*
98. Validate Binary Search Tree
 */
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && lower >= val) return false;
        if (upper != null && upper <= val) return false;


        if (!helper(node.right, val, upper)) return false;
        if (!helper(node.left, lower, val)) return false;
        return true;
    }
}
