import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    /*
     * @20241003
     * 对树进行中序遍历，放入队列，之后对队列中的值进行有序性判断
     */
    public boolean isValidBST1(TreeNode root) {
        if(root == null) return true;

        Queue<Integer> queue = new ArrayDeque<>();
        inOrder(root, queue);
        int size = queue.size();
        // 这里对比 n - 1 次就行，而不是n次，否则最后一次peek为null
        for (int i = 0; i < size - 1; i++) {
            if(queue.poll() >= queue.peek())
                return false;
        }
        return true;
    }

    // 转换队列到数组的操作
    // Integer[] s = queue.toArray(new Integer[queue.size()]);

    public void inOrder(TreeNode root, Queue<Integer> queue){
        if(root == null)  return;

        inOrder(root.left, queue);
        queue.add(root.val);
        inOrder(root.right, queue);
    }

    /*
     * 20241003
     * 对左右子树的节点值设置边界，进而递归求解
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTHelper(TreeNode root, long lower, long upper) {
        if (root == null)
            return true;

        if (root.val <= lower || root.val >= upper)
            return false;

        boolean left = isValidBSTHelper(root.left, lower, root.val);
        boolean right = isValidBSTHelper(root.right, root.val, upper);
        return left && right;
    }
}