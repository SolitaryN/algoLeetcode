/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
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

