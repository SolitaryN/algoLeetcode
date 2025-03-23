/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start

class Solution1 {
    /*
     * @date 20241008
     * 岛屿问题，使用 dfs 或 bfs 一般都可以解决，使用标记以访问节点的方式等
     * 该类问题思路：https://leetcode.cn/problems/number-of-islands/solutions/211211/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-
     * 也可以使用 并查集 等方式
     * 
     * @date 20250323
     * 建议还是使用dfs、bfs解决
     */
    public int numIslands(char[][] grid) { 
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                // 如果是陆地块，且没被检查过时，注意使用 '2' 表示该陆地块被检查过
                if(grid[i][j] == '1'){
                    // 标记和该岛屿连接的方块
                    dfsSignLand(i, j, grid);
                    ans++;
                }
            }
        }

        return ans;
    }

    public void dfsSignLand(int row, int col, char[][] grid){
        if(row < 0 || col < 0 || row >= grid.length 
            || col >= grid[0].length || grid[row][col] != '1'){
            // 参数违规 或 不是陆地（是水 或 被访问过的陆地）就退出递归
            //  已经被访问过的就不访问了，否则会导致无限递归，产生栈溢出
            return;
        }

        grid[row][col] = '2';
        dfsSignLand(row - 1, col, grid);
        dfsSignLand(row + 1, col, grid);
        dfsSignLand(row , col + 1, grid);
        dfsSignLand(row, col - 1, grid);
    }
}

class Solution {
    /*
     * @date 20250323
     * 使用并查集解决
     */
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int waterCount = 0;

        UnionFind uf = new UnionFind(rows * cols); // 初始化并查集

        // 遍历网格，合并相邻的陆地
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    // 当前格子是陆地，检查上下左右
                    int index = i * cols + j;
                    if (i > 0 && grid[i - 1][j] == '1') { // 上
                        uf.union(index, (i - 1) * cols + j);
                    }
                    if (i < rows - 1 && grid[i + 1][j] == '1') { // 下
                        uf.union(index, (i + 1) * cols + j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') { // 左
                        uf.union(index, i * cols + (j - 1));
                    }
                    if (j < cols - 1 && grid[i][j + 1] == '1') { // 右
                        uf.union(index, i * cols + (j + 1));
                    }
                } else {
                    waterCount++;
                }
            }
        }

        // 总格子数 - 水格子数 = 陆地格子数
        // 并查集中独立的集合数即为岛屿数量
        return uf.getCount() - waterCount;
    }
}

// 并查集实现
class UnionFind {
    private int[] parent;
    private int[] rank;
    private int count; // 连通分量的数量

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        count = size; // 初始时，每个节点都是一个独立的集合
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    // 查找根节点，并进行路径压缩
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 路径压缩
        }
        return parent[x];
    }

    // 合并两个集合
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            // 按秩合并，这里是按照树的高度合并
            // if (rank[rootX] > rank[rootY]) {
            //     parent[rootY] = rootX;
            // } else if (rank[rootX] < rank[rootY]) {
            //     parent[rootX] = rootY;
            // } else {
            //     parent[rootY] = rootX;
            //     rank[rootX]++;
            // }
            // 按秩合并，这里是按照元素个数合并
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
                rank[rootX] += rank[rootY]; // 更新 rootX 的元素个数
            } else {
                parent[rootX] = rootY;
                rank[rootY] += rank[rootX]; // 更新 rootY 的元素个数
            }

            count--; // 合并后，连通分量减少
        }
    }

    // 获取连通分量的数量
    public int getCount() {
        return count;
    }
}

// @lc code=end

