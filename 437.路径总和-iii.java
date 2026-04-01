/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
     * @date 20241003
     * 该题不能简单拆分为 L + R，独立计算从每个root出发符号条件的，再计算以左右子树根节点出发的
     * 
     * @date 20250320
     * 
     * 这个函数理解为，当前树所有路径和满足要求的路径数量
     * 递归公式：路径和数量  =  通过当前root节点的满足要求路径数  +  左子树满足路径和数 + 右子树满足路径和数
     */
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null)  return 0;

        // 求通过 root 节点满足的路径和的数量
        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);

        return ret;
    }

    // 从 root 节点出发，满足路径和等于 targetSum 的路径数量
    public int rootSum(TreeNode root, long targetSum) {
        if (root == null)  return 0;

        int ret = 0;
        if (root.val == targetSum)  ret++; // 即便符合也要继续往下找，因为有负数
        ret += rootSum(root.left, targetSum - root.val);
        ret += rootSum(root.right, targetSum - root.val);

        return ret;
    }
}
// @lc code=end

