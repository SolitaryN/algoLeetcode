/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = countBit(i);
        }
        return ans;
    }

    int countBit(int i){
        int count = 0;
        while (i != 0) {
            count += (i & 1);
            i = i >> 1;
        }
        return count;
    }
}
// @lc code=end

