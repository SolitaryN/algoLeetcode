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
     * 
     * 具体到每一天，看看总共有几种可能的「状态」，再找出每个「状态」对应的「选择」。
     * 穷举所有「状态」，穷举的目的是根据对应的「选择」更新状态。
     * 
     *  for 状态1 in 状态1的所有取值：
            for 状态2 in 状态2的所有取值：
                for ...
                    dp[状态1][状态2][...] = 择优(选择1，选择2...)

     * 
     * @date 20250324
     * 状态 k 的定义并不是「已进行的交易次数」，而是「最大交易次数的上限限制」。
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][k + 1][2];


        // base case
        for (int j = 0; j <= k; j++) {
            // dp[0][j][0] = 0，第一天不买股票，利润为0
            dp[0][j][0] = 0;
            // dp[0][j][1] = -prices[0]  第一天买股票，利润为-prices[0]
            dp[0][j][1] = - prices[0];
        }

        // dp 执行求解
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                // 状态转移方程
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }

        // dp[n - 1][k][0] 表示最后一天手上的股票已经卖出去了，利益最大化
        return dp[n - 1][k][0];
    }
}
// @lc code=end

