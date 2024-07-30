/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start

import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        int j = 0;
        for(int i : nums){
                if(j < k){
                    queue.offer(i);
                    j++;
                }else{
                    queue.offer(i);
                    queue.poll();
                }
        }

        return queue.peek();
    }
}
// @lc code=end

