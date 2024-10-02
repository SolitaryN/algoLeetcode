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
     * 双指针问题
     * 从路程的角度出发 m + k + n = n + k + m，此时就算它们不相交，最后走到的都是null，相等退出循环
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode currA = headA;
        ListNode currB = headB;

        while(headA != headB){
            headA = (headA == null)? currB : headA.next;
            headB = (headB == null)? currA : headB.next;
        }

        return headA;
    }
}
// @lc code=end

