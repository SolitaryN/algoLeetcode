import java.util.ArrayDeque;
import java.util.Queue;

//Definition for a binary tree node.
// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
    /*
     * @date 20241003
     * 笨方法，使用队列记录前序遍历，之后构造链表
     * 
     * @date 20250320
     * 这个方法超级笨，不建议使用
     */
    public void flatten1(TreeNode root) {
        if(root == null)
            return;
        Queue<TreeNode>  queue = new ArrayDeque<>();        
        preOrder(root, queue);
        TreeNode pre = queue.poll();
        while(!queue.isEmpty()){
            TreeNode next = queue.poll();
            pre.left = null;
            pre.right = next;
            pre = next;
        }
    };

    private void preOrder(TreeNode root, Queue<TreeNode> queue){
        if(root == null)
            return;

        queue.add(root); 
        preOrder(root.left, queue);
        preOrder(root.right, queue);
    }

    /*
     * 定义：将以 root 为根的树拉平为链表，这里也是一个递归问题
     * @date 20241003
     * 
     * @date 20250320
     * 递归问题，寻找等价子问题，寻找出递归条件
     *  这里使用后根遍历的方式，先拉平左右子树，然后将左子树接到右子树上
     */
    public void flatten(TreeNode root) {
        // base case
        if (root == null) return;
        
        // 利用定义，把左右子树拉平
        flatten(root.left);
        flatten(root.right);

        // *** 后序遍历位置 ***
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null)
            p = p.right;
        p.right = right;
    }
};