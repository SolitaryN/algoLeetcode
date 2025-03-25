/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start

import java.util.stream.IntStream;

class Solution {
    /*
     * @date 20241001
     * 自底向上动态规划求解，这里两个状态(横纵坐标)、两种选择(上、左)
            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];

        @date 20250325
     */
    public int minPathSum(int[][] grid) {
        int rn = grid.length, cn = grid[0].length;

        int[][] dp = new int[rn][cn];
        dp[0][0] = grid[0][0];
        IntStream.range(1, dp.length).forEach(i -> dp[i][0] = grid[i][0] + dp[i - 1][0]);
        IntStream.range(1, dp[0].length).forEach(i -> dp[0][i] = grid[0][i] + dp[0][i - 1]);

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[rn - 1][cn - 1];
    }
}
// @lc code=end

