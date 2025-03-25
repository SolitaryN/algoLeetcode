/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    /*
     * @date 20241007
     * 对数组进行两次遍历
     * 
     * @date 20250325
     */
    public void sortColors1(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }

        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }

    /*
     * @date 20241007
     * 对数组进行一次遍历，用双指针保存 0 和 2 的插入位置
     * 
     * @date 20250325
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            // 因为交换之后可能还是 2，所以用 while，也只是第一次初始化时会可能用到
            while (i <= p2 && nums[i] == 2) {
                swap(nums, i, p2);
                --p2;
            }

            // 因为 i 是肯定 >= p0 的，所以不用担心交换过来的是 0
            if (nums[i] == 0) {
                swap(nums, i, p0);
                ++p0;
            }
        }
    }

    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
// @lc code=end

