/*
 * @lc app=leetcode.cn id=2 lang=java
 * @lcpr version=30203
 *
 * [2] 两数相加
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null? l2 : l1;
        }

        int carry = 0;

        ListNode resHead = new ListNode(-1);
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode temp = resHead;
        while(curr1 != null && curr2 != null){
            int sum = curr1.val + curr2.val + carry;
            carry = sum / 10;

            temp.next = new ListNode(sum % 10);
            temp = temp.next;

            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while(curr1 != null){
            int sum = curr1.val + carry;
            carry = sum / 10;

            temp.next = new ListNode(sum % 10);
            temp = temp.next;

            curr1 = curr1.next;
        }

        while(curr2 != null){
            int sum = curr2.val + carry;
            carry = sum / 10;

            temp.next = new ListNode(sum % 10);
            temp = temp.next;

            curr2 = curr2.next;
        }

        if(carry == 1){
            temp.next = new ListNode(1);
        }

        return resHead.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null? l2 : l1;
        }

        int carry = 0;

        ListNode resHead = new ListNode(-1);
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode temp = resHead;
        while(curr1 != null && curr2 != null){
            int sum = curr1.val + curr2.val + carry;
            carry = sum / 10;

            temp.next = new ListNode(sum % 10);
            temp = temp.next;

            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        if(curr1 != null){
            temp.next = helper(curr1, carry);
        }
        if(curr2 != null){
            temp.next = helper(curr2, carry);
        }
        if(curr1 == null && curr2 == null && carry == 1){
            temp.next = new ListNode(1);
        }

        return resHead.next;
    }

    ListNode helper(ListNode l, int carry){
        ListNode resH = new ListNode(-1);
        ListNode temp = resH;

        while(l != null){
            int sum = l.val + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            l = l.next;
        }

        if(carry == 1){
            temp.next = new ListNode(1);
        }
        return resH.next;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,4,3]\n[5,6,4]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n[0]\n
// @lcpr case=end

// @lcpr case=start
// [9,9,9,9,9,9,9]\n[9,9,9,9]\n
// @lcpr case=end

 */

