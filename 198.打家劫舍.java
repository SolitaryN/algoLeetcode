/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start

import java.util.stream.IntStream;

class Solution {
    /*
     * @date 20240830  20241005
     * 明确状态和选择，有两种选择，求最值，得递推公式
     * dp[i] 表示前 i 间房屋能偷窃到的最高总金额
     * dp[i] = max (dp[i−2] + nums[i], dp[i−1])
     * 
     * @date 20250308
     */
    public int rob1(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        if (nums.length == 1)  return dp[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        // for 循环的另外一种写法，但是速度太慢了
        // IntStream.range(2, dp.length).forEach(i -> dp[i] = Math.max(dp[i-2] + nums[i], dp[i - 1]));

        return dp[nums.length - 1];
    }

    /*
     * @date 20241103
     * 优化 DPTable 的空间复杂度
     * 
     * @date 20250308
     */
    public int rob(int[] nums) {
        int dp_0, dp_1;
        dp_0 = nums[0];
        if (nums.length == 1)  return dp_0;

        dp_1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(dp_0 + nums[i], dp_1);
            dp_0 = dp_1;
            dp_1 = temp;
        }
        return Math.max(dp_0, dp_1);
    }
}
// @lc code=end

