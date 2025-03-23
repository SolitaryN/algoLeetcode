/*
 * @lc app=leetcode.cn id=994 lang=java
 *
 * [994] 腐烂的橘子
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    /*
     * @date 20241008
     * 注意这题必须用 bfs，而不是dfs
     * 
     * @date 20250323
     */
    public int orangesRotting(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        
        // 用来存放坏橘子的坐标信息的元组，java没有元组，所以用2值数组
        Queue<int[]> queue = new LinkedList<>();
        // 表示新鲜橘子的数量
        int count = 0; 

        for (int row = 0; row < nr; row++) {
            for (int col = 0; col < nc; col++) {
                if (grid[row][col] == 1) {
                    // 统计新鲜橘子，等dfs遍历完坏橘子之后，如果还剩新鲜橘子，则返回-1
                    count++;
                } else if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                }
            }
        }

        // epoch 表示腐烂的轮数，或者分钟数，也可以使用 round 表示
        int epoch = 0; 
        // 判断条件要有 count > 0，如果在最后一层都是坏橘子时，会多走一次,round 多1
        while (count > 0 && !queue.isEmpty()) {
            epoch++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] badOrange = queue.poll();
                int r = badOrange[0];
                int c = badOrange[1];
                // 上下左右四个方向首先确定路径合法，然后判断是否是新鲜橘子
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r-1][c] = 2;
                    count--; // 新鲜橘子减一
                    queue.add(new int[]{r-1, c}); // 坏橘子入队
                }
                if (r+1 < nr && grid[r+1][c] == 1) {
                    grid[r + 1][c] = 2;
                    count--;
                    queue.add(new int[]{r+1, c});
                }
                if (c-1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c-1] = 2;
                    count--;
                    queue.add(new int[]{r, c-1});
                }
                if (c+1 < nc && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    count--;
                    queue.add(new int[]{r, c+1});
                }
            }
        }

        return count > 0 ? -1 : epoch;
    }
}
// @lc code=end

