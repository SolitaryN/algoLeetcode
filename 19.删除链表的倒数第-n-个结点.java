/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l1 = head;
        ListNode l2 = head;

        int i = 0;
        while(i < n && l1 != null){
            l1 = l1.next;
            i++;
        }

        if(l1 == null){
            return head.next;
        }

        while(l1.next != null){
            l1 = l1.next;
            l2 = l2.next;
        }

        l2.next = l2.next.next;
        return head;
    }
}
// @lc code=end

