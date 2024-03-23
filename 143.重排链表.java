/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 */

// @lc code=start

import java.util.List;

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
    public void reorderList1(ListNode head) {
        if(head == null)
            return;

        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;

        l2 = reverse(l2);
        mergeList(head, l2);
    }

    // 无头结点反转
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode n = null;
        while(cur != null){
            n = cur.next;
            cur.next = pre;
            pre = cur;
            cur = n;
        }

        return pre;
    }

    void mergeList(ListNode l1, ListNode l2){
        ListNode n1 = null;
        ListNode n2 = null;
        while(l1 != null && l2 != null) {
            n1 = l1.next;
            n2 = l2.next;

            l1.next = l2;
            l2.next = n1;

            l1 = n1;
            l2 = n2;
        }
    }

    ListNode middleNode(ListNode l){
        ListNode slow = l;
        ListNode fast = l;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void reorderList(ListNode head) {
        List<ListNode> l = new ArrayList<>();

        ListNode temp = head;
        while(temp != null){
            l.add(temp);
            temp = temp.next;
        }

        int i = 0, j = l.size() - 1;
        while(i < j){
            l.get(i).next = l.get(j);
            i++;

            if(i == j){
                break;
            }

            l.get(j).next = l.get(i);
            j--;
        }

        l.get(i).next = null;
    }
}
// @lc code=end

