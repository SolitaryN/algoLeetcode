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
     * 动态规划
     *  dP[i] 表示以第 i 个元素为接尾的最大子序列
     *      有两种选择，链接前面的 dp[i - 1] 构成更大子数组，或者自己单独构成子数组的开头
     *      在这两种选择中，选择最优
     * 
     * @date 20250306
     */
    public int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        // 初始化dp中的元素
        dp[0] = nums[0];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    /*
     * @date 20250306
     * 动态规划，优化空间复杂度
     */
    public int maxSubArray(int[] nums) {
        int maxAns = nums[0];
        int dp = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            maxAns = Math.max(dp, maxAns);
        }

        return maxAns;
    }

    /*
     * @date 20240830
     * 贪心策略，现在和你过的好，我就和你一起，否则就抛弃你，自己开始
     * 
     * @date 20250306
     */
    public int maxSubArray2(int[] nums) {
        int maxAns = nums[0], curr = 0;

        for (int x : nums) {
            if (curr < 0) curr = 0;

            curr = curr + x;
            maxAns = Math.max(maxAns, curr);
        }

        return maxAns;
    }
}
// @lc code=end

