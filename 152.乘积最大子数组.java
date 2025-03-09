/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    // 这题很搞，经典

    /*
     * @date 20241006
     * 类似于贪心的解法，这里如果有负数，则肯定是奇数个或者偶数个，此时正反遍历两倍即可求解
     * 此时使用最前面的负数和倒数第二个负数相乘，还是倒数第一和倒数第二个负数相乘
     * 如果遇到 0 ，则乘积归 1
     *      如果不考虑0，既把0当成分割线，则可能的几种情况：全为正数、偶数个负数、奇数个负数
     * 
     * @date 20250309
     * 该解法只适用于 数组中所有元素的绝对值要么为0，要么 >= 1 才可以，因为要求是子数组，元素需要连续。
     * 如果此时从后往前乘，此时最后面的元素为 1/2 ，此时可能是需要舍弃这个元素的
     */
    public int maxProduct(int[] nums) {
        int product = 1, n = nums.length;
        int ans = nums[0];

        for(int i = 0;i < n;i++){
            product *= nums[i];
            ans = Math.max(ans, product);
            // 如果遇到0，此时重置乘积
            if (nums[i] == 0)
                product = 1;
        }

        product = 1;
        for(int i = n - 1;i >= 0;i--){
            product *= nums[i];
            ans = Math.max(ans, product);
            // 如果遇到0，此时重置乘积
            if (nums[i] == 0)
                product = 1;
        }

        return ans;
    }

    /*
     * @date 20241006
     * 或者使用动态规划，这里因为有负数，需要保存最小数组乘积
     * maxF[i] 表示以第 i 个元素结尾的乘积最大子数组的乘积
     * minF[i] 表示以第 i 个元素结尾的乘积最小子数组的乘积
     * 
     * @date 20250309
     * 动态规划
     *  明确状态，由于子数组有正负元素，此时最大值可能为
     *      1、前面最小负数积 * 负数自己
     *      2、前面最大正数积 * 正数自己
     *      3、从自己开始，独身（例如，自身是正数，前面的最大和最小积都是负数）
     *      所以需要记录两组状态，一组记录前面子数组最大值、一组记录前面子数组最小值
     *      base case 就都是自身
     *  明确选择，上述说明的三种选择
     *  写出状态转移方程
     */
    public int maxProduct2(int[] nums) {
        int length = nums.length;
        // 这里其实用 int 也可以，因为题目说明了积都为32位数字
        long[] maxDp = new long[length];
        long[] minDp = new long[length];

        for (int i = 0; i < length; i++) {
            maxDp[i] = nums[i];
            minDp[i] = nums[i];
        }

        for (int i = 1; i < length; ++i) {
            maxDp[i] = Math.max(maxDp[i - 1] * nums[i], 
                            Math.max(minDp[i - 1] * nums[i], nums[i]));
            minDp[i] = Math.min(minDp[i - 1] * nums[i],
                            Math.min(maxDp[i - 1] * nums[i], nums[i]));
        }

        int ans = (int) maxDp[0];
        for (int i = 1; i < length; ++i)
            ans = Math.max(ans, (int) maxDp[i]);
        return ans;
    }
}
// @lc code=end

