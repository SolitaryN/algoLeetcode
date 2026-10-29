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

    /*
     * @date 20250327
     * 使用递归的方式解决，建议使用这种方法解决
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 出递归条件，检查从head开始是否有k个节点
        if(!check(head, k)) return head;
        
        // 反转获得新的链表头节点
        ListNode newHead = reverseK(head, k);

        // 递归处理剩余的链表，并连接到当前反转链表的尾部，这里就是用head.next
        head.next = reverseKGroup(head.next, k);

        // 返回反转后的链表头节点
        return newHead;
    }

    public boolean check(ListNode head, int k) {
        int count = 0;
        while (head != null && count < k) {
            count++;
            head = head.next;
        }
        return count == k;
    }

    public ListNode reverseK(ListNode head, int k) {
        ListNode cur = head, pre = null, temp;
        int x = 0;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            x++;
            if (x >= k){
                break;
            }
        }
        head.next = cur;
        return pre;
    }
}
// @lc code=end

