/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode H = new ListNode(-1);
        ListNode curr = head;
        ListNode preTail = H;

        while(checkCount(curr, k)){
            ListNode[] s = reverseK(curr, k);
            preTail.next = s[0]; // 尾部连接上下一个反转子链
            preTail = curr; // 更新尾部
            curr = s[1];
        }

        preTail.next = curr; // 不够 k 个结点时
        return H.next;
    }

    boolean checkCount(ListNode head, int k){
        if(head == null){
            return false;
        }

        while(head != null && k > 0){
            head = head.next;
            k--;
        }

        return k == 0;
    }

    // 返回反转之后链表的头结点，以及下一个 K 结点的开始结点
    ListNode[] reverseK(ListNode head, int k){
        ListNode pre = null;
        ListNode next;
        ListNode curr = head;

        while(curr != null && k > 0){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            k--;
        }

        return new ListNode[]{pre, curr};
    }
}
// @lc code=end

