/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    /*
     * @date 20241005    注意位运算符的优先级高于 + -
     * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
        有序部分用二分法查找。
        无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环. 
     */
    public int search1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            // 注意位运算符的优先级高于 + -，这里要带括号
            int mid = left + ((right - left) >> 1); 

            if(nums[mid] == target) {
                return mid;
            }else if (nums[left] <= nums[mid]) { // 左边为有序区间，有序才能二分
                if(target >= nums[left] && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;

            } else if (nums[left] > nums[mid]) { // 右边为有序区间
                if(target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return -1;
    }
}
// @lc code=end

