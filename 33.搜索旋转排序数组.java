/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            // int mid = l + (r - l) / 2;
            int mid = l + ((r - l) >> 1); //int mid = l + (r - l) >> 1; 这里这样写就报错，不知道为什么
            if(nums[mid] == target)
                return mid;


            if(nums[l] <= nums[mid]){ // 寻找数组有序区间
                if(target >= nums[l] && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(target > nums[mid] && target <= nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}
// @lc code=end

