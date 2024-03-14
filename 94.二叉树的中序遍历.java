import java.util.ArrayList;
import java.util.*;
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(ans, root);
        return ans;
    }

    public void inorder(List<Integer> ans, TreeNode root){
        if(root != null){
            inorder(ans, root.left);
            ans.add(root.val);
            inorder(ans, root.right);
        }else{
            return ;
        }
    }
}
