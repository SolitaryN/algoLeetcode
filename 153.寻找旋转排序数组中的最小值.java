/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    /*
     * @date 20241005
     * 两种情况，要么有序要么无序
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            // 有序时
            if(nums[left] <= nums[right]) 
                return nums[left];

            // 无序时，最终 right == left，此时会返回
            int mid = left + ((right - left) >> 1);
            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else if (nums[left] > nums[mid]) {
                //因mid此时可能为最小值，所有是right = mid,而不是right = mid - 1
                right = mid;
            }
        }

        return -1;
    }
}
// @lc code=end

