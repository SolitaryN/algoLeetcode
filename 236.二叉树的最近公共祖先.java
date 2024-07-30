/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


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
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(p == q)
            return p;
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();

        helperDFS(root, new Stack<>(), q, list1);
        helperDFS(root, new Stack<>(), p, list2);
        
        TreeNode ret = null;
        for (int i = 0; i < list1.size() && i < list2.size(); i++) {
            if(list1.get(i).val == list2.get(i).val){
                ret = list1.get(i);
            }
        }

        return ret;
    }

    // Stack 类底层使用 Vector 类进行实现，Vector 类使用的是数组进行实现
    void helperDFS(TreeNode root, Stack<TreeNode> stack, TreeNode searchNode, List<TreeNode> resList){
        if(root == null){
            return;
        }

        stack.push(root);
        if(searchNode.val == root.val){
            resList.addAll(new ArrayList<>(stack)); // 按照压栈顺序把值赋值给 list，然后addAll
            return;
        }

        helperDFS(root.left, stack, searchNode, resList);
        helperDFS(root.right, stack, searchNode, resList);
        stack.pop();
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止递归的条件
        if(root == null) return null;
        if(root == q || root == p) return root;


        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) return root;
        if(left == null || right == null) return left == null ? right : left;
        return null; // 此时左为空，右为空
    }
}
// @lc code=end

