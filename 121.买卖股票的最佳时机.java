/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    /*
     * @date 20241010
     * 关键就是遍历寻找当前最小值 和 当前最大值的差值，一边走一边查
     * 也可以使用动态规划进行求解，这个更推荐，可以一下把该类问题全部解决
     * 
     * @date 20250310
     * @date 20250324
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        int minPrice = prices[0];

        // 最小值为左边界，如果遇到更小的更新左边界，否则计算差值和 max 进行对比
        // 贪心策略，阶段性保存（当前价格 - 到目前为止最低价格），即当前为止的最大利润
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            ans = Math.max(ans, prices[i] - minPrice);
        }
        return ans;
    }

    /*
     * @date 20241011
     * 使用动态规划求解，这里是一个类型的题目套路，即股票买卖问题，下面是参考文档
     * https://labuladong.online/algo/dynamic-programming/stock-problem-summary/
     * 
     * @date 20250310
     * 这是一系列题目，使用动态规划可以对该系列题目全部求解
     * 状态：该类型题有三个状态，天、到目前最多交易次数、持有股票状态，由于这里只进行一次交易，
     *      所以说，使用两个状态即可，天、持有股票状态，用0表示未持有股票，用1表示持有股票
     * 选择：买入股票、卖出股票
     * 状态转移方程：
     *  第i天未持有股票，则第i-1天可能状况有：1、第i-1天未持有股票，2、第i-1天持有股票，然后今天卖出
     *      dp[i][0] = max (dp[i-1][0], dp[i-1][1] + prices[i])
     *  第i天持有股票，则第i-1天可能状况有：1、第i-1天持有股票，2、第i-1天未持有股票，然后今天买入
     *      dp[i][1] = max (dp[i-1][1], - prices[i])
     *      这里因为限制只能买一次，所以这里使用 -prices[i]，而不是 dp[i-1][0] - prices[i]
     * 
     * @date 20250324
     * 状态转换图
     * https://labuladong.online/algo/images/stock/1.png
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        // base case
        dp[0][0] = 0;
        dp[0][1] = - prices[0];

        // 从第1天开始
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], - prices[i]); // 这里只买卖一次，所以这里是 - prices[i]
        }

        return dp[n-1][0];
    }
}
// @lc code=end

