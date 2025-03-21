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

    /*
     * @date 20250321
     *  递归的思路
     *  化为子问题就是：从左子树找到最大路径和，从右子树找到最大路径和，
     *                  然后加上当前节点的值，就是当前节点的最大路径和，然后和记录最大值比遍历一边可得结果。
     *  但有限制条件，就是只能选择一条路径，所以在递归的过程中，需要记录当前节点的最大贡献值，
     *      也就是当前节点的值+左子树的最大贡献值+右子树的最大贡献值。
     *      对于左右子树的负数贡献值，则贡献值为0，不选择。
     */
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