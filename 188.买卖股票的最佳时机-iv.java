/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    // 使用动态规划中的状态机模型来解决
    public int maxProfit(int k, int[] prices) {
        int [][][] dp = new int[1010][110][2];
        for (int i = 0; i < 1010; i++) {
            for (int j = 0; j < 110; j++) {
                for (int j2 = 0; j2 < 2; j2++) {
                    dp[i][j][j2] = -1;
                }
            }
        }

        for (int i = 0; i <= prices.length; i++) {
            dp[i][0][0] = 0;
        }

        for (int i = 1; i <= prices.length - 1; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i - 1]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i - 1]);
            }
            
        }
        
        int ans = 0;
        for (int i = 1; i <= prices.length; i++) {
            ans = Math.max(dp[prices.length][i][0], ans);
        }
        return ans;
    }
}
// @lc code=end

