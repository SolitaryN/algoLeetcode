/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    /*
     * @date: 20240830
     */
    // 动态规划，dP[i] 表示以第 i 个元素为接尾的最大子序列
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    /*
     * @date: 20240830
     */
    // 贪心策略，现在和你过的好，我就和你一起，否则就抛弃你，自己开始
    public int maxSubArray1(int[] nums) {
        int maxAns = nums[0], curr = 0;

        for (int x : nums) {
            if (curr < 0)
                curr = 0;

            curr = curr + x;
            maxAns = Math.max(maxAns, curr);
        }

        return maxAns;
    }
}
// @lc code=end

