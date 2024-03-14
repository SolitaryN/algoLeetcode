import java.util.ArrayDeque;
import java.util.Queue;

//Definition for a binary tree node.
 public class TreeNode {
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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }else{
            int left = countNodes(root.left);
            int right = countNodes(root.right);
            return left + right + 1;
        }
    }
}
class Solution1 {
    public int countNodes(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root != null){
            queue.offer(root);
        }
        int ans = 0;
        TreeNode temp = null;
        while(!queue.isEmpty()){
            temp = queue.poll();
            ans++;
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right); 
        }
        return ans;
    }
}