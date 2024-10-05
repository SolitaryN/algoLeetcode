/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第 K 小的元素
 */

// @lc code=start

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;



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
     * 这里使用大根堆，保存最小的k个元素
     * 每次添加元素的时候，发现超过最大容量，就去除最大元素，保证保存下来的元素是最小的k个元素
     */
    public int kthSmallest1(TreeNode root, int k) {
        PriorityQueue<TreeNode> queue = new PriorityQueue<>(k, (a, b) -> b.val - a.val);
        inOrder(root, queue, k);
        return queue.peek().val;
    }

    void inOrder(TreeNode root , Queue queue, int capacity) {
        if (root == null) return;

        inOrder(root.left, queue, capacity);
        queue.offer(root);
        if (queue.size() > capacity)
            queue.poll();
        inOrder(root.right, queue, capacity);
    }

    /*
     * @date 20241003
     * 使用栈来进行中序遍历，计数，到点输出
     */
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (--k == 0)
                break;

            root = root.right;
        }

        return root.val;
    }


    // 记录结果
    int res = 0;
    // 记录当前元素的排名
    int rank = 0;

    /*
     * 利用 BST 的中序遍历特性
     */
    int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    void traverse(TreeNode root, int k) {
        if (root == null)
            return;

        traverse(root.left, k);

        rank++; // 每遍历一个节点就加1
        if (k == rank) {
            // 找到第 k 小的元素
            res = root.val;
            return;
        }

        traverse(root.right, k);
    }
}
// @lc code=end

