/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {

    boolean ans = false;
    boolean[][] visited;

    /*
     * @date 20241009
     * 使用回溯，这里记录元素是否重合到之前走的路径，如果是则返回，不能走旧路径上的元素
     * 这里使用 visited 用来表示是否之前的路径访问过
     * 
     * @date 20250322
     * 注意使用visited记录是否访问过，如果访问过则返回
     * 也可以使用set记录访问过的路径的元组(i,j)，不过要重写hashCode和equals方法
     * 这里使用违规就剪枝的操作，来让逻辑更加清晰
     */
    public boolean exist1(char[][] board, String word) {
        int nr = board.length, nc = board[0].length;
        visited = new boolean[nr][nc];

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                backtrack(i, j, board, 0, word);
            }
        }
        return ans;
    }

    void backtrack(int row, int col, char[][] board, int index, String word) {
        int len = word.length();
        int nr = board.length, nc = board[0].length;

        if (len == index) {
            ans = true;
            return;
        }

        // 违规操作，剪枝返回
        if (row >= nr || row < 0 || col >= nc || col < 0)
            return;
        if (visited[row][col] == true ||
                word.charAt(index) != board[row][col])
            return;

        // 四个选择，上下左右
        visited[row][col] = true;
        backtrack(row + 1, col, board, index + 1, word);
        backtrack(row - 1, col, board, index + 1, word);
        backtrack(row, col + 1, board, index + 1, word);
        backtrack(row, col - 1, board, index + 1, word);
        visited[row][col] = false;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int idx) {
        if (idx == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx))
            return false;

        char temp = board[i][j];
        board[i][j] = '#'; // 临时标记已访问
        boolean res = dfs(board, i + 1, j, word, idx + 1) || dfs(board, i - 1, j, word, idx + 1)
                || dfs(board, i, j + 1, word, idx + 1) || dfs(board, i, j - 1, word, idx + 1);
        board[i][j] = temp; // 回溯恢复
        return res;
    }
}
// @lc code=end
