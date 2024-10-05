/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    /*
     * @date 20241003
     * 看下孪生兄弟题目 236，注意这里是二叉排序树 BST
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 根据 BST 树的有序性，如果都大于，则此时往右遍历
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        // 根据 BST 树的有序性，如果都小于，则此时往左遍历
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        // 如果刚好把这两个节点隔开，则该节点就是最近公共祖先
        return root;
    }
}
// @lc code=end

