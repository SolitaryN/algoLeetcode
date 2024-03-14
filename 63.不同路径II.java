class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int column = obstacleGrid[0].length; // 列数
        int line = obstacleGrid.length; // 行数

        int[][] ans = new int[line][column];
        
        int tag = 0; // 标记第一行和第一列是否有障碍物
        for (int i = 0; i < line; i++) {
            if(obstacleGrid[i][0] == 1){
                tag = 1;
            }
            if(tag == 0){
                ans[i][0] = 1;
            }else{
                ans[i][0] = 0;
            }
        }

        tag = 0; // 初始化一下
        for (int i = 0; i < column; i++) {
            if(obstacleGrid[0][i] == 1){
                tag = 1;
            }
            if(tag == 0){
                ans[0][i] = 1;
            }else{
                ans[0][i] = 0;
            }
        }

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                if(obstacleGrid[i][j] == 1){
                    ans[i][j] = 0;
                }
            }
        }


        for (int i = 1; i < line; i++) {
            for (int j = 1; j < column; j++) {
                if(obstacleGrid[i][j] == 1){
                    ans[i][j] = 0;
                }else{
                    ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
                }
            }
        }
        return ans[line - 1][column - 1];
    }
}