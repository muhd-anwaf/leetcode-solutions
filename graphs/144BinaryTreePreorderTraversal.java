class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        dfs(root,preOrder);
        return preOrder;

    }
    private void dfs(TreeNode node,List<Integer> preOrder){
        if (node==null) return;
        preOrder.add(node.val);
        dfs(node.left,preOrder);
        dfs(node.right,preOrder);
        return;

    }
}