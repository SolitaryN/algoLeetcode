/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
     * @date 20240930
     * 该题注意保留尾部节点以进行拼接
     * 
     * @date 20250304
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode tail = dummy;
        while (tail.next != null && tail.next.next != null) {
            ListNode oldHead = tail.next;
            ListNode newHead = tail.next.next;
            tail.next = newHead;
            oldHead.next = newHead.next;
            newHead.next = oldHead;
            tail = oldHead;
        }

        return dummy.next;
    }

    /*
     * @date 20240930
     * 该题也可考虑递归，链表可以看成一个二叉树，进行递归操作，不过会有空间复杂度o(n)
     * 
     * @date 20250304
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
// @lc code=end

