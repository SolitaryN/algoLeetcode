/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    /*
     * @date 20240730 20241006
     * 因为不让使用除法，可以统计前缀乘积 和 后缀乘积 进行操作
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int[] L = new int[len]; // 除了自己，前缀的乘积
        int[] R = new int[len]; // 除了自己，后缀的乘积

        L[0] = 1;
        R[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            L[i] = L[i - 1] * nums[i - 1];
            R[len - 1 - i] = R[len - i] * nums[len - i];
        }

        for (int i = 0; i < len; i++)
            ans[i] = L[i] * R[i];

        return ans;
    }
}
// @lc code=end

