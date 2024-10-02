/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    /*
     * @date 20241001
     */
    public int minPathSum(int[][] grid) {
        int line = grid.length, column = grid[0].length;
        int[][] dp = new int[line][column];

        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum = grid[i][0] + sum;
            dp[i][0] = sum;
        }

        sum = 0;
        for (int i = 0; i < dp[0].length; i++) {
            sum  = grid[0][i] + sum;
            dp[0][i] = sum;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[line - 1][column - 1];
    }
}
// @lc code=end

