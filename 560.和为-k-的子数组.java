/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    /*
     * @date 20241002
     *  开始想到滑动窗口，然后敲完发现k可以是负值，然后想到了动态规划，然后放弃了，看题解了
     *  该题使用前缀和 + 哈希表优化求解
     *  前缀和 是 从开头元素到现在元素的和，如果到现在的和刚好等于 K + 某一个前缀和 则收割结果
     * 
     * @date 20250302
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int currPre = 0; // 记录每次遍历的前缀和

        int len = nums.length;
        Map<Integer, Integer> record = new HashMap<>();
        // key 为现有前缀和，value 为现有该前缀和的数量
        record.put(0, 1); // 前缀和为 0 默认有一个

        for (int i = 0; i < len; i++) {
            currPre += nums[i];
            if (record.containsKey(currPre - k)) {
                ans += record.get(currPre - k);
            }
            record.put(currPre, record.getOrDefault(currPre, 0) + 1);
        }

        return ans;
    }

    /*
     * @date 20250302  暴力枚举解法
     * 考虑以 i 结尾和为 k 的连续子数组个数
     */
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
// @lc code=end

