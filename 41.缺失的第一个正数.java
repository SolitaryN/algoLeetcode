/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    /*
     * @date 20250328
     *  使用再hash表的方式来存储所有在范围内的正数
     *  然后遍历hash表，找到第一个不在hash表中的正数
     * https://leetcode.cn/problems/first-missing-positive/solutions/7703/tong-pai-xu-python-dai-ma-by-liweiwei1419
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 把下标为 i 的元素放到 nums[i] - 1 的位置上，但要注意合法性
        //      nums[i] <= 0 或者 nums[i] >= n + 1，就不需要交换,
        //      同时要注意交换的元素不能和 nums[i] 相同，否则死循环
        // 合法交换例子：如 nums[i] = 3，就把 nums[i] 放到 nums[2] 中
        // 违法交换例子：如 nums[i] = 3，如果 nums[2] = 3，就不需要交换了，避免死循环
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*
     * @date 20250328
     * 要先明白：答案肯定是 [1 , len + 1] 中的数字
     * 使用 HashSet 来存储所有的正数，然后遍历从 1 到 n 的数字，找到第一个不在 HashSet 中的数字
     * 时间复杂度 O(n)，空间复杂度 O(n)
     *  https://leetcode.cn/problems/first-missing-positive/solutions/7703/tong-pai-xu-python-dai-ma-by-liweiwei1419/
     */
        public int firstMissingPositive1(int[] nums) {
        int len = nums.length;

        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        for (int i = 1; i <= len ; i++) {
            if (!hashSet.contains(i)){
                return i;
            }
        }

        return len + 1;
    }

}
// @lc code=end

