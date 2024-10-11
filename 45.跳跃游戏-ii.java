/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    /*
     * @date 20241011
     * 使用贪心策略正向推导
     * 这里走第一步的时候，有一个可以跳跃到的区间，使用当前index的i和
     * end记录 [i, end], 每次更新区间 step 就加1，直到走完全程，更新几次区间就是答案
     */
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0; // 记录区间的末尾下标，很明显上来第一步就要更新
        int maxPosition = 0; // 用来更新下一个区间的右边界，当然区间左边界就是上个区间的右边界
        int steps = 0;

        // 这里只循环到 length - 1，因为题目保证一定可以跳到最后
        // 在访问最后一个元素之前，边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]); 
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
// @lc code=end

