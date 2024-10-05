/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    /*
     * @date 20241005
     * 使用小根堆求第K大的元素，使用大根堆求第K小的元素
     */
    public int findKthLargest(int[] nums, int k) {
        // 默认是小根堆
        Queue<Integer> queue = new PriorityQueue<>();
        int num = 0;
        for (int i : nums) {
            if (num < k) {
                queue.offer(i);
                num++;
            }else{
                queue.offer(i);
                queue.poll(); // 把最小元素抛弃
            }
        }
        return queue.peek();
    }
}
// @lc code=end

