/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

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
    /*
     * @date 20240926
     * 可以使用单链表后序遍历处理，不过函数压栈带来的空间复杂度
     * 在 isPalindrome1 中优化空间复杂度，使用快慢指针
     */
    ListNode left;
    boolean ans = true;

    public boolean isPalindrome(ListNode head) {
        left = head;
        traverse(head);
        return ans;
    }

    /*
     * 后序遍历链表
     * https://labuladong.online/algo/data-structure/palindrome-linked-list/#%E4%B8%80%E3%80%81%E5%88%A4%E6%96%AD%E5%9B%9E%E6%96%87%E5%8D%95%E9%93%BE%E8%A1%A8
     */
    public void traverse(ListNode head) {
        if (head == null) return;

        traverse(head.next);

        if (head.val != left.val) {
            ans = false;
        }
        left = left.next;
    }

    public boolean isPalindrome1(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        /*
         * 如果 fast 不为 null，此时节点数量为奇数
         * 此时 slow 再往下走一步，虽然没必要，不过这样最模板，有时候需要这样
         */
        if (fast != null) {
            slow = slow.next;
        }

        ListNode tail = reverse(slow);

        while (tail != null) {
            if (tail.val != head.val) return false;
            tail = tail.next;
            head = head.next;
        }

        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }
}
// @lc code=end

