/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    boolean ans;
    public boolean isBalanced(TreeNode root) {
        ans = true;
        helper(root);
        return ans;
    }

    int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        int l = helper(root.left);
        int r = helper(root.right);

        if(Math.abs(l - r) > 1){
            ans = false;
        }
        return Math.max(l, r) + 1;
    }

    public boolean isBalanced1(TreeNode root){
        if(root == null)
            return true;
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <=1;
    }

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int l = height(root.left);
        int r = height(root.right);

        return Math.max(l, r) + 1;
    }

}
// @lc code=end

