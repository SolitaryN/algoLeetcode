class Solution {
    /*
     * @date 20241005
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