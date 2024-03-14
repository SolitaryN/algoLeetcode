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
    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode nextNode = null;

        if(head.next == null){
            return null;
        }else{
            nextNode = head.next;
        }

        while(nextNode != null){
            len++;
            nextNode = nextNode.next;
        }

        int i = 1, point = (len % 2 == 0? len/2 : len/2+1);
        nextNode = head.next;
        while(i < point){
            nextNode = nextNode.next;
            i++;
        }

        return nextNode;
    }


    // 经典解法：快慢指针，快指针走两步，满指针走一步
    // https://leetcode.cn/problems/middle-of-the-linked-list/solutions/165152/kuai-man-zhi-zhen-zhu-yao-zai-yu-diao-shi-by-liwei/
    public ListNode middleNode_slowAndFastPointer(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
    
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}