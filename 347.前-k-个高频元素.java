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
import java.util.stream.Stream;

class Solution {
    /*
     * @date 20241005
     * 使用小根堆求解最高频的 k 个元素
     * 注意，使用 Arrays.stream，而不是 Stream.of，后者是可变参数列表
     * 
     * @date 20250305
     */
    public int[] topKFrequent1(int[] nums, int k) {
        // map存储数字和个数的映射  num -> number of num
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(e -> {
            map.put(e, map.getOrDefault(e, 0) + 1);
        });

        // 这里传入对比Comparator来实现堆构建过程中元素的对比，这里是小根堆
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int num = 0;
        for (Entry<Integer, Integer> e : map.entrySet()) {
            int[] element = new int[] {e.getKey(), e.getValue()};
            queue.offer(element);
            ++num;
            if (num > k)
                queue.poll();
        }

        int[] ans = new int[k];
        int len = queue.size();
        for (int i = 0; i < len; i++)
            ans[i] = queue.poll()[0];
        return ans;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(i -> {
            // get + 为空生成默认值并put，这里为空，会先put 0，然后返回该 0
            // getOrDefault 只是读，没有写这个动作
            int vl = map.computeIfAbsent(i, key -> 0);
            map.put(i, vl + 1);
        });

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.stream().mapToInt(a -> a[0]).toArray();
    }
}
// @lc code=end

