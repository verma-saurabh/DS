package Tree;

public class SumOfNodesWithEvenValuedGrandParents {

    int sum=0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, null , null);
        return sum;
    }
    public void dfs(TreeNode node , TreeNode gp, TreeNode parent){
        if(node ==null){
            return;
        }
        if(gp!=null && gp.val%2==0){
            sum+=node.val;
        }
        dfs(node.left, parent, node);
        dfs(node.right, parent, node);

    }
}
