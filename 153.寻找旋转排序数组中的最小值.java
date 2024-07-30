/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin1(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            if(nums[l] <= nums[r]){
                return nums[l];
            }

            // int mid = (l + r) / 2;
            int mid = l + (r - l) / 2;
            if(nums[mid] >= nums[l]){
                l = mid + 1;
            }else if(nums[mid] < nums[l]){
                r = mid;
            }
        }

        return 0;
    }

public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while(l < r){
            int mid = l + (r - l) / 2;

            if(nums[mid] <= nums[r]){
                r = mid;
            }else {
                l = mid + 1;
            }
        }

        return nums[r];
    }
}
// @lc code=end

