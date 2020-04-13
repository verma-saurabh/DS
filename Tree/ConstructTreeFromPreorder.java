package Tree;

/*
* 1008. Construct Binary Search Tree from Preorder Traversal
* */
public class ConstructTreeFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root= new TreeNode(preorder[0]);

        if(preorder.length==1){
            return root;
        }

        for(int i=1;i<preorder.length;i++){
            setNode(root, preorder[i]);
        }

        return root;
    }

    public void setNode(TreeNode root, int val){
        if(root.val<val){
            if(root.right==null){
                root.right=new TreeNode(val);
            }else{
                setNode(root.right, val);
            }
        }
        else{
            if(root.left==null){
                root.left=new TreeNode(val);
            }else{
                setNode(root.left, val);
            }
        }
    }
}
