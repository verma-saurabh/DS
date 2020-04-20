package Tree;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/*
889. Construct Binary Tree from Preorder and Postorder Traversal
 */
public class TreeFromPreAndPostTraversal {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int N = pre.length;
        if (N == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        if (N == 1) return root;

        int L = 0;

        for (int i = 0; i < N; i++) {
            if (post[i] == pre[1]) {
                L = i + 1;
            }
        }

        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, L + 1)
                , Arrays.copyOfRange(post, 0, L));

        root.right = constructFromPrePost(Arrays.copyOfRange(pre, L + 1, N)
                , Arrays.copyOfRange(post, L, N - 1));
        return root;
    }

    public TreeNode constructFromPrePostUsingstack(int[] pre, int[] post) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(pre[0]);
        stack.push(root);
        for (int i = 1, j = 0; i < pre.length; ++i) {
            TreeNode node = new TreeNode(pre[i]);
            while (stack.peek().val == post[j]) {
                stack.pop();
                j++;
            }
            if (stack.peek().left == null) {
                stack.peek().left = node;
            } else {
                stack.peek().right = node;
            }
            stack.push(node);
        }
        return root;
    }
}
