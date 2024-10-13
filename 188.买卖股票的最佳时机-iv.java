/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    /*
     * @date 20241011
     * 使用状态机模型来考虑动态规划问题，可见notion总结买卖股票题目，或参考下面文档理解
     * https://labuladong.online/algo/dynamic-programming/stock-problem-summary/
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][k + 1][2];

        // dp 执行求解
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                // base case 处理
                if (i - 1 == -1) {
                    dp[i][j][0] = 0;  // dp[0][j][0] = 0，第一天不买股票，利润为0
                    dp[i][j][1] = - prices[i];  // dp[0][j][1] = -prices[0]  第一天买股票，利润为-prices[0]
                    continue;
                }

                // 状态转移方程
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }

        return dp[n - 1][k][0];
    }
}
// @lc code=end

