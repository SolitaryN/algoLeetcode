class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return maxSum;
    }

    public int getMax(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getMax(root.left);
        left = left > 0 ? left : 0; // 左子树贡献值
        int right = getMax(root.right);
        right = right > 0 ? right : 0; // 右子树贡献值

        int newPrice = root.val + left + right; 
        maxSum = Math.max(newPrice, maxSum);

        return root.val + Math.max(right, left); // 当前树的贡献值
    }
}