/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 */

// @lc code=start

import java.util.List;

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
    // 无头结点反转
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode n = null;
        while(cur != null){
            n = cur.next;
            cur.next = pre;
            pre = cur;
            cur = n;
        }

        return pre;
    }

    /*
     * @date 20250411
     *  快慢指针 + 链表反转 + 合并两个链表
     *  注意断开前面链表，为方便这个操作，快慢指针写法有所不同，为偶数时，会指向前面的节点
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 快慢指针找到中间节点
        // 奇数节点时，slow指中间节点，偶数时，slow指前一个节点
        // 这样做方便切断前面的链表，同时不用考虑奇偶性
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode link1 = head;
        ListNode link2 = reverse(slow.next);
        slow.next = null; // 断开链表

        // 合并两个链表这里链1比链2最多多一个节点，而且只能是链1多
        // 否则报错
        while (link1 != null && link2 != null) {
            ListNode n1 = link1.next;
            ListNode n2 = link2.next;

            link1.next = link2;
            link2.next = n1;

            link1 = n1;
            link2 = n2;
        }
    }
}
// @lc code=end

