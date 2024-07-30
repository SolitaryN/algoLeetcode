/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 */

// @lc code=start

import java.util.ArrayList;
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null)
            return ans;
        
        // helpDFS(root, 0, ans);
        helpBFS(root, ans);

        return ans;
        
    }

    void helpDFS(TreeNode root, int depth, List<Integer> ans){
        if(root == null){
            return;
        }

        if(depth == ans.size()){
            ans.add(root.val);
        }

        depth += 1;
        helpDFS(root.right, depth, ans);
        helpDFS(root.left, depth, ans);
    }

    void helpBFS(TreeNode root, List<Integer> ans){
        Queue<TreeNode> queue = new LinkedList<>();

        if(root != null){
            queue.offer(root);
        }

        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // for (int i = 0; i < queue.size(); i++) { // 注意这里不能用 queue.size，它的大小在算法执行时动态变化
            for (int i = 0; i < levelSize; i++) {
                TreeNode temp = queue.poll();
                if(i == 0){
                    ans.add(temp.val);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
                if(temp.left != null){
                    queue.offer(temp.left);
                }
            }
        }
    }

}
// @lc code=end

