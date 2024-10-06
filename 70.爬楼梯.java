/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    /*
     * @date 20241005
     * 注意这里的递推方程所代表f(n)，到第n步有几种方法
     */
    public int climbStairs(int n) {
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
}
// @lc code=end

