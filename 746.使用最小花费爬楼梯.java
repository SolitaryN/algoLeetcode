/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[cost.length];
    }


    // 超时
    public int minCostClimbingStairs1(int[] cost) {
        return helper(cost.length, cost);
    }

    int helper(int n, int[] cost){
        if(n < 2){
            return 0;
        }

        int a = helper(n - 1, cost) + cost[n - 1];
        int b = helper(n - 2, cost) + cost[n - 2];

        return a > b ? b : a;
    }
}
// @lc code=end

