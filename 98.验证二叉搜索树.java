import java.util.ArrayDeque;
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
    // public boolean isValidBST(TreeNode root) {
    //     if(root == null){
    //         return true;
    //     }
        
    //     boolean a, b;
    //     if(root.left != null){
    //         if(root.val > root.left.val){
    //             a = isValidBST(root.left);
    //         }else{
    //             return false;
    //         }
    //     }else{
    //         a = isValidBST(root.left);
    //     }
    //     if(root.right!= null){
    //         if(root.val < root.right.val){
    //             b = isValidBST(root.right);
    //         }else{
    //             return false;
    //         }
    //     }else{
    //         b = isValidBST(root.right);
    //     }

    //     if(a && b)
    //         return true;
    //     else 
    //         return false;
    // }

    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        Queue<Integer> queue = new ArrayDeque<>();
        inOrder(root, queue);
        Integer[] q = (Integer[]) queue.toArray(new Integer[queue.size()]);

        boolean isSort = true;
        for (int i = 0; i < q.length; i++) {
            if(q[i] >= q[i + 1]){
                return false;
            } 
        }
        return isSort;
         
    }

    public void inOrder(TreeNode root, Queue<Integer> queue){
        if(root == null){
            return;
        }
        inOrder(root.left, queue);
        queue.add(root.val);
        inOrder(root.right, queue);
    }
    
}

class Solution2 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}

// 作者：力扣官方题解
// 链接：https://leetcode.cn/problems/validate-binary-search-tree/solutions/230256/yan-zheng-er-cha-sou-suo-shu-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
