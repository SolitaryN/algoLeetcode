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
    public Node copyRandomList1(Node head) {
        if(head == null)
            return null;

        Map<Node, Node> map = new HashMap<>();
        Node H = new Node(-1);
        Node currH = H;
        Node curr = head;

        while(curr != null){
            Node temp = new Node(curr.val);
            map.put(curr, temp);
            currH.next = temp;

            currH = currH.next;
            curr = curr.next;
        }

        curr = head;
        currH = H.next;
        while (curr != null) {
            currH.random = map.getOrDefault(curr.random, null);

            curr = curr.next;
            currH = currH.next;
        }
        
        return H.next;
    }

    public Node copyRandomList(Node head) {
        Node curr = head;
        HashMap<Node, Node> map = new HashMap<>();

        while(curr != null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
        
            curr = curr.next;
        }

        return map.get(head);
    }
}
// @lc code=end

