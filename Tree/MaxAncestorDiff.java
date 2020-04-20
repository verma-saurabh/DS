package Tree;
/*
1026. Maximum Difference Between Node and Ancestor
1
 */
public class MaxAncestorDiff {
    int ans=0;
    public int maxAncestorDiff(TreeNode root) {
        if(root==null){
            return 0;
        }
        getMaxDiff(root, root.val, root.val);
        return ans;
    }

    public void getMaxDiff(TreeNode root, int a , int b){
        if(root==null){
            return;
        }
        ans= Math.max(ans, Math.abs(root.val-a));
        ans= Math.max(ans, Math.abs(root.val-b));
        a= Math.min(a, root.val);
        b= Math.max(b, root.val);

        getMaxDiff(root.left,a,b);
        getMaxDiff(root.right,a,b);
    }
}
