/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
     * @date 20241002
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        return helper(root.left, root.right);
    }

    boolean helper(TreeNode l, TreeNode r){
        if(l == null && r == null) return true;
        if(l == null || r == null) return false; // 经过上面过滤，下面若有null

        if(l.val != r.val)
            return false;

        return helper(l.right, r.left) && helper(l.left, r.right);
    }
}
// @lc code=end

