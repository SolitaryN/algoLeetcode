/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    /*
     * @date 20241006
     * 该问题可替换成背包问题：
     *      给一个可装载重量为 sum / 2 的背包和 N 个物品，每个物品的重量为 nums[i]。
     *      现在让你装物品，是否存在一种装法，能够恰好将背包装满？
     * 
     * 状态有两个，背包容量 和 当前物品集
     * dp[i][j] 表示对于容量为 j 的背包，能否在前 i 个物品中，刚好有能装满的序列
     * 
     * @date 20250309
     */
    public boolean canPartition1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false; // 和为奇数时，不可能划分成两个和相等的集合
        sum = sum / 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1]; // boolean数组初始化全为false

        // base case
        // IntStream.range(0, n + 1).forEach(i -> dp[i][0] = true);
        // IntStream.range(0, sum + 1).forEach(i -> dp[][i] = true);
        for (int i = 0; i <= sum; i++) dp[0][i] = false;
        for (int i = 0; i <= n; i++)  dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    // 背包容量不足，不能装入第 i 个物品，这里第 i 个物品重量是nums[i-1]
                    // 此时能不能转入取决于前面 i -1 个元素是否可以装入
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 不装入或装入背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }


    /*
     * @date 20241006
     * 上述解法压缩空间复杂度
     * 
     * @date 20250309
     */
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false; // 和为奇数时，不可能划分成两个和相等的集合
        sum = sum / 2;

        int n = nums.length;
        boolean[] dp = new boolean[sum + 1];
        
        // base case
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }
}
// @lc code=end

