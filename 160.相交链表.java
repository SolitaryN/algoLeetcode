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
public class Solution {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while(headA != null && headB != null){
            if(!set.contains(headA)){
                set.add(headA);
                headA = headA.next;
            }else{
                return headA;
            }

            if(!set.contains(headB)){
                set.add(headB);
                headB = headB.next;
            }else{
                return headB;
            }
        }
        while (headA != null) {
            if(!set.contains(headA)){
                set.add(headA);
                headA = headA.next;
            }else{
                return headA;
            }
        }

        while (headB != null) {
            if(!set.contains(headB)){
                set.add(headB);
                headB = headB.next;
            }else{
                return headB;
            }
        }

        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode currA = headA;
        ListNode currB = headB;

        while(headA != null || headB != null){
            if(headA == headB){
                return headA;
            }

            headA = (headA == null)? currA : headA.next;
            headB = (headB == null)? currB : headB.next;
        }

        return null;
    }
}
// @lc code=end

