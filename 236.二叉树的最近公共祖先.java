/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start

class Solution {
    /*
     * @date 20241003
     * 需要分类讨论，这里是“自底向上”进行的，带着这样的思路更好理解一点，其实也就是后序遍历
     * https://www.bilibili.com/video/BV1jd4y1B7E2/   这个讲的该题很好
     * 
     * 对于当前root，有这么几种情况：
     *      1、当前节点为null，或当前节点就是q或p，此时直接返回节点给上游，不往下递归了，这里也解决了q或p本身就是公共祖先的问题分支
     *      2、当前节点的只有左边分支或右边分支找到了节点，则返回该节点给上游
     * 
     *      3、当前节点的左右两边都有返回值，则返回root节点
     *  注意这里返回的对象是不一样的，两边都有才返回root，只有一边有则直接把下游计算结果抛给上游
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止递归的条件
        if(root == null || root == q || root == p) return root;

        // 否则就要递归左右子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null)
            return root; // 左右都有返回当前节点，那证明当前节点就是最近公共祖先，上抛就行
        
        // 只有左子树或右子树有，即左边为null或者右边为null时,直接把下游返回结果抛上去
        // 这里也隐含了，左右树都没有的情况，即 left==null && right==null，此时也返回null
        if (left == null) return right;
        else return left;
    }
}
// @lc code=end

