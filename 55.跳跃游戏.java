/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    /*
     * @date: 20240830
     */
    // 贪心策略
    public boolean canJump(int[] nums) {
        int rightMost = 0; // 最远可以到达的数组下标
        int N = nums.length;

        for (int i = 0; i < N; i++) {
            if(rightMost >= i) {
                rightMost = Math.max(rightMost, nums[i] + i);
                if (rightMost >= N - 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
// @lc code=end

