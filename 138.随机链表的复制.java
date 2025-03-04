/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 随机链表的复制
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.Map;
import java.util.HashMap;

class Solution {
    /*
     * @date 20241001
     * 空间复杂度为 O(n)，时间复杂度为O(n)
     * 
     * @date 20250304
     */
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;
        for(; curr != null; curr = curr.next) {
            map.put(curr, new Node(curr.val));
        }

        curr = head;
        for(; curr != null; curr = curr.next) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
        }
        return map.get(head);
    }


    /*
     * 20241001
     * 递归解决，不过这里还是利用map保存旧新节点的映射
     * @date 20250304
     */
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }

    /*
     * @date 20241001
     * 空间复杂度为o(1)的解决办法，构造a->a'->b->b'->null
     */
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        // 创建备份节点构成 a -> a' -> ...
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        // 设置备份节点的random指向备份节点
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        // 保存函数返回值；从 a -> a' -> ... 中分割出备份链表
        Node ans = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return ans;
    }
}
// @lc code=end

