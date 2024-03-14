import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public void flatten(TreeNode root) {
        if(root == null)
            return;

        Queue<TreeNode>  queue = new ArrayDeque<>();        

        inOrder(root, queue);

        TreeNode pre = queue.poll();
        while(!queue.isEmpty()){
            TreeNode next = queue.poll();
            pre.left = null;
            pre.right = next;
            pre = next;
        }
    };

    private void inOrder(TreeNode root, Queue<TreeNode> queue){
        if(root == null){
            return;
        }
        if(root != null){
           queue.add(root); 
           inOrder(root.left, queue);
           inOrder(root.right, queue);
        }
    }
};