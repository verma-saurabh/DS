package Tree;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * 257. Binary Tree Paths
 * */
public class BinaryTreePaths {

    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return ans;
        }
        String str = new String();
        dfs(root, str);
        return ans;
    }

    public void dfs(TreeNode root, String str) {
        if (root == null) {
            return;
        }
        str = str + root.val;
        if (root.right == null && root.left == null) {
            ans.add(str);
            return;
        }
        str=str+"->";
        dfs(root.left, str);
        dfs(root.right, str);


    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}