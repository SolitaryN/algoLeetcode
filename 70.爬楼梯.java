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
     */
    public int climbStairs1(int n) {
        int[] ans = new int[50];
        ans[1] = 1;
        ans[2] = 2;
        
        if(n == 1 || n == 2)
            return ans[n];

        for (int i = 3; i < ans.length; i++) {
            ans[i] = ans[i - 1] +  ans[i - 2];
        }
        return ans[n];
    }

    /*
     * @date 20241103
     * 优化空间复杂度，去除Dp table占用的空间
     */
    public int climbStairs2(int n) {
        int step1 = 1;
        int step2 = 2;
        
        if(n == 1 || n == 2)
            return n;

        int ans = 0;
        for (int i = 3; i <= n; i++) {
            ans = step1 + step2;
            step1 = step2;
            step2 = ans;
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

