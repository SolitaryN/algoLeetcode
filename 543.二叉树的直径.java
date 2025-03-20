/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
 */

// @lc code=start

import java.util.Optional;
import java.util.function.Supplier;

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

    int ans;
    /*
     * 二叉树的通过某个结点的直径 = 左子树高度 + 右子树高度
     * 但是注意，通过根节点的直径不一定是该树的最大直径
     * @date 20241002
     * 
     * @date 20250320
     * 某个结点的直径 = 左子树高度 + 右子树高度
     */
    public int diameterOfBinaryTree1(TreeNode root) {
        ans = 0;
        height(root);
        return ans;
    }

    public int height(TreeNode root){
        if(root == null)
            return 0;

        int l = height(root.left);
        int r = height(root.right);

        ans = Math.max(ans, l + r);

        return Math.max(l, r) + 1;
    }

    /*
     * 不使用外部变量的版本
     * @date 20241002
     */
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1]; // 本身里面自动初始化，全为0
        helper(root, ans);
        return ans[0];
    }

    /* */
    int helper(TreeNode root, int[] ans){
        if(root == null)
            return 0;

        int l = helper(root.left, ans);
        int r = helper(root.right, ans);

        ans[0] = Math.max(ans[0], l + r);

        return Math.max(l, r) + 1;
    }
}
// @lc code=end

