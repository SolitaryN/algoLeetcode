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
                if (i - coin < 0){
                    continue;
                }

                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        // 如果还是初始值，则返回-1
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    /**
     * 也可通过回溯法来求解，时间复杂度较高，是指数级别的，主要是因为没有剪枝，导致重复计算
     * 这里使用回溯法，主要是为了理解动态规划的状态转移方程，动态规划是对回溯法的优化
     * @date 20250308
     */
    int ansMin = Integer.MAX_VALUE;
    public int coinChange1(int[] coins, int amount) {
        backtrace(coins, amount, 0, 0);
        return ansMin == Integer.MAX_VALUE ? -1 : ansMin;
    }

    public void backtrace(int[] coins, int left, int index, int all) {
        if (left < 0 || index >= coins.length) return;
        if (left == 0) {
            ansMin = Math.min(ansMin, all);
            return;
        }

        // 剪枝：当前硬币数量已经 >= 当前最优解，没必要继续搜
        if(all >= ansMin) return;

        backtrace(coins, left - coins[index], index, all + 1);
        backtrace(coins, left, index + 1, all);
    }
}
// @lc code=end