/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start

class Solution {
    /*
     * @date 20241007
     * 把数组看出一个链表，如果这里因为有重复元素，必定有环
     * 这里把题目幻化成找环的起点
     */
    public int findDuplicate1(int[] nums) {
        // slow 和 fast 为下标，理解为指针
        int slow = 0, fast = 0;

        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // 寻找成环交叉点
        int pre1 = slow;
        int pre2 = 0;
        while (pre1 != pre2) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }


    /*
     * @date 20241007
     * 二分值域进行查找，注意是 l < r 为循环终止，此时 l 或 r 就为解
     */
    public int findDuplicate(int[] nums) {
        // 这里 l 和 r 是值域，而不是代表下标
        int l = 1, r = nums.length - 1;

        while (l < r) {
            int mid = l + ((r - l) >> 1);

            int count = 0;
            // 遍历整个区间，看看收集小于等于mid的数字数量
            for (int i = 0; i < nums.length; i++)
                if (nums[i] <= mid)
                    count++;

            // 如果数量超了，则要求的解在mid左边，包含mid也有可能，否则在右边
            if (count > mid)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}

// @lc code=end

