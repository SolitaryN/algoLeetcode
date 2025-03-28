/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并 K 个升序链表
 */

// @lc code=start

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

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
     * @date 20250327
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists.length == 0)
            return null;

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        // 注意 while 循环判断中，赋值操作和判断操作的写法，需要外围加括号
        int maxIndex = 0;
        while((maxIndex = getMinIndex(lists)) != -1){
            tail.next = lists[maxIndex];
            tail = lists[maxIndex];
            lists[maxIndex] = lists[maxIndex].next;
        }
        return dummy.next;
    }

    int getMinIndex(ListNode[] nodes){
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < nodes.length; i++) {
            if(nodes[i] != null){
                if(minValue >= nodes[i].val){
                    minValue = nodes[i].val;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }


    /*
     * PriorityQueue 底层使用堆进行存储
     * 常用方法: offer和 poll，offer插入失败返回false，而不是报异常
     * poll 如果堆为空，则返回空
     * 
     * @date 20250327
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0 ){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        // 小根堆，升序排列
        Queue<ListNode> queue = new PriorityQueue<>((o1, o2) ->{
            return o1.val - o2.val;
        });

        IntStream.range(0, lists.length).forEach(i -> {
            if(lists[i] != null) {
                queue.offer(lists[i]);
            }
        });

        while(!queue.isEmpty()){
            ListNode curr = queue.poll();
            tail.next = curr;
            tail = curr;
            if(curr.next != null){
                queue.offer(curr.next);
            }
        }

        return dummy.next;
    }
}
// @lc code=end

