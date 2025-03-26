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
     * 
     * @date 20250303
     * @date 20250326
     */
    public ListNode reverseList1(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        ListNode next = null;

        while(curr != null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }

    /*
     * @date 20250303
     * 这里是第二种解法，使用链表的后序遍历求解
     * 
     * @date 20250326
     */
    static ListNode reverseList(ListNode head) {
        // 如果链表为空或只有一个节点，直接返回
        if (head == null || head.next == null) {
            return head;
        }

        // 递归反转子链表，这里的 newHead 是最终外层递归返回的结果，函数内不操作，直接返回
        ListNode newHead = reverseList(head.next);

        // 后序遍历操作：将当前节点的下一个节点指向当前节点
        head.next.next = head;

        // 当前节点的 next 指针置为 null，防止处理递归最后的两个元素成环
        head.next = null;

        // 返回新的头节点
        return newHead;
    }
}
// @lc code=end

