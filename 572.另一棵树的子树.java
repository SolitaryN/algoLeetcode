/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一棵树的子树
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
    boolean ans = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null)
            return true;

        preOrder(root, subRoot);

        return ans;
    }

    void preOrder(TreeNode root, TreeNode sub){
        if(root == null)
            return;
        if(root.val == sub.val && ans == false){
            ans = helper(root, sub);
        }
        preOrder(root.left, sub);
        preOrder(root.right, sub);
    }

    boolean helper(TreeNode p, TreeNode sub){
        if(p == null && sub == null){
            return true;
        }

        boolean l, r;
        if(p != null && sub != null && p.val == sub.val){
            l = helper(p.left, sub.left);
            r = helper(p.right, sub.right);
            return l && r;
        }else{
            return false;
        }
    }

    public boolean isSubtree1(TreeNode root, TreeNode subRoot) {
        if(subRoot == null || helper(root, subRoot)) return true;

        if(root == null) return false;

        // 只要有一个树为 true，后续都为 true
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

}
// @lc code=end

