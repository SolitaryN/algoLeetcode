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
     * 
     * @date 20250304
     */
    public ListNode sortList(ListNode head) {
        // 节点为空 或 节点只有一个元素，则肯定有序，直接返回
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

        // merge 操作，合并两个已经有序的链表
        ListNode dummy = new ListNode(-1), curr = dummy;
        for(; left != null && right != null; curr = curr.next) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
        }
        curr.next = left == null ? right : left;

        return dummy.next;
    }
}
// @lc code=end

