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
    /*
     * @date 20240926
     * 链表反转问题，此时需要三个指针，指向 pre、curr、next，返回 pre
     */
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

