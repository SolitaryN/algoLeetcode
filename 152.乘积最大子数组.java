/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    // 这题很搞

    /*
     * @date 20241006
     * 类似于贪心的解法，这里如果有负数，则肯定是奇数个或者偶数个，此时正反遍历两倍即可求解
     * 此时使用最前面的负数和倒数第二个负数相乘，还是倒数第一和第二个负数相乘
     * 如果遇到 0 ，则乘积归 1
     */
    public int maxProduct1(int[] nums) {
        int product = 1, n = nums.length;
        int max = nums[0];

        for(int i = 0;i < n;i++){
            product *= nums[i];
            max = Math.max(max, product);
            // 如果遇到0，此时重置乘积
            if (nums[i] == 0)
                product = 1;
        }

        product = 1;
        for(int i = n - 1;i >= 0;i--){
            product *= nums[i];
            max = Math.max(max, product);
            // 如果遇到0，此时重置乘积
            if (nums[i] == 0)
                product = 1;
        }

        return max;
    }

    /*
     * @date 20241006
     * 或者使用动态规划
     * maxF[i] 表示以第 i 个元素结尾的乘积最大子数组的乘积
     * minF[i] 表示以第 i 个元素结尾的乘积最小子数组的乘积
     */
    public int maxProduct(int[] nums) {
        int length = nums.length;
        long[] maxF = new long[length];
        long[] minF = new long[length];
        for (int i = 0; i < length; i++) {
            maxF[i] = nums[i];
            minF[i] = nums[i];
        }

        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }

        int ans = (int) maxF[0];
        for (int i = 1; i < length; ++i)
            ans = Math.max(ans, (int) maxF[i]);
        return ans;
    }
}
// @lc code=end

