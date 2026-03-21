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
    public int firstMissingPositive1(int[] nums) {
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

    public int firstMissingPositive3(int[] nums) {
        int n = nums.length;

        // 把下标为 i 的元素放到 nums[i] - 1 的位置上，但要注意合法性
        //      nums[i] <= 0 或者 nums[i] >= n + 1，就不需要交换,
        //      同时要注意交换的元素不能和 nums[i] 相同，否则死循环
        // 合法交换例子：如 nums[i] = 3，就把 nums[i] 放到 nums[2] 中
        // 违法交换例子：如 nums[i] = 3，如果 nums[2] = 3，就不需要交换了，避免死循环
        for (int i = 0; i < n; i++) {
            int targetIndex = nums[i] - 1;
            while (targetIndex >= 0 && targetIndex < n && nums[i] != nums[targetIndex]) {
                swap(nums, i, targetIndex);
                // 这里必须要更新targetIndex，否则就一定造成死循环，因为此时元素已经替换，不应该再次去计算原有元素要放置的目的地，这里如果不更新，这两个元素就一直会继续swap
                targetIndex = nums[i] - 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    /*
     * @date 20250328
     * 要先明白：答案肯定是 [1 , len + 1] 中的数字
     * 使用 HashSet 来存储所有的正数，然后遍历从 1 到 n 的数字，找到第一个不在 HashSet 中的数字
     * 时间复杂度 O(n)，空间复杂度 O(n)
     *  https://leetcode.cn/problems/first-missing-positive/solutions/7703/tong-pai-xu-python-dai-ma-by-liweiwei1419/
     */
        public int firstMissingPositive2(int[] nums) {
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

    /**
     * 20260321
     * 从题目可知：
     * 1. 返回的答案是 1 到 len + 1间 （包含 len + 1） 的值
     * 
     * 考虑把数组中数组元素数值在 上述合法范围 的数值放置到该值减 1 的 index 上，之后从头遍历看看是否都完好放置，如果不是则返回该位置对应的正确的值。
     * 
     * 这里要避免swap的死循环，即拥有重复的合法元素，一直自己交换自己，死循环
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int targetIdx = nums[i] - 1;
            // 这里可以理解为，将要交换位置的元素不能是已经被正确放置的元素
            // 也可以理解为，将要和targetIdx交换的当前元素，不能等于targetIdx上放置的元素
            while (targetIdx >= 0 && targetIdx < nums.length && nums[targetIdx] - 1 != targetIdx) {
                swap(nums, i, targetIdx);
                targetIdx = nums[i] - 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

}
// @lc code=end

