/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    /*
     * @date 20240730 20241006
     * 因为不让使用除法，可以统计当前数组元素的前缀乘积 和 后缀乘积，然后进行相乘操作即可
     * 
     * @date 20250306
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int[] pre = new int[len]; // 除了自己，前缀的乘积
        int[] post = new int[len]; // 除了自己，后缀的乘积

        // 初始化
        pre[0] = 1;
        post[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
            post[len - 1 - i] = post[len - i] * nums[len - i];
        }

        for (int i = 0; i < len; i++)
            ans[i] = pre[i] * post[i];

        return ans;
    }
}
// @lc code=end

