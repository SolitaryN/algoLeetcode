/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start

import java.nio.file.LinkOption;
import java.util.Currency;

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
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {

    /*
     * @date 20240930
     * 
     * @date 20250304
     * 
     * 使用dummy头结点更方便
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        // 给链表加入头结点
        ListNode dummy = new ListNode(-1);
        ListNode currPoint = dummy;        

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                currPoint.next = list2;
                list2 = list2.next;
            } else {
                currPoint.next = list1;
                list1 = list1.next;
            }
            currPoint = currPoint.next;
        }

        currPoint.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}
// @lc code=end

