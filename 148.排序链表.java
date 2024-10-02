/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
     * @date 20241001
     * 很明显，使用归并排序，首先使用快慢指针，找到中间点之前的点，断开链表，排序，归并
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(fast);

        // merge
        ListNode dummy = new ListNode(-1), curr = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = left == null ? right : left;
        return dummy.next;
    }
}
// @lc code=end

