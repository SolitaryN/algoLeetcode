/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    /*
     * @date 20241005
     * 自底向上求解，使用迭代的方法，注意下面递推公式的 + 1，加的值代表 j * j
     *  dp(n) = min{dp(n - j * j), j ∈ (1, sqrt(n))} + 1;
     * 注意，这个题不能简单使用 dp(n) = dp(n - sqrt(n).intvalue) + 1，不是最优解，
     *  例如，32 这个值，最优解为 16 + 16,如果使用上面这个的话就是 25 + 4 + 1 + 1 + 1
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            Integer min = Integer.MAX_VALUE;
            // 寻找一个平方数最接近于 i，然后再加上剩余的 dp[n] = 1 + dp[n - j*j]
            for (int j = 1; j * j <= i; j++)
                min = Math.min(min, dp[i - j * j]);

            dp[i] = 1 + min;
        }

        return dp[n];
    }
}
// @lc code=end