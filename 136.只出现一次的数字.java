/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    /*
     * @date 20241006
     * 使用异或操作
     * 
     * @date 20250325
     * a ^ a = 0    a ^ 0 = a
     * 任何数和 0 异或的结果仍然是原来的数，即 a ^ 0 = a
     * 异或运算满足交换律和结合律，即 a ^ b ^ c = a ^ c ^ b = c ^ a ^ b
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++)
            ans = ans ^ nums[i];

        return ans;
    }
}
// @lc code=end

