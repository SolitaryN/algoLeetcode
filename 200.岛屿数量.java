/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start

class Solution {
    /*
     * @date 20241008
     * 岛屿问题，使用 dfs 或 bfs 一般都可以解决，使用标记以访问节点的方式等
     * 该类问题思路：https://leetcode.cn/problems/number-of-islands/solutions/211211/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-
     * 也可以使用 并查集 等方式
     */
    public int numIslands(char[][] grid) { 
        int sum = 0;
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                // 如果是路地块，且没被检查过，这里使用 '2' 表示被检查过
                if(grid[i][j] == '1'){
                    // 标记和该岛屿连接的方块
                    dfsSign(i, j, grid);
                    sum++;
                }
            }
        }

        return sum;
    }

    public void dfsSign(int line, int colomn, char[][] grid){
        if(line < 0 || colomn < 0 || line >= grid.length 
            || colomn >= grid[0].length || grid[line][colomn] != '1'){
            // 参数违规 或 不是陆地（是水 或 被访问过的陆地）就退出递归
            //  已经被访问过的就不访问了，否则会导致无限递归，产生栈溢出
            return;
        }

        grid[line][colomn] = '2';
        dfsSign(line - 1, colomn, grid);
        dfsSign(line + 1, colomn, grid);
        dfsSign(line , colomn + 1, grid);
        dfsSign(line, colomn - 1, grid);
    }
}
// @lc code=end

