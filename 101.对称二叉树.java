/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    /*
     * @date 20241002
     * 
     * @date 20250320
     */
    public boolean isSymmetric1(TreeNode root) {
        if(root == null)
            return true;

        return helper(root.left, root.right);
    }

    boolean helper(TreeNode l, TreeNode r){
        if(l == null && r == null) return true;
        if(l == null || r == null) return false; // 经过上面过滤，下面若有null

        if(l.val != r.val)
            return false;

        return helper(l.right, r.left) && helper(l.left, r.right);
    }

    /*
     * @date 20250320  请尽量使用上面的方法
     *  使用层次遍历也行，不过有巨坑，检查每一层是否对称即可
     *      但是要注意处理null 的节点
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> data = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    data.add(null);
                    continue;
                }

                data.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            
            if(!isSym(data)) {
                return false;
            }
        }

        return true;
    }

    // java 当中 null == null 为 true
    boolean isSym(List<Integer> data) {
        int left = 0, right = data.size() - 1;

        while (left < right) {
            if (data.get(left) != data.get(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
// @lc code=end

