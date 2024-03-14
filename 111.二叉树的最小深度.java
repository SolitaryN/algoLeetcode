import javax.swing.RootPaneContainer;

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
    public int minDepth(TreeNode root) {
        return  inOrder(root, 1); 
    }

    // low = 1 + min(left_low + right_low)
    public int inOrder(TreeNode node, int high){
        if(node == null){
            return 0;
        }

        if(node.left == null && node.right == null){
            return 1;
        }

        int left = inOrder(node.left, high + 1);
        int right = inOrder(node.right, high + 1);

        if(node.left == null || node.right == null){
            return left + right + 1;
        }

        return Math.min(left, right) + 1;
    }
}