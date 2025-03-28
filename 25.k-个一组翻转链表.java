/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode H = new ListNode(-1);
        ListNode curr = head;
        ListNode preTail = H;

        while(checkCount(curr, k)){
            ListNode[] s = reverseK(curr, k);
            preTail.next = s[0]; // 尾部连接上下一个反转子链
            preTail = curr; // 更新尾部
            curr = s[1];
        }

        preTail.next = curr; // 不够 k 个结点时
        return H.next;
    }

    boolean checkCount(ListNode head, int k){
        if(head == null){
            return false;
        }

        while(head != null && k > 0){
            head = head.next;
            k--;
        }

        return k == 0;
    }

    // 返回反转之后链表的头结点，以及下一个 K 结点的开始结点
    ListNode[] reverseK(ListNode head, int k){
        ListNode pre = null;
        ListNode next;
        ListNode curr = head;

        while(curr != null && k > 0){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            k--;
        }

        return new ListNode[]{pre, curr};
    }

    /*
     * @date 20250327
     * 使用递归的方式解决，建议使用这种方法解决
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 出递归条件，检查从head开始是否有k个节点
        if(!check(head, k)) return head;
        
        int count = 0;
        ListNode curr = head;
        ListNode pre = null;
        ListNode next = null;
        for(; curr != null && count < k; count++) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        // 递归处理剩余的链表，并连接到当前反转链表的尾部
        head.next = reverseKGroup(next, k);

        // 返回反转后的链表头节点
        return pre;
    }

    public boolean check(ListNode head, int k) {
        int count = 0;
        while (head != null && count < k) {
            count++;
            head = head.next;
        }
        return count == k;
    }

}
// @lc code=end

