/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    /*
     * @date 20241005
     * 注意这里的递推方程所代表f(n)，到第n步有几种方法，自底向上的解决办法
     * 
     * @date 20250308
     * 动态规划题目：明确状态、明确选择、写出状态转移方程
     */
    public int climbStairs1(int n) {
        int[] dp = new int[50];
        dp[1] = 1;
        dp[2] = 2;
        
        if(n == 1 || n == 2)
            return dp[n];

        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] +  dp[i - 2];
        }
        return dp[n];
    }

    /*
     * @date 20241103
     * 优化空间复杂度，去除Dp table占用的空间
     */
    public int climbStairs2(int n) {
        int dp1 = 1;
        int dp2 = 2;
        
        if(n == 1 || n == 2)
            return n;

        int ans = 0;
        for (int i = 3; i <= n; i++) {
            ans = dp1 + dp2;
            dp1 = dp2;
            dp2 = ans;
        }
        return ans;
    }


    /*
     * @date 20241103
     * 使用自顶向下求解方式，使用备忘录，注意这里不是 DP table
     * 这里使用自顶向下的话，空间复杂度降低不了一点，它是用来记录子问题的解，避免重复运算
     *      用来优化时间复杂度。
     */
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return dp(memo, n);
    }

    public int dp(int[] memo, int n) {
        if (n == 1 || n == 2) return n;

        if (memo[n] != 0){
            return memo[n];
        } else {
            memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
        }

        return memo[n];
    }

}
// @lc code=end

