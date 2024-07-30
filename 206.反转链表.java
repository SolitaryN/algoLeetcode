/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList1(ListNode head) {
        if(head == null)
            return null;

        ListNode pre = null, cursor, next;
        cursor = head;
        
        while(cursor != null){
            next = cursor.next;
            cursor.next = pre;
            pre = cursor;
            cursor = next;
        }

        return pre;
    }


    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
        curr = next;
        }

        return pre;
    }
}
// @lc code=end

