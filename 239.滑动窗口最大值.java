/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    /*
     * @date 20250327
     * 使用单调队列解决，保存窗口内的最小值的索引在后面
     *  然后最大值索引需要注意不能超过当前窗口范围
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        List<Integer> ans = new LinkedList<>();  // 存储滑动窗口的最大值
        Deque<Integer> deque = new LinkedList<>(); // 单调队列，存储索引

        for (int i = 0; i < k - 1; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }


        for (int i = k - 1; i < n; i++) {
            // 移除超出窗口的元素，每次最多移除一个就可以了
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 移除队列中所有比当前元素小的元素（保持单调递减）
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 将当前元素的索引加入队列
            deque.offerLast(i);

            ans.add(nums[deque.peekFirst()]);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 20260319
     * 使用单调队列解决，单调队列是单调栈的增强版本，主要使用单调队列（单调栈）通过只和标杆数据对比，减少对比次数，进而提高计算速度。
     * 遇到可以抽象为 求在数组中某个方向的最值问题，就可以考虑使用单调栈，如果再加上窗口大小限制条件，此时可以使用单调队列
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i] ) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        ans.add(nums[deque.peekFirst()]);

        for (int i = k; i < nums.length; i++) {
            // 这里写while更符合直觉，把居于高位的不在窗口内的数据删除了，虽然用if也对，此时窗口只可能排除一个值，也就是最左边的那个，保证它不是最大值就行，但用while更符合直觉
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            ans.add(nums[deque.peekFirst()]);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end

