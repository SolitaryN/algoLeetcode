/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
class Solution {
    public int hammingWeight(int n) {
        int ans = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if( (n & mask) == 1)
                ans++;
            n = n >> 1;
        }
        return ans;
    }

    public int hammingWeight1(int n) {
        int ans = 0;
        while(n != 0){
            if( n % 2 == 1)
                ans++;
            n = n >> 1;
        }
        return ans;
    }
}
// @lc code=end

