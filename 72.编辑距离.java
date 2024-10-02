/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start

class Solution {
    /*
     * @date 20241002
     * 1、明确状态、选择    2、明确dp定义    3、写出转移方程
     */
    public int minDistance(String word1, String word2) {
        int lenW1 = word1.length();
        int lenW2 = word2.length();

        int[][] dp = new int[lenW1 + 1][lenW2 + 1];
        for (int i = 0; i < lenW2 + 1; i++)
            dp[0][i] = i;

        for (int i = 0; i < lenW1 + 1; i++)
            dp[i][0] = i;

        dp[0][0] = 0;


        for (int i = 1; i < lenW1 + 1; i++) {
            for (int j = 1; j < lenW2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int t = Math.min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1);
                    dp[i][j] = Math.min(t, dp[i][j - 1] + 1);
                }
            }
        }
        
        return dp[lenW1][lenW2];
    }
}
// @lc code=end

