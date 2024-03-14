// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
// 此题没有头结点，此时就应该手动添加头结点，方便解题
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode meta = new ListNode(0);
        meta.next = head;
        ListNode last = meta, preDelete = meta, delete;

        int i = 0;
        while(i < n){
            last = last.next;
            i++;
        }
        while(last.next != null){
            last = last.next;
            preDelete = preDelete.next;
        }
        delete = preDelete.next;
        preDelete.next = preDelete.next.next;
        delete.next = null;
        return head;
    }
}