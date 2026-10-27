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
     * 
     * @date 20250321
     * 当数组或子数组无序时，最小值只会出现在无序的区间
     * 
     * @date 20261027
     * 如果从左区间判断，则要注意天然有序情况
     */
    public int findMin1(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            // 有序时
            if(nums[left] <= nums[right]) 
                return nums[left];

            // 无序时，最终 right == left，此时会返回
            int mid = left + ((right - left) >> 1);
            if (nums[left] <= nums[mid]) {
                // 无序时，当左边有序时，最小值一定在右边
                left = mid + 1;
            } else if (nums[left] > nums[mid]) {
                // 无序时，当左边无序时，最小值一定在左边，同时也可能是 mid 下标元素最小
                // 因mid此时可能为最小值，所有是right = mid,而不是right = mid - 1
                right = mid;
            }
        }

        return -1;
    }

    /**
     * 
     * 而 `l <= r` 的语义是：l、r 这个位置本身还没检查，
     *  允许 l 和 r 重合时进入循环做判断，两套范式不能混
     * 找目标值，可能要访问 mid 位置、mid 本身可能是答案，用 `l <= r`
     * 
     * 缩小区间，答案一定保留在区间内，退出时 l==r 就是答案，用 `l < r`
     * 
     * 右半边天然可以保证：如果它有序，最小值在[l, mid]，否则在[mid + 1, r]
     * 如果天然有序，不需要额外判断，天然在最小值在左半边
     * 
     * 如果有重复元素，最后加 else { r-- }
     * 因为无法判断最小值在哪一边，此时 r-- 稳定缩小区间，且不会把最小值排除掉
     * 即便最小值是 [r]，也不会被排除掉，因为 r-- 后，mid 仍然是和 [r] 相等的元素，保留在区间内
     * 
     * @date 20261027
     */
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] < nums[r]){
                r = mid;
            }
        }
        return nums[l];
    }
}
// @lc code=end

