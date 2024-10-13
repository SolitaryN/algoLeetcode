/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    /*
     * @date 20241010
     * 关键就是找到一个最小值 和 最大值的差值，这里一边走一边查
     * 也可以使用动态规划进行求解
     */
    public int maxProfit1(int[] prices) {
        int max = 0;
        int minPrice = Integer.MAX_VALUE;

        // 最小值为左边界，如果遇到更小的更新左边界，否则计算差值和 max 进行对比
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice){
                minPrice = prices[i];
            } else {
                max = prices[i] - minPrice > max ? prices[i] - minPrice : max;
            }
        }
        return max;
    }

    /*
     * @date 20241011
     * 使用动态规划求解，这里是一个类型的题目套路，即股票买卖问题，见notion总结，下面是参考文档
     * https://labuladong.online/algo/dynamic-programming/stock-problem-summary/
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        // base case
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        // 从第1天开始
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], - prices[i]);
        }

        return dp[n-1][0];
    }
}
// @lc code=end

