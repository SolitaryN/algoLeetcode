/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Map.Entry;

class Solution {
    /*
     * @date 20241005
     * 使用小根堆求解最高频的 k 个元素
     * 注意，尽量使用 Arrays.stream，而不是 Stream.of，后者是可变参数列表
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(e -> {
            map.put(e, map.getOrDefault(e, 0) + 1);
        });

        int num = 0;
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for (Entry<Integer, Integer> e : map.entrySet()) {
            int[] element = new int[] {e.getKey(), e.getValue()};
            queue.offer(element);
            ++num;
            if (num > k)
                queue.poll();
        }

        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++)
            ans[i] = queue.poll()[0];
        return ans;
    }
}
// @lc code=end

