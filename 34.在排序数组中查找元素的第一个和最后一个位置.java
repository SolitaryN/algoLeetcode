/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    /*
     * @date 20241005
     * 注意这里尽量用 if ... else if .... else if ... ，否则可能出现 == 判断之后，又走了后面的 else 逻辑
     * 
     * @date 20250321
     */
    public int[] searchRange(int[] nums, int target) {
        int left = leftRound(nums, target);
        int right = rightRound(nums, target);

        return new int[]{left, right};
    }

    int leftRound(int nums[], int target) {
        int left = 0, right = nums.length - 1;

        while (right >= left) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                right = mid - 1; // 往左收缩区间
            else if (nums[mid] > target)
                right = mid - 1;
            else 
                left = mid + 1;
        }

        // 注意这里和下面的寻找右边界不一样,这里是处理target不在这个数组区间，且大于数组最大值的情况
        if (left >= nums.length) return -1;
        return nums[left] == target ? left : -1;
    }

    int rightRound(int nums[], int target) {
        int left = 0, right = nums.length - 1;

        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                left = mid + 1;  // 往右收缩区间
            else if (nums[mid] > target)
                right = mid - 1;
            else 
                left = mid + 1;
        }

        // 注意这里和上面的寻找左边界不一样，这里是处理target不在这个数组区间，且小于数组最小值的情况
        if (right < 0) return -1;
        return nums[right] == target ? right : -1;
    }
}
// @lc code=end

