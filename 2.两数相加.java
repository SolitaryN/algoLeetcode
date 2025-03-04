/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start

import java.nio.file.LinkOption;

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
     * 注意，返回值不会算入到空间复杂度里面，所以说这里空间复杂度为o(1)
     * 
     * @date 20250304
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        int carry = 0; // carry 表示进位
        while (l1 != null || l2 != null || carry == 1) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int res = v1 + v2 + carry;
            carry = res / 10;
            res = res % 10;
            curr.next = new ListNode(res);
            curr = curr.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return dummy.next;
    }
}
// @lc code=end

