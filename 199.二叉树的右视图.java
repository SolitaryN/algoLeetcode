/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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
     * @date 20241003
     * 两种解法，BFS 和 DFS
     */
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return Collections.emptyList();

        List<Integer> ans = new ArrayList<>();
        // dfs(root, 0, ans);
        bfs(root, ans);

        return ans;
    }

    /*
     * @date 20241003
     * 每次都尽力先往右边走，再往左边走，使用size和depth的关系收割结果
     */
    void dfs(TreeNode root, int depth, List<Integer> ans){
        if(root == null)
            return;

        if(depth == ans.size())
            ans.add(root.val);

        depth += 1;
        dfs(root.right, depth, ans);
        dfs(root.left, depth, ans);
    }

    /*
     * @date 20241003
     * 注意层次遍历中的 size，需要提前保存
     */
    void bfs(TreeNode root, List<Integer> ans){
        Queue<TreeNode> queue = new LinkedList<>();

        if(root != null)
            queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if(i == levelSize - 1)
                    ans.add(node.val);

                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
        }
    }

}
// @lc code=end

