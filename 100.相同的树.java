/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p, q);
    }
    
    boolean helper(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }else if(p == null && q != null){
            return false;
        }else if(p != null && q == null){
            return false;
        }


        boolean l = helper(p.left, q.left);
        boolean r = helper(p.right, q.right);

        boolean root = p.val == q.val ? true : false;

        return l && r && root;
    }
}
// @lc code=end

