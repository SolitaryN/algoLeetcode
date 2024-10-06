/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    /*
     * @date 20241006
     * 该问题可替换成背包问题：
     *      给一个可装载重量为 sum / 2 的背包和 N 个物品，每个物品的重量为 nums[i]。
     *      现在让你装物品，是否存在一种装法，能够恰好将背包装满？
     * 
     * dp[i][j] 表示对于容量为 j 的背部，能否在前 i 个物品中,刚好有能装满的序列
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        // 和为奇数时，不可能划分成两个和相等的集合
        if (sum % 2 != 0) return false;

        int n = nums.length;
        sum = sum / 2;
        boolean[][] dp = new boolean[n + 1][sum + 1]; // boolean数组初始化全为false

        // base case
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
        for (int i = 0; i <= sum; i++)
            dp[0][i] = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    // 背包容量不足，不能装入第 i 个物品，这里第 i 个物品重量是nums[i-1]
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装入或不装入背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
// @lc code=end

