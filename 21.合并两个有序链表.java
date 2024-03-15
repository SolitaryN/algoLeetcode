/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null){
            if(list1 == null)
                return list2;
            else
                return list1;
        }

        ListNode ans, tail;
        if(list1.val <= list2.val){
            ans = list1;
            tail = list1;
            list1 = list1.next;
        }else{
            ans = list2;
            tail = list2;
            list2 = list2.next;
        }

        ListNode ptr1 = list1;
        ListNode ptr2 = list2;
        while (ptr1 != null && ptr2 != null) {
            if(ptr1.val <= ptr2.val){
                tail.next = ptr1;
                ptr1 = ptr1.next;
            }else{
                tail.next = ptr2;
                ptr2 = ptr2.next;
            }
            tail = tail.next;
        }
        if(ptr1 != null){
            tail.next = ptr1;
        }
        if(ptr2 != null){
            tail.next = ptr2;
        }
        return ans;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        if(list1.val <= list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                prev.next = list1;
                list1 = list1.next;
            }else{
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        prev.next = (list1 == null) ? list2 : list1;

        return prehead.next;
    }
}
// @lc code=end

