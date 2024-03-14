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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> assi = new LinkedList<>();

        if(root != null){
            assi.add(root);
            while(!assi.isEmpty()){
                List<TreeNode> assi2 = new LinkedList<>();
                List<Integer> temp = new ArrayList<>();

                // 遍历辅助 List，如果有数据就访问并把val域加入temp中保存
                /**
                 * assi2 : 因为迭代器不提供 add，而只提供 remove 方法，所以使用一个临时容器保存下一次遍历要使用的结点。
                 * now: 当前处理的结点
                 */
                Iterator iter = assi.iterator();
                while(iter.hasNext()){
                    TreeNode now = (TreeNode)iter.next();
                    temp.add(now.val);
                    
                    // 添加结点到 assi 数组中
                    if(now.left != null){
                        assi2.add(now.left);
                    }
                    if(now.right != null){
                        assi2.add(now.right);
                    }
                }
              
                ans.add(temp);   
                assi = assi2;    
            }
        }
        return ans;
    }

/**
 * 更高效的方法，使用 Java 提供的 ArrayDeque类，该类实现 Queue 和 Deque
 * 可以看到，在 while 循环的每一轮中，都是将当前层的所有结点出队列，再将下一层的所有结点入队列，这样就实现了层序遍历。
 */


public List<List<Integer>> levelOrder2(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();

    Queue<TreeNode> queue = new ArrayDeque<>();
    if (root != null) {
        queue.add(root);
    }
    while (!queue.isEmpty()) {
        int n = queue.size();
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < n; i++) { 
            TreeNode node = queue.poll(); // 删除第一个元素，并返回。
            level.add(node.val);
            if (node.left != null) {
                queue.add(node.left); // 添加左结点
            }
            if (node.right != null) {
                queue.add(node.right); // 添加右节点
            }
        }
        res.add(level);
    }

    return res;
}
}