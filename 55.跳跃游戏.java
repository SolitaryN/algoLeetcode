/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    /*
     * @date: 20240830  20241011
     * 贪心策略解决，贪心和动态规划都一定的相似度
     */
    public boolean canJump(int[] nums) {
        int rightMost = 0; // 最远可以到达的数组下标
        int N = nums.length;

        for (int i = 0; i < N; i++) {
            // 能到 i 才能从 i 往后跳
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

