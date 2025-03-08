/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /*
     * @date 20241005
     * 注意这里直接把杨辉三角全部值向左对齐,同时basecase都为0，这里使用自底向上迭代方式求解
     * 
     * @date 20250308
     */
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        // 多创建和初始化一列一行，内部值刚好为0，方便递推，无需处理边界
        int[][] dp = new int[numRows + 1][numRows + 1];
        dp[1][1] = 1;
        ans.add(Arrays.asList(dp[1][1]));

        for (int i = 2; i <= numRows; i++) {
            List<Integer> line = new ArrayList<>();

            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                line.add(dp[i][j]);
            }

            ans.add(line);
        }
        return ans;
    }

    /*
     * @date 20250308
     * 优化空间复杂度，压缩dp table大小
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        // 多创建和初始化一列一行，内部值刚好为0，方便递推，无需处理边界
        int[] dp = new int[numRows + 1];
        dp[1] = 1;
        ans.add(Arrays.asList(dp[1]));

        for (int i = 2; i <= numRows; i++) {
            List<Integer> line = new ArrayList<>();
            int[] temp = new int[numRows + 1];

            for (int j = 1; j <= i; j++) {
                temp[j] = dp[j] + dp[j - 1];
                line.add(temp[j]);
            }

            System.arraycopy(temp, 0, dp, 0, numRows + 1);
            ans.add(line);
        }
        return ans;
    }
}
// @lc code=end

