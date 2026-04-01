/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    /*
     * @date 20240926
     * 
     * @date 20250304
     * 
     * 分为三段：m、n、x
     * m + n = k
     * m + n + x + n = 2k
     * 则 x + n = k
     * 则 m = x
     * 所以从 head 到交叉点的距离等于，快指针追到满指针后，从该位置到交叉点的距离
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // 有环
            if (slow == fast) {
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        // 无环
        return null;
    }
}
// @lc code=end

