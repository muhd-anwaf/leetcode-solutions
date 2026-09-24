class Solution {
    public int minDepth(TreeNode root) {
        return dfs(root);



    }
    private int dfs(TreeNode root){

        if(root==null) return 0;

        if(root.left ==null && root.right==null) return 1;

        if(root.left==null) return 1 + dfs(root.right);

        if(root.right==null) return 1+ dfs(root.left);

        return Math.min(dfs(root.left),dfs(root.right))+1;


    }
}