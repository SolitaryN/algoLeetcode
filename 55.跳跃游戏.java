/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    /*
     * @date: 20240830  20241011
     * 贪心策略解决，贪心和动态规划有一定的相似度
     * 
     * @date: 20250324
     * 最远可以到达的数组下标大于等于数组长度时，返回true
     */
    public boolean canJump(int[] nums) {
        int rightMostIndex = 0; // 最远可以到达的数组下标
        int N = nums.length;

        for (int i = 0; i < N; i++) {
            // 能到 i 才能从 i 往后跳
            if(rightMostIndex >= i) {
                rightMostIndex = Math.max(rightMostIndex, nums[i] + i);
                if (rightMostIndex >= N - 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
// @lc code=end

