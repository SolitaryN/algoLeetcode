/*
 * @lc app=leetcode.cn id=973 lang=java
 *
 * [973] 最接近原点的 K 个点
 */

// @lc code=start

import java.util.AbstractMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Map.Entry;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // 默认是小根堆
        Queue<Entry<Double, int[]>> queue = new PriorityQueue<>((o1, o2) -> {
            return Double.compare(o2.getKey(), o1.getKey()); // 改成大根堆
        });

        for(int[] temp : points){
            Double distance = Math.sqrt(Math.pow(temp[0], 2) + Math.pow(temp[1], 2));

            if(queue.size() == k){
                if(queue.peek().getKey() > distance){ // 大根堆中最大的距离大于某个点的距离，此时因为求最小距离，替换
                    queue.poll();
                    queue.offer(new AbstractMap.SimpleEntry<>(distance, new int[]{temp[0], temp[1]}));
                }
            }else if(queue.size() < k){
                queue.offer(new AbstractMap.SimpleEntry<>(distance, new int[]{temp[0], temp[1]}));
            }
        }

        int[][] ans = new int[k][2];
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            ans[i] = queue.poll().getValue();
        }

        return ans;
    }
}
// @lc code=end

