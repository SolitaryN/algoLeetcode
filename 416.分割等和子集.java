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
     * 
     * @date 20260822
     * 这是个 0/1 背包问题，一个物品只能取一次，如果是完全背包问题此时，一个物品可以取多次
     * 最重要的视角就是，在你眼里，你只看对于当前背包容量来说能不能装下某个物品，不用看其他，只有装得下 和 装不下两种情况，然后根据这两种情况，去推算剩余的空间能不能装满即可
     * 
     * 在想象递推公式的时候，推理理解思路
     *      1. 只站在当前的背包容量来考虑，考虑能不能装下当前物品，如果可以，我们大可先装进来，然后去看剩下的背包空间是否可以刚好被装下，此时就是去前面背包空间小的情况下是否可以装满了。  或者你也可以不装，然后看看之前不用考虑该物品是否能装下即可。
     *      2. 如果说当前背包容量完全不能装下这个物品，那就不用考虑装了，直接看看之前之前不用考虑该物品是否能装下即可
     * 
     * 这里为什么 i 在循环外围、j 在内？我理解
     *      1. 下面写法物品的可选择空间，不是一次性全给你。如果一次性全部给你，每次推导都依赖剩余空间对完整物品列表是否可放下，此时当前物品可能被多次选择，是完全背包问题，也就是 [j - num[i - 1]][n]，而且由于不能总是依赖上一行，不能进行空间压缩。不建议。
     * 
     * 
     * 方案口诀：
     * 0‑1背包：物在外，容在内，可压缩空间
     * 完全背包：物在外，容在内，可压缩空间
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
                    // 当前背包容量不足，不能装入第 i 个物品，第 i 个物品重量是nums[i-1]
                    // 此时能不能装满取决于前面 i -1 个元素是否可以装入
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 当能装入的时候，有两种选择：不装入 或 装入背包
                    // 不装入：dp[i‑1][j]
                    // 装入：dp[i - 1][j - nums[i - 1]]。如果是完全背包，可以继续用第i个物品，取 dp[i][j‑nums[i‑1]]，不是i‑1
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
     * 
     * 状态 j 表示：当前是否可以用若干个数，凑出“和为 j”的子集
     * dp[j] = 是否可以凑出 j
     * dp[j] = 原本就能凑出 j   或者  通过“凑出 j - nums[i] + nums[i]”得到 j
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

