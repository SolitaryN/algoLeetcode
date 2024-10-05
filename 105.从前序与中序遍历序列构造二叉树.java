import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

/*
 * @date 20241003
 * 下面两种写法都一样，区别就是保存index的方式稍有不同，一个成员遍历，一个局部变量
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexOfIn = new HashMap<>();

        IntStream.range(0, inorder.length)
            .forEach(index -> indexOfIn.put(inorder[index], index));

        return myBuild(preorder, inorder, 0, preorder.length - 1,
            0, inorder.length, indexOfIn);
    }

    public TreeNode myBuild(int[] preorder, int[] inorder, int preL, int preR,
        int inL, int inR, Map<Integer, Integer> index){

        if (preL > preR) return null;

        int preRoot = preL; // 前序遍历根节点下标
        int rootVal = preorder[preRoot];  // 根节点的值
        int inRoot = index.get(rootVal); // 通过根节点的值获取中序根的下标
        int lTreeSize = inRoot - inL;
        TreeNode root = new TreeNode(rootVal);

        root.left = myBuild(preorder, inorder, preL + 1, preL + lTreeSize,
            inL, inRoot - 1, index);
        root.right = myBuild(preorder, inorder, preL + lTreeSize + 1, preR,
            inRoot + 1, inR, index);

        return root;
    }
}

class Solution1 {
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        IntStream.range(0, inorder.length)
            .forEach(i -> indexMap.put(inorder[i], i));

        return build(preorder, inorder, 0, n - 1,
            0, n - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd,
        int inStart, int inEnd) {

        // 递归结束条件，队列必须要有意义，这里改为inorder相关内容也可
        // if (inStart > inEnd) return null;
        if (preStart > preEnd) return null;
        
        int preRoot = preStart; // 前序遍历中的第一个节点就是根节点
        int inRoot = indexMap.get(preorder[preRoot]); // 在中序遍历中定位根节点
        TreeNode root = new TreeNode(preorder[preRoot]);    // 根节点
        int sizeLeftTree = inRoot - inStart; // 得到左子树中的节点数目

        root.left = build(preorder, inorder, preStart + 1, preStart + sizeLeftTree, 
            inStart, inRoot - 1);
        root.right = build(preorder, inorder, preStart + sizeLeftTree + 1, preEnd,
            inRoot + 1, inEnd);

        return root;
    }
}