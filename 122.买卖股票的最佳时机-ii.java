/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    /*
     * @date 20241011
     * 这里不需要考虑购买次数的限制，也即dp矩阵去除表示次数限制的维度
     * 注意，股票买卖问题考虑的 base case，只需要考虑第 1 天的例如，也就是 i == 0 的时候就行
     *      因为状态转移方程都是依赖于上层的 i - 1 的dp矩阵内容，其它股票购买问题都是
     * 
     * @date 20250324
     * 这里购买次数 k 是无限次，这里不需要考虑购买次数的限制，也即dp矩阵去除表示次数限制的维度
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            // base case
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
                continue;
            }

            // 状态转移方程
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 主要下面这个转移方程，因为这里是无限次购买，所以这里不需要考虑购买次数的限制
            // 和 121 题目的区别就在这里，121 题目是只能购买一次
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        // 最后一天不持有股票
        return dp[n - 1][0];
    }
}
// @lc code=end

