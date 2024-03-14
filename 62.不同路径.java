class Solution {
    public int uniquePaths1(int m, int n) {
        int[] ans = new int[1];
        
        dfs_helper(ans, 0, 0, m, n);

        return ans[0];
    }

    public void dfs_helper(int[] ans, int right, int down, int m, int n){ // 递归太深，栈溢出
        if(right == n - 1 && down == m - 1){
            ans[0]++;
            return;
        }

        if(right >= n || down >= m){ // 剪枝操作
            return;
        }

        if(right < n){
            dfs_helper(ans, right + 1, down, m, n);
        }
        if(down < m){
            dfs_helper(ans, right, down + 1, m, n);
        }
    }

    public int uniquePaths(int m, int n) { //正解
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            ans[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            ans[0][i] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                ans[i][j] = ans[i][j - 1] + ans[i - 1][j];
            }
        }

        return ans[m - 1][n - 1];
    }
}