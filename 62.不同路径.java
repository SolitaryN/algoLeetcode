import java.util.stream.IntStream;

class Solution {
    /*
     * @date 20241001
     * 使用 回溯 求解，注意剪枝操作
     * 
     * @date 20250325
     * 不建议使用，容易爆栈，这里可以考虑使用 memoization 记忆机制，避免重复计算，避免更深的递归
     */
    public int uniquePaths1(int m, int n) {
        int[] ans = new int[1];
        dfs_helper(ans, 1, 1, m, n);
        return ans[0];
    }

    public void dfs_helper(int[] ans, int right, int down, int m, int n){ // 递归太深，栈溢出
        // 收割结果
        if(right == n && down == m) {
            ans[0]++;
            return;
        }

        // 剪枝操作
        if(right > n || down > m)
            return;

        dfs_helper(ans, right + 1, down, m, n);
        dfs_helper(ans, right, down + 1, m, n);
    }

    /*
     * @date 20241001
     * 使用动态规划，两个状态，两种选择
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];

        @date 20250325
     */
    public int uniquePaths(int m, int n) {
        int[][] ans = new int[m][n];

        IntStream.range(0, m).forEach(i -> ans[i][0] = 1);
        IntStream.range(0, n).forEach(i -> ans[0][i] = 1);

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                ans[i][j] = ans[i][j - 1] + ans[i - 1][j];
            }
        }

        return ans[m - 1][n - 1];
    }
}