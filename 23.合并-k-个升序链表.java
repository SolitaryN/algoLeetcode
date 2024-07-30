/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并 K 个升序链表
 */

// @lc code=start

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

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
    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }

        ListNode H = new ListNode(-1);
        ListNode last = H;

        while(getMinIndex(lists) != -1){
            int maxIndex = getMinIndex(lists);
            last.next = lists[maxIndex];
            last = lists[maxIndex];
            lists[maxIndex] = lists[maxIndex].next;
        }
        return H.next;
    }

    int getMinIndex(ListNode[] l){
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < l.length; i++) {
            if(l[i] != null){
                if(minValue >= l[i].val){
                    minValue = l[i].val;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }


    // PriorityQueue 底层使用堆进行存储，加入的比较器使用最小堆
    // 常用的方法是 offer 和 poll，offer插入失败返回false，而不是报异常
    // poll 如果堆为空，则返回空
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0 ){
            return null;
        }

        ListNode H = new ListNode(-1);
        ListNode last = H;

        // Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
        //     @Override
        //     public int compare(ListNode o1, ListNode o2) {
        //         return o1.val - o2.val;
        //     }
        // });

        Queue<ListNode> queue = new PriorityQueue<>((o1, o2) ->{
            return o1.val - o2.val;
        });

        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null){
                queue.offer(lists[i]);
            }
        }

        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            last.next = node;
            last = node;
            if(node.next != null){
                queue.offer(node.next);
            }
        }
        return H.next;
    }
}
// @lc code=end

