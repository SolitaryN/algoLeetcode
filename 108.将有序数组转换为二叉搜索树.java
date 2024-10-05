/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
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
     * 先对有序数组进行二分查找，查找到中间元素进行插入操作，这是一个递归操作
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return searchAndInsert(nums, 0, nums.length - 1);
    }

    TreeNode searchAndInsert(int[] nums, int start, int end) {
        if (end < start) 
            return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = searchAndInsert(nums, start, mid - 1);
        node.right = searchAndInsert(nums, mid + 1, end);
        return node;
    }
}
// @lc code=end

