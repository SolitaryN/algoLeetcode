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
     */
    public int orangesRotting(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // count 表示新鲜橘子的数量
        int count = 0; 
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 1) {
                    // 统计新鲜橘子，等dfs遍历完坏橘子之后，如果还剩新鲜橘子，则返回-1
                    count++;
                } else if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        // round 表示腐烂的轮数，或者分钟数
        int round = 0; 
        // 这里判断条件要有 count > 0,如果在最后一层都是坏橘子时，会多走一次,round 多1
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] orange = queue.poll();
                int r = orange[0];
                int c = orange[1];
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

        return count > 0 ? -1 : round;
    }
}
// @lc code=end

