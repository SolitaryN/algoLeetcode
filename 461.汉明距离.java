/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int ans = 0;
        while (x != 0 || y != 0) {
            int a = (x & 1);
            int b = (y & 1);
            ans = (a == b)? ans : ans + 1;

            x = x >> 1;
            y = y >> 1;
        }

        return ans;
    }
}
// @lc code=end

