/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;
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
public class Solution {
    /*
     * @date 20240926
     * 如果慢指针也进入了环，此时最多不需要两圈快指针就会追上满指针
     * 如果超过两圈，说明满指针在环外，与假设矛盾，所以不超过两圈就会追上
     * https://labuladong.online/algo/essential-technique/linked-list-skills-summary/#%E5%88%A4%E6%96%AD%E9%93%BE%E8%A1%A8%E6%98%AF%E5%90%A6%E5%8C%85%E5%90%AB%E7%8E%AF
     * 
     * @date 20250304
     * 
     */
    public boolean hasCycle(ListNode head) {
        if(head == null)  return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }
}
// @lc code=end

