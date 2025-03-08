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
     * 选择为金币包中金币的数值种类
     * 递推方程 dp[n] = 1 + min(dp[n-coins[0]], dp[n-coins[1]], ... ,dp[n-coins[k-1]])
     *  for 选择 in 选择集:
     *      min = Math.min(min, dp[i - 选择])
     *  dp[i] = min + 1;
     * 
     * @date 20250308
     */
    public int coinChange(int[] coins, int amount) {
        // 数组大小为 amount + 1，初始值设置为 amount + 1
        // 这里即为dp[i]的最大值,因为不能有比 1 元还小的硬币面值，这里只是假设有面值为1的硬币
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        // 遍历所有状态
        for (int i = 1; i < amount + 1; i++) {
            // 在多个选择中求所有选择的最小值
            for (int coin : coins) {
                // 注意会出现子问题无解的情况，此时跳过
                if (i - coin < 0) continue;

                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        // 如果还是初始值，则返回-1
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
// @lc code=end