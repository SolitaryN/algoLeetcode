/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    /*
     * @date 20241006
     * 最长递增子序列问题，是一类经典题目
     */
    public int lengthOfLIS(int[] nums) {
        // 定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // base case：dp 数组全都初始化为 1，至少包含自己
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            // 选择出所有比当前元素小的数字，求出 dp[j] + 1的最大值，也既刚好选择出比当前元素稍小的元素接尾的子序列长度 + 1
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        return Arrays.stream(dp).max().getAsInt();
    }
}
// @lc code=end

