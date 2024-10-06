/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 轮转数组
 */

// @lc code=start
class Solution {
    /*
     * @date 20241006
     * 使用备份数组
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] copy = new int[len];

        for (int i = 0; i < len; i++) {
            copy[(i + k) % len] = nums[i];
        }

        System.arraycopy(copy, 0, nums, 0, len);
    }

    /*
     * @date 20241006
     * 进行数组反转之后，再分批反转就行了
     * 巧解： https://leetcode.cn/problems/rotate-array/solutions/683855/shu-zu-fan-zhuan-xuan-zhuan-shu-zu-by-de-5937/
     */
    public void rotate1(int[] nums, int k){
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        for (; start < end; ++start, --end) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
        }
    }
}
// @lc code=end
