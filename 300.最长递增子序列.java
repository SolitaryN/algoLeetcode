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
     * 
     * @date 20250309
     * 动态规划：
     *  定义状态和base case
     *  定义选择
     *  写出递推过程
     */
    public int lengthOfLIS(int[] nums) {
        // 定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // base case：dp 数组全都初始化为 1，至少包含自己
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            // 从下标在0~i中的元素中选择出所有比当前元素小的数字，求出 dp[j] + 1的最大值
            // 注意这里不是选择比 i 号元素稍小的元素，因为这里还有下标所处位置的考量
            for (int j = 0; j < i; j++) {
                // 严格递增
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        return Arrays.stream(dp).max().getAsInt();
    }
}
// @lc code=end

