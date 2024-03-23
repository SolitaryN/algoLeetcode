/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

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
    public boolean hasCycle1(ListNode head) {
        if(head == null){
            return false;
        }

        HashSet<ListNode> set = new HashSet<>();
        set.add(head);
        while (head.next != null) {
            if(set.contains(head.next)){
                return true;
            }
            set.add(head.next);
            head = head.next;
        }

        return false;
    }

    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
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

