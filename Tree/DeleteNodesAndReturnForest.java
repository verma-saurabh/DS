package Tree;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
1110. Delete Nodes And Return Forest
 */

public class DeleteNodesAndReturnForest {
    public static TreeNode root;
    public static int[] to_be_deleted;


    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        to_be_deleted = new int[]{3, 5};
        DeleteNodesAndReturnForest mDeleteNodesAndReturnForest = new DeleteNodesAndReturnForest();

        List<TreeNode> result = mDeleteNodesAndReturnForest.delNodes(root, to_be_deleted);
        System.out.println(result);
        //Assertions.assertEquals(result.size(),3);

    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int de : to_delete) {
            set.add(de);
        }
        //put to-delete number in hashset for O(1) lookup
        dfs(root, set, result, true);
        return result;
    }

    private void dfs(TreeNode root,
                     Set<Integer> del,
                     List<TreeNode> result, boolean isRoot) {
        //if current root does not contain in the del and it is root,
        // then add to the result
        if (!del.contains(root.val) && isRoot)
            result.add(root);

        // check parents is on the list of 'to_be_deleted'
        isRoot = del.contains(root.val);

        // As we are doing DFS, we need check left node and right node
        if (root.left != null) {
            dfs(root.left, del, result, isRoot);
            // If the child node is on the 'to_be_deleted' list, replace it will null
            if (del.contains(root.left.val))
                root.left = null;
        }

        if (root.right != null) {
            dfs(root.right, del, result, isRoot);
            // If the child node is on the 'to_be_deleted' list, replace it will null
            if (del.contains(root.right.val))
                root.right = null;
        }
    }
}