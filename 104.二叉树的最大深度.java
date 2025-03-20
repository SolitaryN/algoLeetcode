/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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
     * DFS解决   深度
     * 
     * @date 20250320
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        return Math.max(l, r) + 1;
    }

    /*
     * @date 20241002
     * BFS 解决  广度
     * 
     * @date 20250320
     */
    public int maxDepth1(TreeNode root) {
        if (root == null)
            return 0;
        // Deque<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            // 注意，BFS处理队列的时候，需要先把size取出来，而不是每次都执行方法，否则逻辑错误
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node.left != null) 
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            ++ans;
        }
        return ans;
    }
}
// @lc code=end

