/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    /*
     * @date 20241007
     * 将后面的「大数」与前面的「小数」交换，就能得到一个更大的数.
     * 
     * 要保证增加的幅度尽可能的小：
     *     将一个 尽可能小的「大数」 与前面的「小数」交换
     *     交换后，把交换节点后的所有数 重置为升序，升序排列就是最小的排列
     * 
     * @date 20250325
     * 背诵题，妈的
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 寻找小数，此时小数是 nums[i]
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;

        if (i >= 0) {
            int j = nums.length - 1;
            // 从后面找大数，其刚好大于 nums[i]
            while (j >= i && nums[i] >= nums[j])
                j--;

            swap(nums, i, j);
        }

        reverse(nums, i + 1);
    }

    /*
     * swap 函数
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*
     * 倒置数组
     */
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
// @lc code=end

