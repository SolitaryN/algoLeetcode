/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    /*
     * @date 20240830
     */
    // dp[i] 表示前 i 间房屋能偷窃到的最高总金额
    // dp[i]=max(dp[i−2]+nums[i],dp[i−1])
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < dp.length; i++) {
            if(i - 2 < 0) {
                dp[i] = Math.max(0 + nums[i], dp[i - 1]);
            } else {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
        }

        return dp[nums.length - 1];
    }
}
// @lc code=end

