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
     * 
     * @date 20261019
     * 递归子问题不是判断一棵树是否对称，而是判断两棵树是否互为镜像；
     */
    public boolean isSymmetric1(TreeNode root) {
        if(root == null)
            return true;

        return isMirror(root.left, root.right);
    }

    boolean isMirror(TreeNode l, TreeNode r){
        if(l == null && r == null) return true;
        if(l == null || r == null) return false; // 经过上面过滤，下面若有null

        return l.val == r.val && isMirror(l.right, r.left) && isMirror(l.left, r.right);
    }

    /*
     * @date 20250320  请尽量使用上面的方法
     *  使用层次遍历也行，不过有巨坑，检查每一层是否对称即可
     *      但是要注意处理null 的节点
     * 
     * 核心：把「层序遍历入队」和「对称性校验」拆成两件独立的事；
     *      遍历好结尾，数据好校验对称性。
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

        boolean isSym(List<Integer> list) {
        int len = list.size();
        for (int i = 0; i < len/2; ++i) {
            Integer left = list.get(i);
            Integer right = list.get(len - 1 - i);
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (!left.equals(right)) {
                return false;
            }
        }
        return true;
    }


    // java 当中 null == null 为 true
    boolean isSym2(List<Integer> data) {
        int left = 0, right = data.size() - 1;
        while (left < right) {
            Integer leftVal = data.get(left);
            Integer rightVal = data.get(right);
            if (leftVal == null && rightVal == null) {
                continue;
            }
            if (leftVal == null || rightVal == null) {
                return false;
            }
            if (!leftVal.equals(rightVal)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
// @lc code=end

