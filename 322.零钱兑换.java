/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    /*
     * @date 20241006
     * 状态dp[i]表示对于总钱数i，最少需要多少个硬币
     * 递推方程 dp[n] = 1 + min(dp[n-coins[0]], dp[n-coins[1]], ... ,dp[n-coins[k-1]])
     *  for 选择 in 选择集:
     *      min = Math.min(min, dp[i - 选择])
     *  dp[i] = min + 1;
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 数组大小为 amount + 1，初始值也为 amount + 1
        // 这里即为dp[i]的最大值,因为不能有比 1 元还小的硬币面值，这里只是假设有面值为1的硬币
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 1; i < amount + 1; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }

                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        // 如果还是初始值，则返回-1
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
// @lc code=end