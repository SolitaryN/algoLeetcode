/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start

import java.util.Set;
import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * public class ListNode {
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
     * 双指针问题，主要难点是链表长度不一致
     * 最优解从路程的角度出发，假设 A 链到达交叉点距离为 m，B 链为 n，交叉点到最后为 k
     * 则有 m + k + n = n + k + m
     * 此时就算它们不相交，最后走到的都是null，相等退出循环
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode cursorA = headA;
        ListNode cursorB = headB;

        while (cursorA != cursorB) {
            cursorA = cursorA != null ? cursorA.next : headB;
            cursorB = cursorB != null ? cursorB.next : headA;
        }

        return cursorA;
    }
}
// @lc code=end

