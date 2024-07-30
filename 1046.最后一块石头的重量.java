/*
 * @lc app=leetcode.cn id=1046 lang=java
 *
 * [1046] 最后一块石头的重量
 */

// @lc code=start

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        // 默认是小根堆，这里使用大根堆
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for(int stone : stones){
            queue.offer(stone);
        }

        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();

            if(a > b){
                queue.offer(a - b);
            }else if(a < b){
                queue.offer(b - a);
            }
        }

        return queue.size() == 1? queue.poll() : 0;

    }
}
// @lc code=end

